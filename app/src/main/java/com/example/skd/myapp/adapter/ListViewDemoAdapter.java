package com.example.skd.myapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.ListViewDemoBean;

import java.util.List;

/**
 * Created by skd on 2017/8/2.
 */

public class ListViewDemoAdapter extends CommonAdapter<ListViewDemoBean> {
    public ListViewDemoAdapter(Context context, List<ListViewDemoBean> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder helper, ListViewDemoBean item) {
        TextView tv = helper.getView(R.id.tv);
        tv.setText(item.getName());
        if (item.isHasselected()) {
            tv.setTextColor(Color.RED);
        } else {
            tv.setTextColor(Color.BLACK);

        }
    }

}
