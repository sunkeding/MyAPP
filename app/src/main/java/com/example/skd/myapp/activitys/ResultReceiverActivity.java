package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.skd.myapp.MyIntentService;
import com.example.skd.myapp.R;

/**
 * Created by skd on 2018/1/28.
 * http://blog.csdn.net/liuyingcan/article/details/50673317
 * 场景是需要耗时操作，开启一个服务，耗时结束回调到Activity，其实也可以用事件总线做
 */

public class ResultReceiverActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button bt_test = (Button) findViewById(R.id.bt_test);
        bt_test.setText("ResultReceiver");
        bt_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClick();
            }
        });
    }

    private static Handler handler = new Handler() {
    };
    private ResultReceiver mResultReceiver = new ResultReceiver(handler) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            Toast.makeText(ResultReceiverActivity.this, "receive " + resultCode, Toast.LENGTH_LONG).show();
        }
    };

    public void btnClick() {
        Intent intent = new Intent(ResultReceiverActivity.this, MyIntentService.class);
        intent.putExtra("result_receiver", mResultReceiver);
        startService(intent);
    }
}
