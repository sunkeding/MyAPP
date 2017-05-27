package com.example.skd.myapp.activitys;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by skd on 2017/5/22.
 */

public class TestMyActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.servicetest);
        ButterKnife.bind(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
