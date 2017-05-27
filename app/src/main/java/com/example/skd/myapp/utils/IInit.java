package com.example.skd.myapp.utils;

/**
 * Created by skd
 * 自定义控件初始化
 */
public interface IInit<T> {

    void init();
    void initData(T t);
}
