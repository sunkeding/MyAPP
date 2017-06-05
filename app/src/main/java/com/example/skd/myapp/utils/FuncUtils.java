package com.example.skd.myapp.utils;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


/**
 * Created by dipingye on 16/11/9.
 */

public class FuncUtils {
    public static boolean sizeBiggerThan(Map map, int pos) {
        return null != map && pos >= 0 && pos < map.size();
    }

    public static <T> boolean sizeBiggerThan(List<T> list, int pos) {
        return null != list && pos >= 0 && pos < list.size();
    }

    public static <T> boolean sizeBiggerThanAndEqual(List<T> list, int pos) {
        return null != list && pos >= 0 && pos <= list.size();
    }

    public static <T> boolean isLastPos(List<T> list, int pos) {
        return null != list && pos >= 0 && pos == list.size() - 1;
    }

    private static long lastClickTime = 0;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (timeD >= 0 && timeD <= 300) {
            return true;
        } else {
            lastClickTime = time;
            return false;
        }
    }

    /**
     * @param value
     * @param defaultValue
     * @return integer
     * @throws
     * @Title: convertToInt
     * @Description: 对象转化为整数数字类型
     */
    public final static int convertToInt(Object value, int defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(value.toString());
        } catch (Exception e) {
            try {
                return Double.valueOf(value.toString()).intValue();
            } catch (Exception e1) {
                return defaultValue;
            }
        }
    }

    public static String strEncode(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String strDecode(String str) {
        if (null == str)
            return null;

        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    public static boolean isPhoneNum(String phoneNum) {
        if (!TextUtils.isEmpty(phoneNum))
            return phoneNum.matches("^[1][0-9]{10}$");

        return false;
    }

    public static String hidePhoneNum(String phoneNum) {
        if (!TextUtils.isEmpty(phoneNum))
            return phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        return "";
    }

    public static String hideMail(String mail) {
        if (!TextUtils.isEmpty(mail))
            return mail.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
        return "";
    }

    public static boolean getBoolaean(int flag) {
        return (1 == flag);
    }

    public static void synCookies(Context context, String url, String cookie) {
        if (TextUtils.isEmpty(url) || TextUtils.isEmpty(cookie))
            return;

        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie(url, cookie);
        CookieSyncManager.getInstance().sync();
    }

    public static void removeCookie(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

}
