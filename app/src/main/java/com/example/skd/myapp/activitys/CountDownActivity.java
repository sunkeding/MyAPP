package com.example.skd.myapp.activitys;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

/**
 * Created by skd on 2017/4/20.
 */

public class CountDownActivity extends BaseActivity {
    private TextView tvtime2,tvtime3;
    private  long  time=15*60;
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_countdown);
//        tvtime1=(TextView)findViewById(R.id.tvtime1);
        tvtime2=(TextView) findViewById(R.id.tvtime2);
        tvtime3=(TextView) findViewById(R.id.tvtime3);
        handler.postDelayed(runnable, 1000);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            String formatLongToTimeStr = formatLongToTimeStr(time);
            String[] split = formatLongToTimeStr.split("：");
            for (int i = 0; i < split.length; i++) {
//                if(i==0){
//                    tvtime1.setText(split[0]+"小时");
//                }
                if(i==1){
                    tvtime2.setText(split[1]);
                }
                if(i==2){
                    tvtime3.setText(split[2]);
                }

            }
            if(time>0){
                handler.postDelayed(this, 1000);
            }
        }
    };

    public  String formatLongToTimeStr(Long l) {
        String strtime="";
        int hour = 0;
        int minute = 0;
        int second = 0;
        second = l.intValue() ;
        if (second > 60) {
            minute = second / 60;         //取整
            second = second % 60;         //取余
        }

        if (minute > 60) {
            hour = minute / 60;
            minute = minute % 60;
        }

        if (minute<10){
            if (second<10){
                strtime= hour+"："+"0"+minute+"："+"0"+second;
            }else {
                strtime= hour+"："+"0"+minute+"："+second;
            }


        }else {
            if (second<10){
                strtime= hour+"："+minute+"："+"0"+second;
            }else {
                strtime= hour+"："+minute+"："+second;
            }

        }

        Log.d("CountDownActivity", strtime);
        return strtime;

    }
}
