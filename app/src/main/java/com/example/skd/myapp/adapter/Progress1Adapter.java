package com.example.skd.myapp.adapter;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.ProgressBean;
import com.example.skd.myapp.bean.TimeBean;
import com.example.skd.myapp.utils.recycleviewutil.BaseRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skd on 2017/6/15.
 */

public class Progress1Adapter extends BaseRecycleAdapter<ProgressBean> {
    ArrayList<Integer> integerList;

    public Progress1Adapter(List<ProgressBean> datas, ArrayList<Integer> data) {
        super(datas);
        this.integerList = data;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        View view = holder.getView(R.id.view);
        for (Integer integer : integerList) {
            if (position == integer) {
                Log.d("Progress1Adapter", "position:" + position);
                view.setBackgroundColor(Color.parseColor("#00ff00"));

            }else {
                Log.d("Progress1Adapter", "----"+position);
            }
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_pb1;
    }

}
