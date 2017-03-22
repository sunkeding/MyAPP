package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/3/19.
 */

/**
 *
 */

public class SampleBean implements Serializable {

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public SampleBean(String introduce) {
        this.introduce = introduce;
    }

    private String introduce;
}
