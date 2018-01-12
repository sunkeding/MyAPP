package com.example.skd.myapp.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.DisplayUtil;


/**
 * Created by skd on 2018/1/11.
 */

public class LevelView extends View {
    public LevelView(Context context) {
        super(context);
    }

    public LevelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.parseColor("#FF0000"));
        Path path = new Path();

        path.lineTo(dp2px(150), dp2px(0));
        path.lineTo(dp2px(150), dp2px(60));
        path.lineTo(dp2px(0),dp2px(60));
        path.lineTo(dp2px(0),dp2px(0));

        canvas.drawPath(path, paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.addmuscle);
        canvas.drawBitmap(bitmap,dp2px(75),dp2px(10),new Paint());
        Paint txtPaint = new Paint();
        txtPaint.setColor(Color.parseColor("#ff0000"));
        txtPaint.setTextSize(dp2px(15));
        canvas.drawText("test",dp2px(20),dp2px(50),txtPaint);


        Path path1 = new Path();
            path1.moveTo(dp2px(100),dp2px(100));
            path1.lineTo(dp2px(110),dp2px(110));
            path1.lineTo(dp2px(110),dp2px(120));
            path1.lineTo(dp2px(110),dp2px(150));
//        path2.moveTo(10, 10); //移动到 坐标10,10
//
//        path2.lineTo(50, 60);
//
//        path2.lineTo(200, 80);
//
//        path2.lineTo(10, 10);
////        canvas.drawPath(path2,paint);
//        canvas.drawTextOnPath("11111", path2, 10,10, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int desiredWidth = dp2px(300);//默认宽288dp
        int desiredHeight = dp2px(300);//默认高12dp

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }

        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }

    public int dp2px(int l) {
        return DisplayUtil.dip2px(getContext(), l);
    }

}
