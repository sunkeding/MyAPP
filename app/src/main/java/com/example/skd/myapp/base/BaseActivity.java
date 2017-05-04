package com.example.skd.myapp.base;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.skd.myapp.utils.AppManager;

import butterknife.ButterKnife;

/**
 * @author skd
 */


public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置竖屏
        AppManager.getInstance().addActivity(this);
        init();
    }

    public void init() {

        setMyContentView();
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();

    }

    protected abstract void initListener();

    public abstract void setMyContentView();

    public abstract void initView();

    public abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();

        ButterKnife.unbind(this);
    }
}