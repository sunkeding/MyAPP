package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.RectBean;
import com.example.skd.myapp.utils.DisplayUtils;
import com.example.skd.myapp.views.MyView;

import java.util.ArrayList;

/**
 * Created by skd on 2017/6/28.
 */

public class PaintActivity extends Activity {
    ArrayList<RectBean> list = new ArrayList<>();
    ArrayList<RectBean> list2 = new ArrayList<>();
    ArrayList<RectBean> list3 = new ArrayList<>();
    ArrayList<RectBean> list4 = new ArrayList<>();
    ArrayList<RectBean> list5 = new ArrayList<>();
    int rx = 55;
    int ry = 55;
    LinearLayout rl, rl2, rl3, rl4;
    MyView myView, myView2, myView3, myView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        rl = (LinearLayout) findViewById(R.id.rl);
        rl2 = (LinearLayout) findViewById(R.id.r2);
        rl3 = (LinearLayout) findViewById(R.id.r3);
        rl4 = (LinearLayout) findViewById(R.id.r4);

        RectBean rectBean1 = new RectBean(DisplayUtils.dip2px(this, 0), 0, DisplayUtils.dip2px(this, 300), DisplayUtils.dip2px(this, 12));
        RectBean rectBean2 = new RectBean(DisplayUtils.dip2px(this, 0), 0, DisplayUtils.dip2px(this, 120), DisplayUtils.dip2px(this, 12));
        RectBean rectBean3 = new RectBean(DisplayUtils.dip2px(this, 130), 0, DisplayUtils.dip2px(this, 200), DisplayUtils.dip2px(this, 12));
        RectBean rectBean4 = new RectBean(DisplayUtils.dip2px(this, 230), 0, DisplayUtils.dip2px(this, 300), DisplayUtils.dip2px(this, 12));
        RectBean rectBean5 = new RectBean(DisplayUtils.dip2px(this, 200), 0, DisplayUtils.dip2px(this, 250), DisplayUtils.dip2px(this, 12));
        RectBean rectBean6 = new RectBean(DisplayUtils.dip2px(this, 0), 0, DisplayUtils.dip2px(this, 300), DisplayUtils.dip2px(this, 12));

        list.add(rectBean1);
        list.add(rectBean2);
        list.add(rectBean4);

        list2.add(rectBean1);
        list2.add(rectBean3);
        list2.add(rectBean4);

        list3.add(rectBean1);
        list3.add(rectBean2);
        list3.add(rectBean3);
        list3.add(rectBean4);

        list4.add(rectBean1);
        list4.add(rectBean5);


        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(DisplayUtils.dip2px(this, 300), DisplayUtils.dip2px(this, 12));
        layoutParams2.gravity = Gravity.CENTER_VERTICAL;

        myView = new MyView(this, list);
        rl.addView(myView);


        myView2 = new MyView(this, list2);

        rl2.addView(myView2);

        myView3 = new MyView(this, list3);

        rl3.addView(myView3);
        myView4 = new MyView(this, list4);

        rl4.addView(myView4);




    }


}
