package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.skd.myapp.R;

/**
 * Created by skd on 2018/1/11.
 */

public class LevelViewActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_view);
        findViewById(R.id.levelview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LevelViewActivity.this, "red", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
