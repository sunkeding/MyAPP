package com.example.skd.myapp.adapter;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.SelectedBean;
import com.example.skd.myapp.dragselectrecyclerview.DragSelectRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by skd on 2017/6/5.
 */

public class MulpitleTypeAdapter extends DragSelectRecyclerViewAdapter<MulpitleTypeAdapter.MainViewHolder> {
    ArrayList<SelectedBean> list;

    public interface ClickListener {
        void onClick(int index);

        void onLongClick(int index);
    }

    public final ClickListener callback;

    public MulpitleTypeAdapter(ClickListener callback, ArrayList<SelectedBean> datas) {
        super();
        this.callback = callback;
        this.list = datas;
    }

    public SelectedBean getItem(int index) {
        return list.get(index);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paytypenew, parent, false);
        return new MainViewHolder(v, callback);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.tv_paytype.setText(list.get(position).getName());
        if (isIndexSelected(position)) {
            holder.iv_selectestate.setImageResource(R.mipmap.selected);
        } else {
            holder.iv_selectestate.setImageResource(R.mipmap.unselected);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MainViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private final TextView tv_paytype;
        private final ImageView iv_selectestate;
        private final ClickListener mCallback;

        MainViewHolder(View itemView, ClickListener callback) {
            super(itemView);
            mCallback = callback;

            this.tv_paytype = (TextView) itemView.findViewById(R.id.tv_paytype);
            this.iv_selectestate = (ImageView) itemView.findViewById(R.id.iv_selectestate);
            this.itemView.setOnClickListener(this);
            this.itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mCallback != null) mCallback.onClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            if (mCallback != null) mCallback.onLongClick(getAdapterPosition());
            return true;
        }
    }
}
