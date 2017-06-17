package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/6/15.
 */

public class ProgressBean implements Serializable{
    public int getSelectedposition() {
        return selectedposition;
    }

    public void setSelectedposition(int selectedposition) {
        this.selectedposition = selectedposition;
    }

    public ProgressBean(int selectedposition) {
        this.selectedposition = selectedposition;
    }

    int selectedposition;
}
