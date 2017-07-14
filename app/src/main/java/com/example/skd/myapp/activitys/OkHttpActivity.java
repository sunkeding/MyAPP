package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.CityBean;
import com.example.skd.myapp.utils.ApiServer;
import com.example.skd.myapp.utils.DealModelUtil;
import com.example.skd.myapp.utils.MyOkHttpUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by skd on 2017/7/14.
 */

public class OkHttpActivity extends Activity {
    @Bind(R.id.bt1)
    Button bt1;
    @Bind(R.id.bt2)
    Button bt2;
    String url = "http://www.easy-mock.com/mock/596870abc7f609711fa08f89/example/citys";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        ButterKnife.bind(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                OkHttpUtils.get().url("http://www.easy-mock.com/mock/596870abc7f609711fa08f89/example/citys").build().execute(new StringCallback() {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response, int id) {
//                        Toast.makeText(OkHttpActivity.this, response, Toast.LENGTH_SHORT).show();
//                    }
//                });

//                MyOkHttpUtils.getInstance().getAsynByString(url, new MyOkHttpUtils.StringCallback() {
//                    @Override
//                    public void onFailure(Call request, IOException e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(OkHttpActivity.this, response, Toast.LENGTH_SHORT).show();
//                    }
//                });

                ApiServer.getCity(url, new DealModelUtil<CityBean>() {
                    @Override
                    public void onSuccess(CityBean response) {
                        for (CityBean.DataBean.ListBean listBean : response.getData().getList()) {
                            Log.d("OkHttpActivity", "listBean.getCityId():" + listBean.getCityId() + "    " + listBean.getCityName());
                        }
                    }

                    @Override
                    public void onFailure(Call call, CityBean response) {

                    }
                });
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOkHttpUtils.getInstance().getAsynByModel(url, new DealModelUtil<CityBean>() {
                    @Override
                    public void onSuccess(CityBean response) {
                        for (CityBean.DataBean.ListBean listBean : response.getData().getList()) {
                            Log.d("OkHttpActivity", "listBean.getCityId():" + listBean.getCityId() + "    " + listBean.getCityName());
                        }
                    }

                    @Override
                    public void onFailure(Call call, CityBean response) {

                    }
                });
            }
        });
    }
}
