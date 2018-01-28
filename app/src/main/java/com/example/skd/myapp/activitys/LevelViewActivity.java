package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.skd.myapp.R;
import com.example.skd.myapp.views.CircleProgressBar;

/**
 * Created by skd on 2018/1/11.
 */

public class LevelViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_view);
        CircleProgressBar ringLevelView= (CircleProgressBar) findViewById(R.id.ringview);
        ringLevelView.setProgress(90);
    }
}
