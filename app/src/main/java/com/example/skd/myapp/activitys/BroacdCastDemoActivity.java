package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.appconfig.BroadCastConfig;
import com.example.skd.myapp.broadcast.BroadcastManager;

/**
 * Created by skd on 2018/1/28.
 */

public class BroacdCastDemoActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broacdcast);
        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BroacdCastDemoActivity.this, Test1Activity.class));
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BroadcastManager.getInstance(BroacdCastDemoActivity.this).sendBroadcast(BroadCastConfig.TEST_BROADCAST_KEY2);

            }
        });

        BroadcastManager.getInstance(this).addAction(BroadCastConfig.TEST_BROADCAST_KEY1, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "收到来自Test1Activity的广播", Toast.LENGTH_SHORT).show();

            }
        });
        BroadcastManager.getInstance(this).addAction(BroadCastConfig.TEST_BROADCAST_KEY2, new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "收到来自本页面的广播", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BroadcastManager.getInstance(this).destroy(BroadCastConfig.TEST_BROADCAST_KEY1);
        BroadcastManager.getInstance(this).destroy(BroadCastConfig.TEST_BROADCAST_KEY2);

    }
}
