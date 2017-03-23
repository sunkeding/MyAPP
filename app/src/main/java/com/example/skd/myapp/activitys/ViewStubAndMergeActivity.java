package com.example.skd.myapp.activitys;

import android.content.Intent;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.views.CustomTextView;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by skd on 2017/3/23.
 */
public class ViewStubAndMergeActivity extends BaseActivity {
    @Bind(R.id.tv1)
    CustomTextView tv1;
    @Bind(R.id.tv2)
    CustomTextView tv2;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_viewstubandmerge);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.tv1, R.id.tv2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                startActivity(new Intent(ViewStubAndMergeActivity.this,ViewStubActivity.class));
                break;
            case R.id.tv2:
                startActivity(new Intent(ViewStubAndMergeActivity.this,MergeActivity.class));
                break;
        }
    }
}
