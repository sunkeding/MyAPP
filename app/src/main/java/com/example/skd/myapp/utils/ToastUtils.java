package com.example.skd.myapp.utils;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * 控制toast的显示
 */
public class ToastUtils {

    private static Toast mToast;

    /**
     * 显示Toast.
     *
     * @param text
     */
    public static void showToast(final Context context, final String text) {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, text,
                            Toast.LENGTH_SHORT);
                } else {
                    mToast.setText(text);
                    mToast.setDuration(Toast.LENGTH_SHORT);
                }
                mToast.show();
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
    }


    /**
     * 显示Toast.
     */
    public static void showToast(final Context context, @StringRes final int resId) {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                if (mToast == null) {
                    mToast = Toast.makeText(context, resId,
                            Toast.LENGTH_SHORT);
                } else {
                    mToast.setText(context.getResources().getString(resId));
                    mToast.setDuration(Toast.LENGTH_SHORT);
                }
                mToast.show();
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    /**
     * 在屏幕中间显示Toast。
     *
     * @param text
     */
    public static void showCenterToast(final Context context, final CharSequence text) {

        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                Toast toast = Toast.makeText(
                        context, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe();

    }

}
