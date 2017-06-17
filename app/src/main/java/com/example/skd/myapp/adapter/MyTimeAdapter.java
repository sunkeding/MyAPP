package com.example.skd.myapp.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.TimeBean;
import com.example.skd.myapp.utils.recycleviewutil.BaseRecycleAdapter;

import java.util.List;

/**
 * Created by skd on 2017/6/15.
 */

public class MyTimeAdapter extends BaseRecycleAdapter<TimeBean> {
    public MyTimeAdapter(List<TimeBean> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView view = (TextView) holder.getView(R.id.tv);
        view.setText(datas.get(position).getTime());
        View view1 = holder.getView(R.id.viewleft);
        if (position==0){
            view1.setVisibility(View.INVISIBLE);
        }else {
            view1.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_time;
    }
}
