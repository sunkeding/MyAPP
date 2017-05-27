package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/5/26.
 */

public class PicassoActivity extends BaseActivity {
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_picasso);
        ButterKnife.bind(this);
        String url = "https://img.leoao.com/%E7%A7%81%E6%95%99%E4%BD%93%E9%AA%8C%E8%AF%BE.jpg";
        Picasso.with(this).load(url).into(iv);
        Glide.with(this).load(url).into(iv);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
