package com.example.skd.myapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.example.skd.myapp.utils.DisplayUtil;


/**
 * Created by skd on 2018/1/11.
 */

public class LevelView extends View {
    private float mwidth=160;
    private float mheight=46;
    private Paint paint1;
    private Paint paint2;


    public LevelView(Context context) {
        super(context);
    }

    public LevelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LevelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         paint1 = new Paint();
        paint1.setAntiAlias(true);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(2);
        paint1.setColor(Color.parseColor("#FF0000"));
        paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2);
        paint2.setColor(Color.parseColor("#00FFFF"));
        paint2.setStyle(Paint.Style.FILL);
//        canvas.drawRoundRect(0,0,dp2px(mwidth),dp2px(mheight),dp2px(6),dp2px(6), paint1);
        Path path = new Path();
        path.lineTo(dp2px(mwidth*2), dp2px(0));
        path.lineTo(dp2px(mwidth*2 + 50), dp2px(dp2px(mheight)));
        path.lineTo(0, dp2px(mheight));
        path.lineTo(0, 0);
        canvas.drawPath(path,paint2);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int desiredWidth = dp2px(mwidth);
        int desiredHeight = dp2px(mheight);

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
