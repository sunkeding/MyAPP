package com.example.skd.myapp.activitys;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.views.CustomTextView;
import com.example.skd_net.RetrofitUtils;
import com.example.skd_net.bean.WeatherBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by skd on 2017/3/19.
 */
public class RXjavaActivity extends BaseActivity {
    @Bind(R.id.tv1)
    CustomTextView tv1;
    @Bind(R.id.tv2)
    CustomTextView tv2;
    @Bind(R.id.tv3)
    CustomTextView tv3;
    @Bind(R.id.tv4)
    CustomTextView tv4;
    @Bind(R.id.tv5)
    CustomTextView tv5;
    private String airtxt = "";
    int num = 0;
    int num2 = 0;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_rxjava);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv1://map操作符
                doMap();
                break;
            case R.id.tv2:
                doFlatMap();
                break;
            case R.id.tv3://使用timer做定时操作。当有“x秒后执行y操作”类似的需求的时候，想到使用timer
                doTimer();


                break;
            case R.id.tv4:// 使用interval做周期性操作。当有“每隔xx秒后执行yy操作”类似的需求的时候，想到使用interval

                dointerval();
                break;
            case R.id.tv5:// 使用interval做周期性操作。当有“每隔xx秒后执行yy操作”类似的需求的时候，想到使用interval

                dointervalnew();


                break;
        }
    }

    private void dointervalnew() {
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(new Func1<Long, Boolean>() {    //直到num>=5的时候就不做增加操作了，并且隐藏
                    @Override
                    public Boolean call(Long aLong) {

                        return num2 >= 5;
                    }
                }).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {
                num2++;
                tv5.setText(num2 + "");
                if (num2 >= 5) {
                    tv5.setText("已经轮询了5s");
                }
            }
        });
    }

    private void dointerval() {
        Observable.interval(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        num++;
                        tv4.setText(num + "");
                    }
                });
    }

    private void doTimer() {
        Log.d("RXjavaActivity", "System.currentTimeMillis():" + System.currentTimeMillis());
        Observable.timer(2, TimeUnit.SECONDS)
//                        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.d("RXjavaActivity", "System.currentTimeMillis():" + System.currentTimeMillis());

                        Toast.makeText(RXjavaActivity.this, "我是两秒钟之后的Toast", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void doMap() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        Observable.just(list).map(new Func1<ArrayList<String>, ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> call(ArrayList<String> strings) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                for (String s : strings) {
                    l.add(Integer.valueOf(s));
                }
                return l;
            }
        }).subscribe(new Observer<ArrayList<Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ArrayList<Integer> integers) {
                for (Integer i : integers) {
                    System.out.println(i + 1000);    //这里就分别打印出来1001,1001,1002,1003

                }
            }
        });
    }

    private void doFlatMap() {   //仅仅用来举例，可能并无实际意义
        Map<String, Object> map = new HashMap<>();
        map.put("city", "杭州");
        map.put("key", "edece9c073604873a605a44e4382d0bb");
        RetrofitUtils.getMyAPIService("https://free-api.heweather.com/").getDataByEntityWithRxJavaWithPost(map)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<WeatherBean, Observable<WeatherBean.HeWeather5Bean.SuggestionBean>>() {
                    @Override
                    public Observable<WeatherBean.HeWeather5Bean.SuggestionBean> call(WeatherBean weatherBean) {
                        WeatherBean.HeWeather5Bean.SuggestionBean suggestion = weatherBean.getHeWeather5().get(0).getSuggestion();
                        return Observable.just(suggestion);//转成 Observable<WeatherBean.HeWeather5Bean.SuggestionBean>
                    }
                })
                .flatMap(new Func1<WeatherBean.HeWeather5Bean.SuggestionBean, Observable<String>>() {
                    @Override
                    public Observable<String> call(WeatherBean.HeWeather5Bean.SuggestionBean suggestionBean) {
                        return Observable.just(suggestionBean.getAir().getTxt());//转成Observable<String>
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {//气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。
                        airtxt = s;
                        Log.d("RXjavaActivity", airtxt);
                    }
                });
//                .subscribe(new Observer<WeatherBean.HeWeather5Bean.SuggestionBean>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(WeatherBean.HeWeather5Bean.SuggestionBean suggestionBean) {
//                        airtxt = suggestionBean.getAir().getTxt();
//                        Log.d("RXjavaActivity", "suggestionBean.getAir():" + airtxt);
//                    }
//                });

    }

    @OnClick(R.id.tv5)
    public void onClick() {
    }
}
