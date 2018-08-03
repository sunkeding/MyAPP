package com.example.skd.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.skd.myapp.views.PlanDetailTimeLayout;

import java.util.Random;

/**
 * @author: skd
 * @date 2018/8/3
 * @Desc ConstrainLayoutDemoActivity
 */
public class ConstrainLayoutDemoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraindemo);
        PlanDetailTimeLayout layout=findViewById(R.id.timelayout);
        Random random = new Random();
        int i = random.nextInt(6);
        Log.d("ConstrainLayoutDemoActi", "i:" + i);
        layout.setIndex(i,6);
    }
}
