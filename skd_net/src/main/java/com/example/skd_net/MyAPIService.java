package com.example.skd_net;

import com.example.skd_net.bean.DouBanBean;
import com.example.skd_net.bean.WeatherBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by skd on 2017/3/19.
 */

public interface MyAPIService {
    @GET
    Call<ResponseBody> getDataByString(@Url String url);

    @GET
    Observable<ResponseBody> getDataByStringWithRxJava(@Url String url);

    @GET
    Observable<DouBanBean> getDataByEntityWithRxJava(@Url String url);

    @FormUrlEncoded
    @POST("v5/weather")
    Observable<WeatherBean> getDataByEntityWithRxJavaWithPost(@FieldMap Map<String, Object> params);
}
