package com.example.skd.myapp.testlogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.skd.myapp.R;

/**
 * @author: skd
 * @date 2018/4/12
 * @Desc LoginAndGotoTargetActivity
 */

public class LoginAndGotoTargetActivity extends Activity {
    /**
     * 这里模拟登录标志
     */
    public static boolean is_login = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginandgototarget);
    }
    /*
	 * 跳转到目标activity页面
	 */
    public void starIntent(View v) {
        Bundle bun = new Bundle();
        bun.putString("Type", "login test");
        LoginInterceptor.interceptor(this, "com.example.skd.myapp.testlogin.SecondActivity", bun);
    }

    /*
     * 退出登录
     */
    public void exitSign(View v) {
        is_login = false;
    }

    public void gotoThird(View v) {
        startActivity(new Intent(this, ThirdActivity.class));
    }
}
