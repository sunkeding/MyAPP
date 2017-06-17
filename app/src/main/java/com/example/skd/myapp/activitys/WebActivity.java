package com.example.skd.myapp.activitys;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

/**
 * Created by skd on 2017/6/13.
 */
//@Route(path = "/platform/test1")
public class WebActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_web);
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl("http://c.leoao.com/coach/main/");
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(false);
        webSettings.setSaveFormData(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void initView() {
        //        ARouter.getInstance().inject(this);
//        webview.loadUrl("file:///android_asset/schame-test.html");
//        Button viewById = (Button) findViewById(R.id.bt);
//        viewById.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(WebActivity.this, "模拟点击网页上的内容", Toast.LENGTH_SHORT).show();
//                String pageAction = "/num/000001";  //  /platform/100003
////                ARouter.getInstance().build(pageAction).with(bundle).navigation();
////                ARouter.getInstance().build(pageAction).navigation();
//            }
//        });
//        setResult(1000000);
    }

    @Override
    public void initData() {

    }
}
