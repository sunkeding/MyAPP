package com.example.skd.myapp.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.MyCallBack;

import retrofit2.http.PUT;


/**
 * Created by skd on 2017/5/10.
 */

public class FilterView extends RelativeLayout {
    private int textSelectedColor = Color.parseColor("#ff6600");
    private int textUnSelectedColor = Color.parseColor("#ff6600");
    //tab选中图标
    private int menuSelectedIcon = R.mipmap.down_red;
    private int menuSelectedIconUp = R.mipmap.up_red;
    //tab未选中图标
    private int menuUnselectedIcon = R.mipmap.screenbar_icon_smallarrow;
    TextView tv_filter;
    ImageView iv_filter;
    RelativeLayout rl_filter;
    public final static int UP = 0;
    public final static int DOWN = 1;
    MyCallBack myCallBack;

    public void setMyCallBackListener(MyCallBack listener) {
        myCallBack = listener;
    }

    public FilterView(Context context) {
        super(context);

    }

    public FilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.filterview);
        textSelectedColor = a.getColor(R.styleable.filterview_selectetedTextcolor, textSelectedColor);
        textUnSelectedColor = a.getColor(R.styleable.filterview_unSelectetedTextcolor, textUnSelectedColor);
        menuSelectedIcon = a.getResourceId(R.styleable.filterview_selecetedIcon, menuSelectedIcon);
        menuUnselectedIcon = a.getResourceId(R.styleable.filterview_unSelecetedIcon, menuUnselectedIcon);
        String filterview_title = a.getString(R.styleable.filterview_title);
        inflate(getContext(), R.layout.filterview, this);
        a.recycle();
        tv_filter = (TextView) findViewById(R.id.tv_filter);
        iv_filter = (ImageView) findViewById(R.id.iv_filter);
        rl_filter = (RelativeLayout) findViewById(R.id.rl_filter);
        tv_filter.setTextColor(textUnSelectedColor);
        tv_filter.setText(filterview_title);
        iv_filter.setImageResource(menuUnselectedIcon);
        rl_filter.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myCallBack.callback();
            }
        });
    }

    public void setTitle(String title) {

        tv_filter.setText(title);
    }

    public String getTitle() {
        return tv_filter.getText().toString();
    }

    public void setUnSelectedState(String title) {

        setTitle(title);
        tv_filter.setTextColor(textUnSelectedColor);
        iv_filter.setImageResource(menuUnselectedIcon);
    }

    public void setSelectedState(int state,String title) {

        tv_filter.setText(title);
        tv_filter.setTextColor(textSelectedColor);
        if (state == UP) {
            iv_filter.setImageResource(menuSelectedIconUp);

        } else if (state == DOWN) {
            iv_filter.setImageResource(menuSelectedIcon);

        }
    }
}
