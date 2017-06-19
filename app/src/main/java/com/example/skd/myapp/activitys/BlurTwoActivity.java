package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.example.skd.myapp.R;
import com.example.skd.myapp.fragment.FastBlurFragment;
import com.example.skd.myapp.fragment.RSBlurFragment;

/**
 * Created by skd on 2017/6/19.
 */

public class BlurTwoActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blurtwo);
        FrameLayout content = (FrameLayout) findViewById(R.id.content);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        FastBlurFragment fragment = new FastBlurFragment();
        RSBlurFragment fragment = new RSBlurFragment();
        transaction.replace(R.id.content, fragment);
        transaction.commitAllowingStateLoss();
    }
}
