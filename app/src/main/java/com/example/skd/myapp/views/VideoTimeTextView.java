package com.example.skd.myapp.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.example.skd.myapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: skd
 * @date 2018/3/13
 * @Desc 用于视频播放的时间显示
 */

public class VideoTimeTextView extends TextView {
    private Timer timer = null;
    private TimerTask task = null;
    private Message msg = null;
    private boolean bIsRunningFlg = false;
    private int TIME_ADD_CODE;
    private long mlCount = 0;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == TIME_ADD_CODE) {

                mlCount++;
                Log.d("VideoTimeTextView", "mlCount:" + mlCount);
                int totalSec =  (int) (mlCount / 10);
                int yushu = (int) (mlCount % 10);

                int sec = (totalSec % 60);
                Log.d("VideoTimeTextView",  sec+"s"+yushu);
                setText(sec+"."+yushu+"s");
            }
        }
    };

    public VideoTimeTextView(Context context) {
        this(context, null);
    }

    public VideoTimeTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoTimeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private long startTime, stopTime;



    public void start() {
//        startTime = System.currentTimeMillis();
//        handler.sendEmptyMessage(TIME_ADD_CODE);
        if (null == timer) {
            if (null == task) {
                task = new TimerTask() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (null == msg) {
                            msg = new Message();
                        } else {
                            msg = Message.obtain();
                        }
                        msg.what = TIME_ADD_CODE;
                        handler.sendMessage(msg);
                    }

                };
            }

            timer = new Timer(true);
            timer.schedule(task, 100, 100); // set timer duration
        }

        // start
        if (!bIsRunningFlg) {
            bIsRunningFlg = true;
        } else { // pause
            try {
                bIsRunningFlg = false;
                task.cancel();
                task = null;
                timer.cancel(); // Cancel timer
                timer.purge();
                timer = null;
                handler.removeMessages(msg.what);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeMessages(TIME_ADD_CODE);
    }
}
