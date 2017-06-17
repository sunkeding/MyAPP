package com.example.skd.myapp.activitys;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by skd on 2017/5/22.
 */
//@Route(path = "/num/000001")
public class TestMyActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.servicetestnew);
        ButterKnife.bind(this);
//        ARouter.getInstance().inject(this);


    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
