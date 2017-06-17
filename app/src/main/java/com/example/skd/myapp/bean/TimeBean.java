package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/6/15.
 */

public class TimeBean implements Serializable{
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public TimeBean(String time) {
        this.time = time;
    }

    String time;
}
