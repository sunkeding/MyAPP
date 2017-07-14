package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by skd on 2017/5/12.
 */

public class ViewHelperActivity extends FragmentActivity implements View.OnClickListener {
    private View header_logo;
    private float moveDistanceY = 25;// logo初始移动距离为10
    private float moveDistanceX = 25;// logo初始移动距离为10

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewhelper);
        initAllViews();
    }

    private void initAllViews() {
        header_logo = findViewById(R.id.header_logo);
        findViewById(R.id.btn_moveUp).setOnClickListener(this);
        findViewById(R.id.btn_moveDown).setOnClickListener(this);
        findViewById(R.id.btn_moveDown2).setOnClickListener(this);
        findViewById(R.id.btn_moveLeft).setOnClickListener(this);
        findViewById(R.id.btn_moveRight).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_moveDown :
                moveDistanceY += 20;
                ViewHelper.setTranslationY(header_logo, moveDistanceY);
                break;
            case R.id.btn_moveDown2:
                TranslateAnimation translateAnimation = new TranslateAnimation(0f, 0f, 0f, 0f);
                translateAnimation.setDuration(300);//动画的持续时间，单位毫秒
                translateAnimation.setFillAfter(true);//参数为true表示动画结束后View停留在结束为止
                header_logo.startAnimation(translateAnimation);//开始动画
                break;

            case R.id.btn_moveUp :
                moveDistanceY -= 20;
                ViewHelper.setTranslationY(header_logo, moveDistanceY);
                break;

            case R.id.btn_moveLeft :
                moveDistanceX -= 20;
                ViewHelper.setTranslationX(header_logo, moveDistanceX);
                break;

            case R.id.btn_moveRight :
                moveDistanceX += 20;
                ViewHelper.setTranslationX(header_logo, moveDistanceX);
                break;

            default :
                break;
        }
    }
}
