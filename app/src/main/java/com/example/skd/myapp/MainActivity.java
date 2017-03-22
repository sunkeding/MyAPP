package com.example.skd.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skd.myapp.activitys.NetActivity;
import com.example.skd.myapp.activitys.RXjavaActivity;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.bean.SampleBean;
import com.example.skd.myapp.views.RecycleViewDivier;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recycleview)
    RecyclerView recycleview;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;
    private ArrayList<SampleBean> list = new ArrayList<>();


    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        list.add(new SampleBean("Retrofit相关"));
        list.add(new SampleBean("RXJAVA相关"));
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
                            break;
                        case "RXJAVA相关":
                            startActivity(new Intent(MainActivity.this, RXjavaActivity.class));
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
