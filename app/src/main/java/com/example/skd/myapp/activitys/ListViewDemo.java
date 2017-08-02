package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.ListViewDemoAdapter;
import com.example.skd.myapp.bean.ListViewDemoBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/8/2.
 */

public class ListViewDemo extends Activity {
    @Bind(R.id.listview)
    ListView listview;
    ListViewDemoAdapter adapter;
    @Bind(R.id.bt_sure)
    Button btSure;
    @Bind(R.id.bt_clear)
    Button btClear;
    ArrayList<ListViewDemoBean> selectedList = new ArrayList<ListViewDemoBean>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        final ArrayList<ListViewDemoBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ListViewDemoBean("item" + i, false));
        }
        adapter = new ListViewDemoAdapter(this, list, R.layout.item_simpletext);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position).isHasselected()) {
                    list.get(position).setHasselected(false);
                } else {
                    list.get(position).setHasselected(true);
                }
                adapter.notifyDataSetChanged();

            }
        });
        btSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedList.clear();
                for (ListViewDemoBean listViewDemoBean : list) {
                    if (listViewDemoBean.isHasselected()) {
                        selectedList.add(listViewDemoBean);
                    }
                }
                for (ListViewDemoBean listViewDemoBean : selectedList) {
                    Log.d("ListViewDemo", "选择了" + listViewDemoBean.getName());
                }
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedList.clear();
                for (ListViewDemoBean listViewDemoBean : list) {
                    listViewDemoBean.setHasselected(false);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }
}
