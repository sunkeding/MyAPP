package com.example.skd.myapp.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author: skd
 * @date 2018/3/13
 * @Desc 用于视频播放的时间显示
 */

public class VideoTimeTextView2 extends TextView {
    private long lastStartTime;
    private long lastUpdateTime;
    private long totalTime;
    private int TIME_ADD_CODE;
    /**
     * 记录每一次开始到结束的时间段
     */
    private ArrayList<Long> recordTimeList = new ArrayList<>();
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == TIME_ADD_CODE) {
                Log.d("VideoTimeTextView2", "lastStartTime:" + lastStartTime);

                totalTime=totalTime+System.currentTimeMillis()-lastUpdateTime;
                setText("总共过了" + totalTime + "毫秒");
                handler.sendEmptyMessageDelayed(TIME_ADD_CODE, 100);
                lastUpdateTime=System.currentTimeMillis();
            }
            super.handleMessage(msg);

        }
    };

    public VideoTimeTextView2(Context context) {
        this(context, null);
    }

    public VideoTimeTextView2(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoTimeTextView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public synchronized void start() {
        lastStartTime = System.currentTimeMillis();
        lastUpdateTime = System.currentTimeMillis();
        handler.sendEmptyMessage(TIME_ADD_CODE);
    }

    public synchronized void stop() {
        recordTimeList.add(System.currentTimeMillis() - lastStartTime);
        long recordTotalTime = 0;
        for (Long aLong : recordTimeList) {
            recordTotalTime = recordTotalTime + aLong;
        }
        setText("总共过了" + recordTotalTime + "毫秒");
        totalTime = recordTotalTime;
        handler.removeMessages(TIME_ADD_CODE);

    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        handler.removeMessages(TIME_ADD_CODE);
    }
}
