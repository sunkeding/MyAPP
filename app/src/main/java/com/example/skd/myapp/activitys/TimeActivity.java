package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.MyTimeAdapter;
import com.example.skd.myapp.adapter.Progress1Adapter;
import com.example.skd.myapp.bean.ProgressBean;
import com.example.skd.myapp.bean.TimeBean;
import com.example.skd.myapp.utils.recycleviewutil.RecycleUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skd on 2017/6/15.
 */

public class TimeActivity extends Activity {
    RecyclerView recycleview1, recycleview2;
    List<TimeBean> list = new ArrayList<>();
    List<ProgressBean> listpb1 = new ArrayList<>();
    ArrayList<Integer> listinteger = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        recycleview1 = (RecyclerView) findViewById(R.id.recycleview1);
        recycleview2 = (RecyclerView) findViewById(R.id.recycleview2);
        RecycleUtils.initHorizontalRecyle(recycleview1, this);
        RecycleUtils.initHorizontalRecyle(recycleview2, this);
        list.add(new TimeBean("8"));
        list.add(new TimeBean("10"));
        list.add(new TimeBean("12"));
        list.add(new TimeBean("14"));
        list.add(new TimeBean("16"));
        list.add(new TimeBean("18"));
        list.add(new TimeBean("20"));
        list.add(new TimeBean("22"));
        list.add(new TimeBean("24"));
        for (int i = 0; i < 16; i++) {
            listpb1.add(new ProgressBean(i));
        }

        recycleview1.setAdapter(new MyTimeAdapter(list));

        listinteger.add(1);
        listinteger.add(2);
        listinteger.add(7);
        listinteger.add(8);
        recycleview2.setAdapter(new Progress1Adapter(listpb1,listinteger));
    }
}
