package com.example.skd.myapp.app;

import android.app.Application;

/**
 * Created by skd on 2017/6/13.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        initArouter();
    }

//    private void initArouter() {
//        ARouter.openDebug();
//        ARouter.init(this);
//        ARouter.openLog(); // 开启日志
//        ARouter.printStackTrace(); // 打印日志的时候打印线程堆栈
//    }
}
