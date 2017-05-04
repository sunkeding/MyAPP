package com.example.skd.myapp.activitys;

import android.content.Intent;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by skd on 2017/3/23.
 */
public class Test2Activity extends BaseActivity {
    @Bind(R.id.bt_test)
    Button btTest;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_test2);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.bt_test)
    public void onClick() {
//        AppManager.getInstance().popToActivity(MainActivity.class);//跳转到指定Activity,并关闭掉中间的所有Activity
        startActivity(new Intent(this,Test3Activity.class));
    }
}
