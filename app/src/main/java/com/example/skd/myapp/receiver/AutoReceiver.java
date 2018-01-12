package com.example.skd.myapp.receiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.example.skd.myapp.R;
import com.example.skd.myapp.activitys.LevelViewActivity;

/**
 * Created by skd on 2018/1/12.
 */

public class AutoReceiver extends BroadcastReceiver {
    private static final int NOTIFICATION_FLAG = 1;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("VIDEO_TIMER")) {
            Log.d("AutoReceiver", "受到广播了，然后去推送一条");
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                    new Intent(context, LevelViewActivity.class), 0);
            // 通过Notification.Builder来创建通知，注意API Level
            // API16之后才支持
            Notification notify = new Notification.Builder(context)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setTicker("11111")
                    .setContentTitle("MainActivity广播形式触发的推送")
                    .setContentText("广播方式")
                    .setContentIntent(pendingIntent).setNumber(1).build(); // 需要注意build()是在API
            // level16及之后增加的，API11可以使用getNotificatin()来替代
            notify.flags |= Notification.FLAG_AUTO_CANCEL; // FLAG_AUTO_CANCEL表明当通知被用户点击时，通知将被清除。
            // 在Android进行通知处理，首先需要重系统哪里获得通知管理器NotificationManager，它是一个系统Service。
            NotificationManager manager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(NOTIFICATION_FLAG, notify);// 步骤4：通过通知管理器来发起通知。如果id不同，则每click，在status哪里增加一个提示
        }
    }
}
