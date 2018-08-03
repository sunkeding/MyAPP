package com.example.skd.myapp.activitys.movetasktoback;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.skd.myapp.R;

/**
 * @author: skd
 * @date 2018/5/22
 * @Desc MoveTaskToBackActivity
 */
public class MoveTaskToBackActivity  extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movetasktoback);
        Log.e("====", "onCreate()");
    }

    @Override
    protected void onPause() {
        Log.e("====", "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("====", "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("====", "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        Log.e("====", "onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.e("====", "onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e("====", "onRestart()");
        super.onRestart();
    }

    public void move(View view) {
        moveTaskToBack(false);
        Log.e("====", "点击运行了moveTaskToBack()方法");
    }
}

