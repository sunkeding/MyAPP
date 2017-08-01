package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.example.skd.myapp.utils.ScreenShotUtil;
import com.orhanobut.hawk.Hawk;

import java.io.FileOutputStream;

/**
 * Created by skd on 2017/8/1.
 */

public class ScreenShotActivity extends Activity {
    Button bt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screenshot);
        Hawk.init(this).build();
        bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ScreenShotUtil.takeScreenShot(ScreenShotActivity.this);
                String s = saveBitmapToSDCard(bitmap, "666");
                Log.d("66666666666", s);
                Hawk.put("url", s);

                startActivity(new Intent(ScreenShotActivity.this, TestFromSDCard.class));
            }
        });

    }

    /**
     * 保存bitmap到SD卡
     *
     * @param bitmap
     * @param imagename
     */
    public static String saveBitmapToSDCard(Bitmap bitmap, String imagename) {
        String path = "/sdcard/" + "img-" + imagename + ".jpg";
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            if (fos != null) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fos);
                fos.close();
            }

            return path;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
