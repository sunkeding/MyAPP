package com.example.skd.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

/**
 * Created by skd on 2018/1/2.
 */

public class ViewFlipperActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounimg);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        TextView tv = (TextView) findViewById(R.id.tv);
        final ViewFlipper vf = (ViewFlipper) findViewById(R.id.vf);
        Glide.with(this).load("https://img.leoao.com/2017/12/25/Fson-_gBATBXEAXRM57dWtDoxNxA.jpg").into(iv);
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                vf.setDisplayedChild(1);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        vf.setDisplayedChild(0);

                    }
                },3000);

            }
        };
        countDownTimer.start();
        Log.d("ViewFlipperActivity", "1->Looper.myLooper():" + Looper.myLooper());
        Log.d("ViewFlipperActivity", "2->Looper.getMainLooper():" + Looper.getMainLooper());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("ViewFlipperActivity", "3->Looper.myLooper():" + Looper.myLooper());
            }
        }).start();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("ViewFlipperActivity", "4->Looper.myLooper():" + Looper.myLooper());
                Toast.makeText(ViewFlipperActivity.this, "isOnMainThread():" + isOnMainThread(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
