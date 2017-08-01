package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.RSRuntimeException;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.SampleBean;
import com.example.skd.myapp.utils.FastBlur;
import com.example.skd.myapp.utils.RSBlur;
import com.orhanobut.hawk.Hawk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by skd on 2017/8/1.
 */

public class TestFromSDCard extends Activity {
    Bitmap bitmap;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fromsdcard);
        iv = (ImageView) findViewById(R.id.iv);
        //本地文件
        String url = Hawk.get("url");

        bitmap = decodeFile(new File(url));
        new BlurTask().execute();
        //bitmap都可以存，厉害了
//        Bitmap bitmap2 = Hawk.get("bitmap");
//        iv.setImageBitmap(bitmap2);
//        File file = new File(Environment.getExternalStorageDirectory(), "img-666.jpg");
//        Glide.with(this).load(file).into(iv);
    }

    public static Bitmap decodeFile(File f) {
        try {
// 解码图片大小
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f), null, o);

// 我们想要的新的图片大小
            final int REQUIRED_SIZE = 70;
            int scale = 1;
            while (o.outWidth / scale / 2 >= REQUIRED_SIZE
                    && o.outHeight / scale / 2 >= REQUIRED_SIZE)
                scale *= 2;

// 用inSampleSize解码
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize = scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {
            System.out.println("图片解析失败~~~苍天呀");
        }
        return null;
    }

    private class BlurTask extends AsyncTask<Void, Void, Bitmap> {

        public BlurTask() {
        }

        @Override
        protected Bitmap doInBackground(Void... params) {

            if (bitmap != null) {
                Bitmap bitmap1;
                try {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                        try {
                            bitmap1 = RSBlur.blur(TestFromSDCard.this, bitmap, 10);
                        } catch (RSRuntimeException e) {
                            bitmap1 = FastBlur.doBlur(bitmap, 10, false);
                        }
                    } else {
                        bitmap1 = FastBlur.doBlur(bitmap, 10, false);
                    }
                    return bitmap1;
                } catch (Exception e) {
                    return bitmap;
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (bitmap != null) {
                iv.setImageBitmap(bitmap);
            }
        }
    }
}
