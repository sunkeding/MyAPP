package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/6/29.
 */

public class RectBean implements Serializable {
    public int left;

    public RectBean(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int top;
    public int right;
    public int bottom;
}
