package com.example.skd.myapp.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.skd.myapp.R;

/**
 * Created by skd on 2017/5/11.
 */

public class DropView extends LinearLayout {
    public FilterView filterview1, filterview2, filterview3,filterview4;
    private String defaulttitle1 = "";
    private String defaulttitle2 = "";
    private String defaulttitle3 = "";
    private String defaulttitle4 = "";

    public DropView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.dropview, this);
        filterview1 = (FilterView) findViewById(R.id.filterview1);
        filterview2 = (FilterView) findViewById(R.id.filterview2);
        filterview3 = (FilterView) findViewById(R.id.filterview3);
        filterview4 = (FilterView) findViewById(R.id.filterview4);

    }

    public DropView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    public DropView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public void updateDropView(String title1, String title2, String title3,String title4) {
        if (defaulttitle1.equals(title1)) {
            filterview1.setUnSelectedState(title1);

        } else {
            filterview1.setSelectedState(FilterView.DOWN, title1);
        }
        if (defaulttitle2.equals(title2)) {
            filterview2.setUnSelectedState(title2);

        } else {
            filterview2.setSelectedState(FilterView.DOWN, title2);
        }
        if (defaulttitle3.equals(title3)) {
            filterview3.setUnSelectedState(title3);

        } else {
            filterview3.setSelectedState(FilterView.DOWN, title3);
        }
        if (defaulttitle4.equals(title4)) {
            filterview4.setUnSelectedState(title4);

        } else {
            filterview4.setSelectedState(FilterView.DOWN, title4);
        }
    }

    public void setDefaultTitles(String title1, String title2, String title3,String title4) {
        this.defaulttitle1 = title1;
        this.defaulttitle2 = title2;
        this.defaulttitle3 = title3;
        this.defaulttitle4 = title4;
        filterview1.setTitle(defaulttitle1);
        filterview2.setTitle(defaulttitle2);
        filterview3.setTitle(defaulttitle3);
        filterview4.setTitle(defaulttitle4);
    }
}
