package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.DisplayUtils;

import java.io.FileOutputStream;

/**
 * Created by skd on 2017/7/31.
 */

public class WaterMarkActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermark);
//        Bitmap mBaseBitmap = BitmapFactory.decodeResource(getResources(),
//                R.drawable.lenna);
//        Bitmap skasda = addWaterMark(mBaseBitmap, "sunkeding", this);
        ImageView iv_before = (ImageView) findViewById(R.id.iv_before);
        ImageView iv_after = (ImageView) findViewById(R.id.iv_after);
        Drawable drawable = iv_before.getDrawable();
        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap beforeBitmap = bd.getBitmap();
        Bitmap afterBitmap = addWaterMark(beforeBitmap, "sun", this);
        saveBitmapToSDCard(afterBitmap, "addwater");
        iv_after.setImageBitmap(afterBitmap);
    }

    public Bitmap addWaterMark(Bitmap src, String water, Context context) {
        Bitmap tarBitmap = src.copy(Bitmap.Config.ARGB_8888, true);
        int width = tarBitmap.getWidth();//600
        int height = tarBitmap.getHeight();//338
        Canvas canvas = new Canvas(tarBitmap);
        //启用抗锯齿和使用设备的文本字距
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DEV_KERN_TEXT_FLAG);
        //字体的相关设置
        textPaint.setTextSize(DisplayUtils.sp2px(this, 12));//字体大小
//        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(Color.WHITE);

        //画text所占的区域
        Paint.FontMetricsInt fm = textPaint.getFontMetricsInt();
//        int baseLineY = (int) (0.8 * height);
//        int baseLineX = (int) 0.75 * width;
//        int baseLineY = 270;
//        int baseLineX = 450;
        int baseLineY = height - DisplayUtils.dip2px(this, 5);
        int baseLineX = width / 2;
        int top = baseLineY + fm.top;
        int bottom = baseLineY + fm.bottom;
        int width2 = (int) textPaint.measureText(water);//文字宽度
        //所占高度
        int txtheight = bottom - top;  //文字高度
//        Rect rect = new Rect(baseLineX, top, baseLineX + width2, bottom);
        Rect rect = new Rect(0, height - DisplayUtils.dip2px(this, 20), width, height);
        Paint rectpaint = new Paint();
        rectpaint.setColor(Color.parseColor("#99000000"));
        canvas.drawRect(rect, rectpaint);


        canvas.drawText(water, (float) (0.5 * width), (float) (height - DisplayUtils.dip2px(this, 8)), textPaint);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        return tarBitmap;
    }

    /**
     * 保存bitmap到SD卡
     *
     * @param bitmap
     * @param imagename
     */
    public static String saveBitmapToSDCard(Bitmap bitmap, String imagename) {
        String path = "/sdcard/" + "img-" + imagename + ".jpg";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            if (fos != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
                fos.close();
            }

            return path;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
