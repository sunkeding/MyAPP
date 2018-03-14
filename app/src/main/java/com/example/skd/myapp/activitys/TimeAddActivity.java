package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.example.skd.myapp.views.VideoTimeTextView2;

/**
 * @author: skd
 * @date 2018/3/13
 * @Desc TimeAddActivity
 */

public class TimeAddActivity extends Activity {
    VideoTimeTextView2 tv_time;
    Button bt_start, bt_end;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeadd);
        tv_time = findViewById(R.id.tv_time);
        bt_start = findViewById(R.id.bt_start);
        bt_end = findViewById(R.id.bt_end);

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                if (num%2==0){
                    tv_time.stop();

                }else {

                    tv_time.start();
                }

            }
        });
//        bt_end.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tv_time.stop();
//            }
//        });
    }
}
