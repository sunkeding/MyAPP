package com.example.skd.myapp.activitys;

import android.util.Log;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.utils.LogUtil;
import com.example.skd.myapp.views.CustomTextView;
import com.example.skd_net.RetrofitUtils;
import com.example.skd_net.bean.DouBanBean;
import com.example.skd_net.bean.WeatherBean;
import com.example.skd_net.constant.UrlConstant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by skd on 2017/3/19.
 */

public class NetActivity extends BaseActivity {
    @Bind(R.id.tv1)
    CustomTextView tv1;
    @Bind(R.id.tv2)
    CustomTextView tv2;
    private static final String TAG = "NetActivity";

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_retrofit);

    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4})
    public void onClick(View view) {
        String url = "https://api.douban.com/v2/movie/top250?start=0&count=10";
        switch (view.getId()) {
            case R.id.tv1:

                RetrofitUtils.getMyAPIService(UrlConstant.baseUrlnew).getDataByString(url).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            LogUtil.d(TAG, "字符串为：" + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                        Log.d(TAG, "throwable:" + throwable);
                    }
                });
                break;
            case R.id.tv2:
                RetrofitUtils.getMyAPIService(UrlConstant.baseUrlnew)
                        .getDataByStringWithRxJava(url)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {

                                try {
                                    LogUtil.d(TAG, "字符串为：" + responseBody.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
                break;
            case R.id.tv3:
                RetrofitUtils.getMyAPIService(UrlConstant.baseUrlnew)
                        .getDataByEntityWithRxJava(url)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<DouBanBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(DouBanBean douBanBean) {
                                LogUtil.d(TAG, "标题=" + douBanBean.getTitle() + "第一部电影标题=" + douBanBean.getSubjects().get(0).getTitle());
                            }
                        });
                break;
            case R.id.tv4://  https://free-api.heweather.com/v5/weather?city=杭州&key=edece9c073604873a605a44e4382d0bb
                Map<String, Object> map = new HashMap<>();
                map.put("city", "杭州");
                map.put("key", "edece9c073604873a605a44e4382d0bb");
                RetrofitUtils.getMyAPIService("https://free-api.heweather.com/").getDataByEntityWithRxJavaWithPost(map)
                        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<WeatherBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(WeatherBean weatherBean) {
                        Log.d(TAG, "weatherBean.getHeWeather5():" + weatherBean.getHeWeather5());
                    }
                });
                break;
        }
    }
}
