package com.example.skd.myapp.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by skd on 2018/1/11.
 */

public class DisplayUtil {
    public DisplayUtil() {
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dpValue * scale + 0.5F);
    }



    public static float getDisplayDensity(Context activity) {
        WindowManager wm = (WindowManager)activity.getSystemService("window");
        DisplayMetrics mMetric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(mMetric);
        return mMetric.density;
    }
}
