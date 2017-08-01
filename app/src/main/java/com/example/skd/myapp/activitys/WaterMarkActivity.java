package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.DisplayUtils;

/**
 * Created by skd on 2017/7/31.
 */

public class WaterMarkActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermark);
        Bitmap mBaseBitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.lenna);
        Bitmap skasda = addWaterMark(mBaseBitmap, "skasda", this);
        ImageView viewById = (ImageView) findViewById(R.id.imageView);
        viewById.setImageBitmap(skasda);
    }

    public Bitmap addWaterMark(Bitmap src, String water, Context context) {
        Bitmap tarBitmap = src.copy(Bitmap.Config.ARGB_8888, true);
        int w = tarBitmap.getWidth();
        int h = tarBitmap.getHeight();
        Log.d("WaterMarkActivity", "w:" + w);
        Log.d("WaterMarkActivity", "h:" + h);
        Canvas canvas = new Canvas(tarBitmap);
        //启用抗锯齿和使用设备的文本字距
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DEV_KERN_TEXT_FLAG);
        //字体的相关设置
        textPaint.setTextSize(DisplayUtils.sp2px(this, 12));//字体大小
//        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(Color.WHITE);
//        textPaint.setShadowLayer(3f, 1, 1,context.getResources().getColor(android.R.color.background_dark));
        //图片上添加水印的位置，这里设置的是中下部3/4处
        int i = w / 2 - 50;
        float v = (float) (h * 0.75);
        Log.d("WaterMarkActivity", "i:" + i);
        Log.d("WaterMarkActivity", "v:" + v);
        canvas.drawText(water, w / 2 - 50, (float) (h * 0.75), textPaint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        return tarBitmap;
    }
}
