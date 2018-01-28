package com.example.skd.myapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.example.skd.myapp.R;

/**
 * 自定义圆环View
 * Created by skd on 2018/1/16.
 */

public class CircleProgressBar extends ProgressBar {
    /**
     * 圆形画笔
     */
    private Paint circlePaint;
    /**
     * 圆环画笔
     */
    private Paint ringPaint;

    /**
     * 圆环宽度
     */
    private float strokeWidth = 20;

    /**
     * 进度
     */
    private int mProgress;
    /**
     * 当前所画的圆环度数
     */
    private float mCurrentAngle;
    private float mCurrentPercent;//当前百分比
    /**
     * 圆的颜色
     */
    private int circleColor = Color.parseColor("#4D000000");
    /**
     * 圆环的颜色
     */
    private int ringColor = Color.parseColor("#FA4A11");


    @Override
    public void setProgress(int progress) {
        this.mProgress = progress;
    }

    @Override
    public int getProgress() {
        return mProgress;
    }

    public CircleProgressBar(Context context) {
        this(context, null);

    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar);
        circleColor = typedArray.getColor(R.styleable.CircleProgressBar_circleColor, circleColor);
        ringColor = typedArray.getColor(R.styleable.CircleProgressBar_ringColor, ringColor);
        strokeWidth = typedArray.getDimension(R.styleable.CircleProgressBar_ringWidth, strokeWidth);
        mProgress = typedArray.getInt(R.styleable.CircleProgressBar_progress, mProgress);
        typedArray.recycle();
        circlePaint = new Paint();
        circlePaint.setColor(circleColor);
        circlePaint.setAntiAlias(true);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeCap(Paint.Cap.ROUND);
        circlePaint.setStrokeWidth(strokeWidth);

        ringPaint = new Paint();
        ringPaint.setColor(ringColor);
        ringPaint.setAntiAlias(true);
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setStrokeCap(Paint.Cap.ROUND);
        ringPaint.setStrokeWidth(strokeWidth);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int cx = getMeasuredWidth() / 2;
        final int cy = getMeasuredHeight() / 2;
        final float radius = getMeasuredWidth() / 2 - strokeWidth / 2;
        canvas.save();
        canvas.rotate(-270, cx, cy); //画布沿着圆心转270度，为了画弧线的起始点在最下方
        //圆环外围的矩形
//        canvas.drawRect(new RectF(strokeWidth/2,strokeWidth/2,getMeasuredWidth()-strokeWidth/2,getMeasuredWidth()-strokeWidth/2),circlePaint);
        canvas.drawCircle(cx, cy, radius, circlePaint);
//        canvas.drawArc(new RectF(strokeWidth/2,strokeWidth/2,getMeasuredWidth()-strokeWidth/2,getMeasuredWidth()-strokeWidth/2),0, (float) (progress*360),false,ringPaint);
        canvas.drawArc(new RectF(strokeWidth / 2, strokeWidth / 2, getMeasuredWidth() - strokeWidth / 2, getMeasuredWidth() - strokeWidth / 2), 0, mCurrentAngle, false, ringPaint);

        //判断当前百分比是否小于设置目标的百分比
        if (mCurrentPercent < mProgress) {
            //当前百分比+1
            mCurrentPercent += 1;
            //当前角度+360
            mCurrentAngle += 3.6;
            //每10ms重画一次
            postInvalidateDelayed(10);

        }


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

}
