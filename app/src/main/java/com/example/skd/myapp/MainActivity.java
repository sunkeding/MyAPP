package com.example.skd.myapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skd.myapp.activitys.BlurActivity;
import com.example.skd.myapp.activitys.CountDownActivity;
import com.example.skd.myapp.activitys.FilterViewActivity;
import com.example.skd.myapp.activitys.HandlerThreadActivity;
import com.example.skd.myapp.activitys.MenuLayoutActivity;
import com.example.skd.myapp.activitys.MulpitleSelectedActivity;
import com.example.skd.myapp.activitys.NetActivity;
import com.example.skd.myapp.activitys.NineOldActivity;
import com.example.skd.myapp.activitys.PicassoActivity;
import com.example.skd.myapp.activitys.PingActivity;
import com.example.skd.myapp.activitys.RXjavaActivity;
import com.example.skd.myapp.activitys.Test1Activity;
import com.example.skd.myapp.activitys.TestMyActivity;
import com.example.skd.myapp.activitys.ViewHelperActivity;
import com.example.skd.myapp.activitys.ViewPagerActivity;
import com.example.skd.myapp.activitys.ViewStubAndMergeActivity;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.bean.SampleBean;
import com.example.skd.myapp.views.RecycleViewDivier;
import com.taobao.android.SophixManager;
import com.taobao.android.listener.PatchLoadStatusListener;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recycleview)
    RecyclerView recycleview;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    private ArrayList<SampleBean> list = new ArrayList<>();
    private String appVersion = "";

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_main);
        initHotfix();
    }

    private void initHotfix() {
        try {
            this.appVersion = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            this.appVersion = "1.0.0";
        }

        SophixManager.getInstance().setContext(this.getApplication())
                .setAppVersion(appVersion)
                .setAesKey(null)
                .setEnableDebug(false)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onload(final int mode, final int code, final String info, final int handlePatchVersion) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Mode:").append(mode).append(" Code:").append(code).append(" Info:").append(info).append(" HandlePatchVersion:").append(handlePatchVersion);
//                                Log.d("MainActivity", stringBuilder.toString());
                                SophixManager.getInstance().queryAndLoadNewPatch();//拉取最新补丁
                            }
                        });

                        /*if (code == PatchStatus.CODE_PATCH_PREPAREFIX) {
                            Toast.makeText(MainActivity.this, "正在准备补丁请勿离开", Toast.LENGTH_SHORT).show();
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            Toast.makeText(MainActivity.this, "补丁准备完毕, 请重启应用", Toast.LENGTH_SHORT).show();
                        } else if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Toast.makeText(MainActivity.this, "补丁加载成功", Toast.LENGTH_SHORT).show();
                        }*/
                    }
                }).initialize();
    }

    @Override
    public void initView() {
        compareInteger();//  得出的结论是  Integer 类型的值在[-128,127] 期间,Integer 用 “==”是可以的。  为什么会出现这个情况呢，实际上在我们用Integer a = 数字；来赋值的时候Integer这个类是调用的public static Integer valueOf(int i)这个方法。
    }

    private void compareInteger() {
        Integer a = 50;
        Integer b = 50;
        Integer c = 1000;
        Integer d = 1000;
        if (a == b) {
            Log.d("MainActivity", "相等");
        } else {
            Log.d("MainActivity", "不相等");

        }
        if (c == d) {
            Log.d("MainActivity", "相等");
        } else {
            Log.d("MainActivity", "不相等");

        }
        if (c.equals(d)) {
            Log.d("MainActivity", "相等");

        } else {
            Log.d("MainActivity", "不相等");

        }
    }

    @Override
    public void initData() {
        list.add(new SampleBean("Retrofit相关"));
        list.add(new SampleBean("RXJAVA相关"));
        list.add(new SampleBean("HandlerThread"));
        list.add(new SampleBean("Rxpermissions"));
        list.add(new SampleBean("ViewStub And Merge"));
        list.add(new SampleBean("Ping++支付"));
        list.add(new SampleBean("分秒倒计时"));
        list.add(new SampleBean("返回首页功能"));
        list.add(new SampleBean("FilterView"));
        list.add(new SampleBean("NineOldAndroids动画"));
        list.add(new SampleBean("ViewHelper"));
        list.add(new SampleBean("高斯模糊"));
        list.add(new SampleBean("MenuLayoutActivity"));
        list.add(new SampleBean("ViewPager"));
        list.add(new SampleBean("测试布局"));
        list.add(new SampleBean("picasso加载JPG"));
        list.add(new SampleBean("RecycleView多选效果"));
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.addItemDecoration(
                new RecycleViewDivier(this, LinearLayoutManager.HORIZONTAL, 2,
                        Color.parseColor("#f0f0f0")));
        MyAdapter myAdapter = new MyAdapter(list);
        recycleview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private ArrayList<SampleBean> mydata;

        public MyAdapter(ArrayList<SampleBean> list) {
            mydata = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(View.inflate(MainActivity.this, R.layout.item_introduce, null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            MyViewHolder myholder = (MyViewHolder) holder;
            myholder.tvIntrodecu.setText(mydata.get(position).getIntroduce());
            myholder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (mydata.get(position).getIntroduce()) {
                        case "Retrofit相关":

                            startActivity(new Intent(MainActivity.this, NetActivity.class));
//                            Log.d("MyAdapter", null);//先故意写个闪退，再通过打补丁的方式修复
//                            Toast.makeText(MainActivity.this, "修复了闪退的BUG", Toast.LENGTH_SHORT).show();
                            break;
                        case "RXJAVA相关":
                            startActivity(new Intent(MainActivity.this, RXjavaActivity.class));
                            break;
                        case "HandlerThread":
                            startActivity(new Intent(MainActivity.this, HandlerThreadActivity.class));
                            break;
                        case "Rxpermissions":
                            checkpermission();

                            break;
                        case "ViewStub And Merge":
                            startActivity(new Intent(MainActivity.this, ViewStubAndMergeActivity.class));


                            break;
                        case "Ping++支付":
                            startActivity(new Intent(MainActivity.this, PingActivity.class));


                            break;
                        case "分秒倒计时":
                            startActivity(new Intent(MainActivity.this, CountDownActivity.class));


                            break;
                        case "返回首页功能":
                            startActivity(new Intent(MainActivity.this, Test1Activity.class));


                            break;
                        case "FilterView":
                            startActivity(new Intent(MainActivity.this, FilterViewActivity.class));


                            break;
                        case "NineOldAndroids动画":
                            startActivity(new Intent(MainActivity.this, NineOldActivity.class));


                            break;
                        case "ViewHelper":
                            startActivity(new Intent(MainActivity.this, ViewHelperActivity.class));


                            break;
                        case "高斯模糊":
                            startActivity(new Intent(MainActivity.this, BlurActivity.class));


                            break;
                        case "MenuLayoutActivity":
                            startActivity(new Intent(MainActivity.this, MenuLayoutActivity.class));


                            break;
                        case "ViewPager":
                            startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));


                            break;
                        case "测试布局":
                            startActivity(new Intent(MainActivity.this, TestMyActivity.class));


                            break;
                        case "picasso加载JPG":
                            startActivity(new Intent(MainActivity.this, PicassoActivity.class));


                            break;
                        case "RecycleView多选效果":
                            startActivity(new Intent(MainActivity.this, MulpitleSelectedActivity.class));


                            break;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


    }

    private void checkpermission() {
        RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
        rxPermissions.request(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            Log.d("MyAdapter", "已获取权限");
                        } else {
//                            checkpermission();
                            Log.d("MyAdapter", "未获取权限");

                        }
                    }
                });
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_introdecu)
        TextView tvIntrodecu;
        @Bind(R.id.root_view)
        LinearLayout rootView;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
