package com.example.skd.myapp.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Created by javalong on 16-11-14.
 *
 * 获取屏幕信息的工具类
 */
public class DisplayUtils {
    private static final String TAG = DisplayUtils.class.getSimpleName();

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取不同的尺寸
     */
    public static float getRawSize(Context context, int unit, float value) {
        Resources res = context.getResources();
        return TypedValue.applyDimension(unit, value, res.getDisplayMetrics());
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param context
     * @param spValue（DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    // 获取通知栏高度
    public static int getStatusBarHeight(Context context) {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            Log.e(TAG, "getStatusBarHeight() occured exception.", e);
        }
        return statusBarHeight;
    }

    /**
     * 获取上下文高度.
     */
    public static int getContextHeight(Context context) {
        return getScreenHeight(context) - getStatusBarHeight(context);
    }

    /**
     * 获取屏幕尺寸 width x height
     *
     * @return
     */
    public static String getScreenSize(Context context) {
        int width = getScreenWidth(context);
        int height = getScreenHeight(context);
        return new StringBuilder().append(width).append("x").append(height).toString();
    }


    /**
     * Convert Dp to Pixel
     */
    public static int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

    public static int getRelativeTop(View myView) {
        if (myView.getId() == android.R.id.content)
            return myView.getTop();
        else
            return myView.getTop() + getRelativeTop((View) myView.getParent());
    }

    public static int getRelativeLeft(View myView) {
        if (myView.getId() == android.R.id.content)
            return myView.getLeft();
        else
            return myView.getLeft() + getRelativeLeft((View) myView.getParent());
    }

    /**
     * 左边10px，间距5px， 显示3 张半的图
     * 1*10+3*5px  /3.5,
     */
    public static int calculateCellWith(Context context) {
        int widthPixels = getScreenWidth(context);
        int margin = dip2px(context, 10 + 3 * 5);
        return (widthPixels - margin) / 7 * 2;
    }

    public static DisplayMetrics getOutMetrics(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics();
    }

}
