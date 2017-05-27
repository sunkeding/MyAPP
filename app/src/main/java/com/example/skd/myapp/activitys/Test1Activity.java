package com.example.skd.myapp.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.blur.BlurBehind;
import com.example.skd.myapp.utils.FastBlurUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by skd on 2017/3/23.
 */
public class Test1Activity extends BaseActivity {
    @Bind(R.id.bt_test)
    Button btTest;
    @Bind(R.id.iv)
    ImageView iv;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.white);
//        Bitmap bitmap1 = FastBlurUtil.toBlur(bitmap, 90);
//        iv.setImageBitmap(bitmap1);
        BlurBehind.getInstance()//在你需要添加模糊或者透明的背景中只需要设置这几行简单的代码就可以了
                .withAlpha(80)
                .withFilterColor(Color.parseColor("#d0ffffff"))
                .setBackground(this);
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
        startActivity(new Intent(this, Test2Activity.class));
    }

}
