package com.example.skd.myapp.activitys;

import android.graphics.Color;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.utils.ToastUtils;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by skd on 2017/3/23.
 */
public class ViewStubActivity extends BaseActivity {
    @Bind(R.id.bt1)
    Button bt1;
    @Bind(R.id.viewstub)
    ViewStub viewstub;
    private Button btn2;
    private boolean hasinflate;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_viewstub);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.bt1)
    public void onClick() {
        if (!hasinflate) {
            viewstub.inflate();//只允许加载一次
            hasinflate = true;
            btn2 = (Button) findViewById(R.id.btn2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.showCenterToast(ViewStubActivity.this, "Toast在中间");
//                    Toast.makeText(ViewStubActivity.this, "点击了第二个按钮，此时我需要做一些事", Toast.LENGTH_SHORT).show();
                    btn2.setBackgroundColor(Color.parseColor("#00ffff"));
                }
            });
        }


    }
}
