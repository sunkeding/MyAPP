package com.example.skd.myapp.activitys;

import android.view.View;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

/**
 * Created by skd on 2017/6/17.
 */

public class InvokeActivity extends BaseActivity {
    Button btn;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_invoke);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test1Activity.methed();
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
