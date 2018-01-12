package com.example.skd.myapp.adapter;

import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.recycleviewutil.BaseRecycleAdapter;

import java.util.List;

/**
 * Created by skd on 2018/1/8.
 */

public class RecycleViewFrgDemoAdpater extends BaseRecycleAdapter<String> {
    public RecycleViewFrgDemoAdpater(List<String> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView tv= (TextView) holder.getView(R.id.tv);
        tv.setText("9999");
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_frg_demo;
    }
}
