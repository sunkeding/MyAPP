package com.example.skd.myapp.activitys;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.skd.myapp.utils.DisplayUtils;

/**
 * Created by skd on 2017/8/2.
 */

public class RectCustomView extends View {
    public RectCustomView(Context context) {
        super(context);
        Log.d("RectCustomView", "1");
    }

    public RectCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        Log.d("RectCustomView", "2");
    }

    public RectCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.d("RectCustomView", "3");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("RectCustomView", "onDraw");
        drawMethod(canvas);
//        drawMethod2(canvas);
    }

    private void drawMethod2(Canvas canvas) {
        String text = "sun";
        int baseLineY = 200;
        int baseLineX = 0 ;
//画基线
        Paint paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        canvas.drawLine(baseLineX, baseLineY, 540, baseLineY, paint2);
//设置paint
        Paint paint = new Paint();
        paint.setTextSize(120); //以px为单位
        paint.setTextAlign(Paint.Align.LEFT);

//画text所占的区域
        Paint.FontMetricsInt fm = paint.getFontMetricsInt();
        int top = baseLineY + fm.top;
        int bottom = baseLineY + fm.bottom;
        int width = (int)paint.measureText(text);
        Rect rect = new Rect(baseLineX,top,baseLineX+width,bottom);

        paint.setColor(Color.GREEN);
        canvas.drawRect(rect,paint);

//画最小矩形
        Rect minRect = new Rect();
        paint.getTextBounds(text,0,text.length(),minRect);
        minRect.top = baseLineY + minRect.top;
        minRect.bottom = baseLineY + minRect.bottom;
        paint.setColor(Color.RED);
        canvas.drawRect(minRect,paint);

//写文字
        paint.setColor(Color.BLACK);
        canvas.drawText(text, baseLineX, baseLineY, paint);
    }

    private void drawMethod(Canvas canvas) {
        String str = "sun";
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.parseColor("#00ff00"));
        int screenHeight = DisplayUtils.getScreenHeight(getContext());
        int screenWidth = DisplayUtils.getScreenWidth(getContext());
        int statusBarHeight = DisplayUtils.getStatusBarHeight(getContext());
        String screenSize = DisplayUtils.getScreenSize(getContext());
        Log.d("RectCustomView", "screenHeight:" + screenHeight + "   screenWidth:" + screenWidth + "  statusBarHeight:" + statusBarHeight + " screenSize:" + screenSize);
        int left = 180;
        int top = 0;
        int right = 360;
        int bottom = 120;
        Rect rect = new Rect(DisplayUtils.dip2px(getContext(), left), DisplayUtils.dip2px(getContext(), top), DisplayUtils.dip2px(getContext(), right), DisplayUtils.dip2px(getContext(), bottom));
        canvas.drawRect(rect, rectPaint);
        //画笔
        Paint txtpaint = new Paint();
        txtpaint.setColor(Color.WHITE);
        //字体的相关设置
        txtpaint.setTextSize(DisplayUtils.sp2px(getContext(), 15));//字体大小
        float txtWidth = txtpaint.measureText(str);
        int txtWidthDp = DisplayUtils.px2dip(getContext(), txtWidth);
        Paint.FontMetrics fontMetrics = txtpaint.getFontMetrics();
        canvas.drawText(str, DisplayUtils.dip2px(getContext(), right - txtWidthDp-10), DisplayUtils.dip2px(getContext(), bottom - 10), txtpaint);

        Paint paint = new Paint();
//设置paint
        paint.setTextSize(120); //以px为单位

        Rect minRect = new Rect();
        paint.getTextBounds(str,0,str.length(),minRect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("RectCustomView", "onMeasure");
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        Log.d("RectCustomView", "onLayout");

    }
}
