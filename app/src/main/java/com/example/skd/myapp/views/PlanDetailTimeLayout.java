package com.example.skd.myapp.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.skd.myapp.R;


/**
 * @author: skd
 * @date 2018/8/3
 * @Desc PlanDetailTimeLayout
 */
public class PlanDetailTimeLayout extends FrameLayout {
    LinearLayout ll_content;

    public PlanDetailTimeLayout(Context context) {
        this(context, null);
    }

    public PlanDetailTimeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlanDetailTimeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.exercise_plan_detail_time_layout, this);
        ll_content = findViewById(R.id.ll_content);


    }

    public void setIndex(int index, int total) {
        ll_content.removeAllViews();
        for (int i = 0; i < total; i++) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            textView.setGravity(Gravity.CENTER);
            textView.setText(String.format("第%d周", i));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);
            textView.setLayoutParams(layoutParams);


            if (index == i) {
                textView.setBackgroundResource(R.drawable.exercise_plandetail_bg_time_select);
                textView.setTextColor(Color.WHITE);


            } else {
                textView.setBackgroundResource(R.drawable.exercise_plandetail_bg_time_unselect);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.exercise_color_red30));


            }
            ll_content.addView(textView);
        }
    }
}
