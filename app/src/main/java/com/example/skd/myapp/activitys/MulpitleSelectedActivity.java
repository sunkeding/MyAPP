package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.MulpitleTypeAdapter;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.bean.SelectedBean;
import com.example.skd.myapp.dragselectrecyclerview.DragSelectRecyclerView;
import com.example.skd.myapp.dragselectrecyclerview.DragSelectRecyclerViewAdapter;
import com.example.skd.myapp.utils.recycleviewutil.RecycleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/6/5.
 */

public class MulpitleSelectedActivity extends BaseActivity implements
        MulpitleTypeAdapter.ClickListener, DragSelectRecyclerViewAdapter.SelectionListener {
    @Bind(R.id.recycleview)
    DragSelectRecyclerView recycleview;
    @Bind(R.id.tv_sure)
    TextView tv_sure;
    @Bind(R.id.tv_clear)
    TextView tv_clear;
    ArrayList<SelectedBean> list = new ArrayList<>();
    private MulpitleTypeAdapter adapter;
    private boolean hasSelected;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_mulpitleselected);
        ButterKnife.bind(this);
        for (int i = 0; i < 5; i++) {
            list.add(new SelectedBean("item" + i));
        }
        adapter = new MulpitleTypeAdapter(this, list);
//        RecycleUtils.initVerticalRecyle(recycleview, this);
        RecycleUtils.initGridViewRecyle(recycleview, this, 3);
        recycleview.setAdapter(adapter);
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedCount = adapter.getSelectedCount();
                Toast.makeText(MulpitleSelectedActivity.this, "selectedCount:" + selectedCount, Toast.LENGTH_SHORT).show();
                Integer[] selectedIndices = adapter.getSelectedIndices();
                for (Integer integer : selectedIndices) {
                    SelectedBean item = adapter.getItem(integer);
                    Log.d("MulpitleSelectedActivit", "选择了" + item.getName());
                }

            }
        });
        tv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.clearSelected();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onDragSelectionChanged(int count) {

    }

    @Override
    public void onClick(int index) {
        Integer[] selectedIndices = adapter.getSelectedIndices();
        List<Integer> integers = Arrays.asList(selectedIndices);
        if (!integers.contains(index)&&integers.size()==3){
            Toast.makeText(this, "您最多只能选择3个", Toast.LENGTH_SHORT).show();
            return;
        }


        adapter.toggleSelected(index);
    }

    @Override
    public void onLongClick(int index) {
        adapter.toggleSelected(index);
    }
}
