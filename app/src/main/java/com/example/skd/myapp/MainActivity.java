package com.example.skd.myapp;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skd.myapp.activitys.AddViewActivity;
import com.example.skd.myapp.activitys.AiGeCustomViewActivity;
import com.example.skd.myapp.activitys.AlarmActivity;
import com.example.skd.myapp.activitys.AnimActivity;
import com.example.skd.myapp.activitys.BlurActivity;
import com.example.skd.myapp.activitys.BlurTwoActivity;
import com.example.skd.myapp.activitys.CoordinatorLayoutActivity;
import com.example.skd.myapp.activitys.CountDownActivity;
import com.example.skd.myapp.activitys.DialogFragActivity;
import com.example.skd.myapp.activitys.EnumActivity;
import com.example.skd.myapp.activitys.FilterViewActivity;
import com.example.skd.myapp.activitys.FlowLayoutActivity;
import com.example.skd.myapp.activitys.H5ToNativeActivity;
import com.example.skd.myapp.activitys.HandlerThreadActivity;
import com.example.skd.myapp.activitys.InvokeActivity;
import com.example.skd.myapp.activitys.LevelViewActivity;
import com.example.skd.myapp.activitys.LikeDialogActivity;
import com.example.skd.myapp.activitys.ListActivity;
import com.example.skd.myapp.activitys.ListViewDemo;
import com.example.skd.myapp.activitys.LocalPushActivity;
import com.example.skd.myapp.activitys.MenuLayoutActivity;
import com.example.skd.myapp.activitys.MulpitleSelectedActivity;
import com.example.skd.myapp.activitys.NetActivity;
import com.example.skd.myapp.activitys.NewShadowActivity;
import com.example.skd.myapp.activitys.NineOldActivity;
import com.example.skd.myapp.activitys.OkHttpActivity;
import com.example.skd.myapp.activitys.PaintActivity;
import com.example.skd.myapp.activitys.PicassoActivity;
import com.example.skd.myapp.activitys.RXjavaActivity;
import com.example.skd.myapp.activitys.RectActivity;
import com.example.skd.myapp.activitys.ScreenShotActivity;
import com.example.skd.myapp.activitys.ShadowHelperActivity;
import com.example.skd.myapp.activitys.ShadowViewActivity;
import com.example.skd.myapp.activitys.ShuiYinActivity;
import com.example.skd.myapp.activitys.Test1Activity;
import com.example.skd.myapp.activitys.TestBuJuActivity;
import com.example.skd.myapp.activitys.TestMyActivity;
import com.example.skd.myapp.activitys.TimeActivity;
import com.example.skd.myapp.activitys.ViewHelperActivity;
import com.example.skd.myapp.activitys.ViewPagerActivity;
import com.example.skd.myapp.activitys.ViewStubAndMergeActivity;
import com.example.skd.myapp.activitys.WaterMarkActivity;
import com.example.skd.myapp.activitys.WebActivity;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.bean.SampleBean;
import com.example.skd.myapp.receiver.AutoReceiver;
import com.example.skd.myapp.salvage.SalvageActivity;
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
        testPush();
        showTipDialog();
        startActivity(new Intent(MainActivity.this,LevelViewActivity.class));

    }

    private void showTipDialog() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
//                startActivity(new Intent(MainActivity.this, TranslateDialogActivity.class));

            }
        },2*1000);
    }

    private void testPush() {
        //发送广播
        Intent intent = new Intent(this, AutoReceiver.class);
        intent.setAction("VIDEO_TIMER");
        sendBroadcast(intent);
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
//        if (a == b) {
//            Log.d("MainActivity", "相等");
//        } else {
//            Log.d("MainActivity", "不相等");
//
//        }
//        if (c == d) {
//            Log.d("MainActivity", "相等");
//        } else {
//            Log.d("MainActivity", "不相等");
//
//        }
//        if (c.equals(d)) {
//            Log.d("MainActivity", "相等");
//
//        } else {
//            Log.d("MainActivity", "不相等");
//
//        }
    }

    @Override
    public void initData() {
        list.add(new SampleBean("Retrofit相关"));
        list.add(new SampleBean("RXJAVA相关"));
        list.add(new SampleBean("HandlerThread"));
        list.add(new SampleBean("Rxpermissions"));
        list.add(new SampleBean("ViewStub And Merge"));
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
        list.add(new SampleBean("FlowLayout单选多选效果"));
        list.add(new SampleBean("打开本地html"));
        list.add(new SampleBean("模拟H5跳转本地Activity"));
        list.add(new SampleBean("图片添加水印"));
        list.add(new SampleBean("时间轴布局"));
        list.add(new SampleBean("Activity调用其他Activity的方法"));
        list.add(new SampleBean("用Activity实现Dialog效果"));
        list.add(new SampleBean("高斯模糊效果2"));
        list.add(new SampleBean("布局测试"));
        list.add(new SampleBean("自定义View画圆角矩形"));
        list.add(new SampleBean("ListView"));
        list.add(new SampleBean("Activity切换动画"));
        list.add(new SampleBean("OKhttp"));
        list.add(new SampleBean("DialogFragment"));
        list.add(new SampleBean("aige自定义ViewDemo"));
        list.add(new SampleBean("阴影工具类"));
        list.add(new SampleBean("图片加水印"));
        list.add(new SampleBean("截图"));
        list.add(new SampleBean("DrawText"));
        list.add(new SampleBean("RectCustomView"));
        list.add(new SampleBean("ListView加属性多选模式"));
        list.add(new SampleBean("new shadow"));
        list.add(new SampleBean("ShadowHelperActivity"));
        list.add(new SampleBean("枚举"));
        list.add(new SampleBean("ViewFlipper+CountDownTimer"));
        list.add(new SampleBean("Salvage"));
        list.add(new SampleBean("CoordinatorLayout"));
        list.add(new SampleBean("LevelView"));
        list.add(new SampleBean("本地推送"));
        list.add(new SampleBean("闹钟"));
        list.add(new SampleBean("AddView"));
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.addItemDecoration(
                new RecycleViewDivier(this, LinearLayoutManager.HORIZONTAL, 2,
                        Color.parseColor("#f0f0f0")));
        MyAdapter myAdapter = new MyAdapter(list);
        recycleview.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(mContext, "MainActivity_onNewIntent,这里可以做一些跳转到具体页面的操作", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this,LevelViewActivity.class));

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
//                        case "Ping++支付":
//                            startActivity(new Intent(MainActivity.this, PingActivity.class));


//                            break;
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
                        case "FlowLayout单选多选效果":
                            startActivity(new Intent(MainActivity.this, FlowLayoutActivity.class));


                            break;
                        case "打开本地html":
                            startActivity(new Intent(MainActivity.this, WebActivity.class));

//                            ARouter.getInstance().build("/platform/test1").navigation();
                            break;
                        case "模拟H5跳转本地Activity":
                            startActivity(new Intent(MainActivity.this, H5ToNativeActivity.class));


                            break;
                        case "图片添加水印":
                            startActivity(new Intent(MainActivity.this, ShuiYinActivity.class));


                            break;
                        case "时间轴布局":
                            startActivity(new Intent(MainActivity.this, TimeActivity.class));


                            break;
                        case "Activity调用其他Activity的方法":
                            startActivity(new Intent(MainActivity.this, InvokeActivity.class));


                            break;
                        case "用Activity实现Dialog效果":
                            Intent intent = new Intent(MainActivity.this, LikeDialogActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);
                            overridePendingTransition(R.anim.activity_open, 0);

                            break;
                        case "高斯模糊效果2":
                            startActivity(new Intent(MainActivity.this, BlurTwoActivity.class));


                            break;
                        case "布局测试":
                            startActivity(new Intent(MainActivity.this, TestBuJuActivity.class));


                            break;
                        case "自定义View画圆角矩形":
                            startActivity(new Intent(MainActivity.this, PaintActivity.class));


                            break;
                        case "ListView":
                            startActivity(new Intent(MainActivity.this, ListActivity.class));


                            break;
                        case "Activity切换动画":
                            startActivity(new Intent(MainActivity.this, AnimActivity.class));


                            break;
                        case "OKhttp":
                            startActivity(new Intent(MainActivity.this, OkHttpActivity.class));


                            break;
                        case "DialogFragment":
                            startActivity(new Intent(MainActivity.this, DialogFragActivity.class));


                            break;
                        case "aige自定义ViewDemo":
                            startActivity(new Intent(MainActivity.this, AiGeCustomViewActivity.class));


                            break;
                        case "阴影工具类":
                            startActivity(new Intent(MainActivity.this, ShadowViewActivity.class));


                            break;
                        case "图片加水印":
                            startActivity(new Intent(MainActivity.this, WaterMarkActivity.class));
                            break;
                        case "截图":
                            startActivity(new Intent(MainActivity.this, ScreenShotActivity.class));
                            break;
                        case "DrawText":
                            startActivity(new Intent(MainActivity.this, DrawTextActivity.class));
                            break;
                        case "RectCustomView":
                            startActivity(new Intent(MainActivity.this, RectActivity.class));
                            break;
                        case "ListView加属性多选模式":
                            startActivity(new Intent(MainActivity.this, ListViewDemo.class));
                            break;
                        case "new shadow":
                            startActivity(new Intent(MainActivity.this, NewShadowActivity.class));
                            break;
                        case "ShadowHelperActivity":
                            startActivity(new Intent(MainActivity.this, ShadowHelperActivity.class));
                            break;
                        case "枚举":
                            startActivity(new Intent(MainActivity.this, EnumActivity.class));
                            break;
                        case "ViewFlipper+CountDownTimer":
                            startActivity(new Intent(MainActivity.this,ViewFlipperActivity.class));
                            break;
                        case "Salvage":
                            startActivity(new Intent(MainActivity.this, SalvageActivity.class));
                            break;
                        case "CoordinatorLayout":
                            startActivity(new Intent(MainActivity.this, CoordinatorLayoutActivity.class));
                            break;
                        case "LevelView":
                            startActivity(new Intent(MainActivity.this, LevelViewActivity.class));
                            break;
                        case "本地推送":
                            startActivity(new Intent(MainActivity.this, LocalPushActivity.class));
                            break;
                        case "闹钟":
                            startActivity(new Intent(MainActivity.this, AlarmActivity.class));
                            break;
                        case "AddView":
                            startActivity(new Intent(MainActivity.this, AddViewActivity.class));
                            break;
                        default:
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
