package com.example.skd.myapp.utils;

import com.example.skd.myapp.bean.CityBean;

/**
 * Created by skd on 2017/7/14.
 */

public class ApiServer {
    public static MyOkHttpUtils getCity(String url, DealModelUtil<CityBean> dealModelUtil) {
        return MyOkHttpUtils.getInstance().getAsynByModel(url, dealModelUtil);
    }


}
