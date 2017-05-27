package com.example.skd.myapp.activitys;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.utils.DisplayUtils;
import com.example.skd.myapp.utils.MyCallBack;
import com.example.skd.myapp.views.MenuLayout;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/5/16.
 */

public class MenuLayoutActivity extends BaseActivity {
    @Bind(R.id.ll)
    LinearLayout ll;
    private ArrayList<String> strings = new ArrayList<>();
    private ArrayList<String> imglist = new ArrayList<>();
    int width;
    int height;
    int textsize=11;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_menulayout);
        ButterKnife.bind(this);

        strings.add("减脂塑形");
        strings.add("增肌");
        strings.add("格斗");
        strings.add("拉伸");
        strings.add("全部");
        imglist.add("https://cdn.leoao.com/slimming@3x.png");
        imglist.add("https://cdn.leoao.com/slimming@3x.png");
        imglist.add("https://cdn.leoao.com/slimming@3x.png");
        imglist.add("https://cdn.leoao.com/grapple@3x.png");
        imglist.add("https://cdn.leoao.com/grapple@3x.png");
        if (strings.size()==5){
            width = DisplayUtils.dip2px(this, 33);
            height = DisplayUtils.dip2px(this, 33);
            textsize=11;
        }else if (strings.size()==4){
            width = DisplayUtils.dip2px(this, 44);
            height = DisplayUtils.dip2px(this, 44);
            textsize=13;
        }else if (strings.size()==3){
            width = DisplayUtils.dip2px(this, 55);
            height = DisplayUtils.dip2px(this, 55);
            textsize=16;
        }

        ll.removeAllViews();
        for (int i = 0; i < strings.size(); i++) {
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(width, height);
            layoutParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT, 1.0f);
            layoutParams.gravity = Gravity.CENTER;
            MenuLayout menuLayout = new MenuLayout(this);
            menuLayout.setTitle(strings.get(i));
            menuLayout.setImg(imglist.get(i));
            menuLayout.iv.setLayoutParams(layoutParams1);
            menuLayout.tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, textsize);
            final int finalI = i;
            menuLayout.setMyCallBackListener(new MyCallBack() {
                @Override
                public void callback() {
                    Toast.makeText(MenuLayoutActivity.this, strings.get(finalI), Toast.LENGTH_SHORT).show();
                }
            });
            menuLayout.setLayoutParams(layoutParams);

            ll.addView(menuLayout);
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
