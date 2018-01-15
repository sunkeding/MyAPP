package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.skd.myapp.R;

/**
 * @author skd
 * @date 2018/1/15
 */

public class AddViewActivity extends Activity {
    ViewGroup ll_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addview);
        ll_content = (ViewGroup) findViewById(R.id.ll_content);
//        View view2=new TextView(this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
//        layoutParams.setMargins(20,0,20,0);
//        view2.setLayoutParams(layoutParams);
        ll_content.removeAllViews();
        for (int i = 0; i < 6; i++) {
            View view = View.inflate(this, R.layout.item_addview, null);

            ll_content.addView(view);

        }
//        LinearLayout ll = new LinearLayout(this);
//        ll.removeAllViews();
//        ll.addView(view);
    }
}
