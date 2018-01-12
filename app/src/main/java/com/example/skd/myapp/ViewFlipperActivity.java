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
        Glide.with(this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515143545620&di=0fc31d38361d9dca418554886386d822&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F02675d593a49cca8012193a3d789f3.gif").into(iv);
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
