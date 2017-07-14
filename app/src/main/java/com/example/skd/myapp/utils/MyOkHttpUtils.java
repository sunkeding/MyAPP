package com.example.skd.myapp.utils;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by skd on 2017/7/14.
 */

public class MyOkHttpUtils{  //最简单的使用
    private static MyOkHttpUtils utils;
    private static OkHttpClient okHttpClient;
    private static Handler mDelivery;
    private static Type type;

    public static MyOkHttpUtils getInstance() {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient();
        }
        if (utils == null) {
            synchronized (MyOkHttpUtils.class) {
                if (utils == null) {
                    utils = new MyOkHttpUtils();
                }
            }
        }
        if (mDelivery == null) {
            mDelivery = new Handler(Looper.getMainLooper());

        }

        return utils;
    }


    public MyOkHttpUtils getAsynByModel(String url, final DealModelUtil modelUtil) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        modelUtil.onFailure(call, e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        modelUtil.onSuccess(JsonUtils.deserialize(string, modelUtil.mType));

                    }
                });

            }
        });
        return utils;
    }

    public void getAsynByString(String url, final StringCallback stringCallback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        stringCallback.onFailure(call, e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                mDelivery.post(new Runnable() {
                    @Override
                    public void run() {
                        stringCallback.onResponse(string);
                    }
                });

            }
        });
    }


    public interface StringCallback {
        void onFailure(Call request, IOException e);

        void onResponse(String response);
    }


}
