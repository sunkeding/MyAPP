package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/3/19.
 */

/**
 *
 */

public class ListViewDemoBean implements Serializable {

    public ListViewDemoBean(String name, boolean hasselected) {
        this.name = name;
        this.hasselected = hasselected;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasselected() {
        return hasselected;
    }

    public void setHasselected(boolean hasselected) {
        this.hasselected = hasselected;
    }

    boolean hasselected;
}
