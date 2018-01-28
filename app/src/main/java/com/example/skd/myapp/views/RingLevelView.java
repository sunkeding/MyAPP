package com.example.skd.myapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.skd.myapp.utils.DisplayUtil;

/**
 * Created by skd on 2018/1/16.
 */

public class RingLevelView extends ProgressBar {
    private Paint paint;
    private int mwidth = 100;
    private int mheight = 100;
    private Paint paint2;
    private int strokeWidth = 20;
    private float percent;
    private Paint paint3;


    @Override
    public void setProgress(int progress) {
        this.progress = progress;
    }

    double progress = 0.7;

    public RingLevelView(Context context) {
        this(context, null);

    }

    public RingLevelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RingLevelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(strokeWidth);

        paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(strokeWidth);

        paint3 = new Paint();
        paint3.setColor(Color.RED);
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setStrokeWidth(strokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int cx = getMeasuredWidth() / 2;
        final int cy = getMeasuredHeight() / 2;
        final int radius = getMeasuredWidth() / 2 - strokeWidth / 2;
        Log.d("RingLevelView", "cx:" + cx);
        Log.d("RingLevelView", "cy:" + cy);
        Log.d("RingLevelView", "radius:" + radius);
        canvas.save();
        canvas.rotate(-270, cx, cy); //画布沿着圆心转270度，为了画弧线的起始点在最下方
        canvas.drawRect(new RectF(strokeWidth/2,strokeWidth/2,getMeasuredWidth()-strokeWidth/2,getMeasuredWidth()-strokeWidth/2),paint3);
        canvas.drawCircle(cx, cy, radius, paint);
        canvas.drawArc(new RectF(strokeWidth/2,strokeWidth/2,getMeasuredWidth()-strokeWidth/2,getMeasuredWidth()-strokeWidth/2),0, (float) (progress*360),false,paint2);
        canvas.restore();



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int desiredWidth = getWidth();
        int desiredHeight = getHeight();

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

    public int dp2px(float l) {
        return DisplayUtil.dip2px(getContext(), l);
    }
}
