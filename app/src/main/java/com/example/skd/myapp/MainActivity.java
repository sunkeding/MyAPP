package com.example.skd.myapp;

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
import android.widget.Toast;

import com.example.skd.myapp.activitys.HandlerThreadActivity;
import com.example.skd.myapp.activitys.NetActivity;
import com.example.skd.myapp.activitys.RXjavaActivity;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.bean.SampleBean;
import com.example.skd.myapp.views.RecycleViewDivier;
import com.taobao.android.SophixManager;
import com.taobao.android.listener.PatchLoadStatusListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

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
                                Log.d("MainActivity", stringBuilder.toString());
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

    }

    @Override
    public void initData() {
        list.add(new SampleBean("Retrofit相关"));
        list.add(new SampleBean("RXJAVA相关"));
        list.add(new SampleBean("HandlerThread"));
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
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }


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
