package com.example.skd.myapp.activitys;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.skd.myapp.MainActivity;
import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

/**
 * Created by skd on 2017/6/13.
 */

public class H5ToNativeActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_h52native);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "老哥，你触发了按钮点击事件哦,2s之后关闭本页", Toast.LENGTH_SHORT).show();//可以写个计算钱的方法或者怎么样，可以取代同一页面广播接收去触发相应方法
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(H5ToNativeActivity.this, MainActivity.class));
                        finish();
                    }
                },2000);

            }
        });
        bt1.setVisibility(View.GONE);
        bt1.performClick(); //这个操作感觉可以用来取代当前页面的接口回调啊,每次需要调用该方法的时候，就可以用performClick来触发点击事件的方法
    }


}
