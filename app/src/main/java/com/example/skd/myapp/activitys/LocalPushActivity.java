package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.example.skd.myapp.MainActivity;
import com.example.skd.myapp.R;

/**
 * Created by skd on 2018/1/12.
 */

public class LocalPushActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_push);
        findViewById(R.id.bt_push).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                push();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void push() {
        // 本地通知
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        String title = "点击按钮触发的本地推送标题";
        String content = "点击按钮触发的本地推送内容";

        //1.实例化一个通知，指定图标、概要、时间

        //2.指定通知的标题、内容和intent

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        Notification n = new Notification.Builder(this)
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(content)
                .setWhen(5000)
                .setContentIntent(pi)
                .build();

        //3.指定声音
        n.defaults = Notification.DEFAULT_SOUND;

        //4.发送通知
        nm.notify(1, n);

    }
}
