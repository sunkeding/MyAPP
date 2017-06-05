package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/6/5.
 */

public class SelectedBean implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SelectedBean(String name) {
        this.name = name;
    }
}
