package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.DisplayUtils;
import com.example.skd.myapp.utils.shadowutil.ShadowProperty;
import com.example.skd.myapp.utils.shadowutil.ShadowViewDrawable;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/7/20.
 */

public class ShadowViewActivity extends Activity {
    @Bind(R.id.ll1)
    LinearLayout ll1;
    @Bind(R.id.tv1)
    TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadowutil);
        ButterKnife.bind(this);
        // all side shadow
        ShadowProperty sp = new ShadowProperty()
                .setShadowColor(0x77000000)
                .setShadowDy(DisplayUtils.dip2px(this, 0.5f))
                .setShadowRadius(DisplayUtils.dip2px(this, 3))
                .setShadowSide(ShadowProperty.ALL);
        ShadowViewDrawable sd = new ShadowViewDrawable(sp, Color.GREEN, 0, 0);
        ViewCompat.setBackground(ll1, sd);
        ViewCompat.setLayerType(ll1, ViewCompat.LAYER_TYPE_SOFTWARE, null);

// only all sides except top shadow
        ShadowProperty sp2 = new ShadowProperty()
                .setShadowColor(0x770000FF)
                .setShadowDy(DisplayUtils.dip2px(this, 3f))
                .setShadowRadius(DisplayUtils.dip2px(this, 3))
                .setShadowSide(ShadowProperty.LEFT | ShadowProperty.RIGHT | ShadowProperty.BOTTOM);
        ShadowViewDrawable sd2 = new ShadowViewDrawable(sp2, ContextCompat.getColor(this,R.color.text_color_red), 0, 0);
        ViewCompat.setBackground(tv1, sd2);
        ViewCompat.setLayerType(tv1, ViewCompat.LAYER_TYPE_SOFTWARE, null);
    }
}
