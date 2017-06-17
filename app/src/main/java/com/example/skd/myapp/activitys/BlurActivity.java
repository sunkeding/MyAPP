package com.example.skd.myapp.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.blur.BlurBehind;
import com.example.skd.myapp.blur.OnBlurCompleteListener;
import com.example.skd.myapp.utils.FastBlurUtil;

import java.io.ByteArrayOutputStream;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.R.attr.bitmap;

/**
 * Created by skd on 2017/5/12.
 */

public class BlurActivity extends BaseActivity {
    @Bind(R.id.iv1)
    ImageView iv1;
    @Bind(R.id.iv2)
    ImageView iv2;
    int num;
    @Override
    protected void initListener() {
        testBugFix();//假设这个方法就是修复bug
    }

    private void testBugFix() {
        Log.d("BlurActivity", "修复线上的第二个bug");
    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_blur);
        ButterKnife.bind(this);
//        Glide.with(this).load("https://cdn.leoao.com/HZ-Tank119.png").into(iv2);
        Log.d("BlurActivity", "去掉重复的图片加载代码");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = FastBlurUtil.GetUrlBitmap("https://cdn.leoao.com/HZ-Tank119.png", 2);
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//                        byte[] bytes = baos.toByteArray();
//                        Glide.with(BlurActivity.this)
//                                .load(bytes)
//                                .into(iv2);
//                    }
//                });
//            }
//        }).start();

        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(BlurActivity.this, Test1Activity.class));
                BlurBehind.getInstance().execute(BlurActivity.this, new OnBlurCompleteListener() {
                    @Override
                    public void onBlurComplete() {
                        Intent intent = new Intent(BlurActivity.this, Test1Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                        startActivity(intent);
                    }
                });
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
