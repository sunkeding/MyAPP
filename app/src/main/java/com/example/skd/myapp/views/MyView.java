package com.example.skd.myapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.RectBean;
import com.example.skd.myapp.utils.DisplayUtils;

import java.util.ArrayList;

/**
 * Created by skd on 2017/6/28.
 */

public class MyView extends View {
    ArrayList<RectBean> list;

    public MyView(Context context, ArrayList<RectBean> list) {
        super(context);
        this.list = list;
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(ContextCompat.getColor(getContext(), R.color.text_color_black10));//设置画笔颜色
        canvas.drawColor(Color.WHITE);                  //白色背景
//        paint.setStrokeWidth((float) 2.0);              //线宽
        paint.setStyle(Paint.Style.FILL_AND_STROKE);



        for (int i = 0; i < list.size(); i++) {
            RectBean rectBean = list.get(i);
            RectF rect = new RectF(rectBean.left, rectBean.top, rectBean.right, rectBean.bottom);// 设置个新的长方形

            if (i == 0) {
                canvas.drawRoundRect(rect, 55, 55, paint);//第二个参数是x半径，第三个参数是y半径
            } else {
                paint.setColor(Color.parseColor("#6EC174"));
                canvas.drawRoundRect(rect, 55, 55, paint);//第二个参数是x半径，第三个参数是y半径
            }
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int desiredWidth = DisplayUtils.dip2px(getContext(), 300);
        int desiredHeight = DisplayUtils.dip2px(getContext(), 12);

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
