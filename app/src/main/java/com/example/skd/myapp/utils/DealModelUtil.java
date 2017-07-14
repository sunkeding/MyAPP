package com.example.skd.myapp.utils;

import com.google.gson.internal.$Gson$Types;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * Created by skd on 2017/7/14.
 */

public abstract class DealModelUtil<T> {
    public abstract void onSuccess(T response);
    public abstract void onFailure(Call call, T response);

    /**
     * 泛型的类型
     */
    public Type mType;

    public DealModelUtil(){
        mType = getSuperclassTypeParameter(getClass());
    }

    /**
     * 获取泛型的类型
     */
    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            return JSONObject.class;
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }
}
