package com.example.skd.myapp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.MyCallBack;

/**
 * Created by skd on 2017/5/16.
 */

public class MenuLayout extends RelativeLayout{
    private RelativeLayout rl;
    public ImageView iv;
    public TextView tv;
    MyCallBack myCallBack;

    public void setMyCallBackListener(MyCallBack listener) {
        myCallBack = listener;
    }
    public MenuLayout(Context context) {
        super(context);
        init();
    }


    public MenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        inflate(getContext(), R.layout.menulayout, this);
        rl = (RelativeLayout) findViewById(R.id.rl);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
        rl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myCallBack!=null){
                    myCallBack.callback();

                }
            }
        });
    }

    public void setTitle(String title) {
        tv.setText(title);
    }

    public void setImg(String url) {
        Glide.with(getContext()).load(url).into(iv);
    }

}
