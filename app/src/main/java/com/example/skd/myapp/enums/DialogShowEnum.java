package com.example.skd.myapp.enums;

/**
 * Created by skd on 2017/8/30.
 */

public enum DialogShowEnum {
    NEEDSHOW(1, "showDialog"),
    NOSHOW(0, "notShowDialog");
    int need;
    String msg;

    DialogShowEnum(int i, String showDialog) {
        this.need = i;
        this.msg = showDialog;
    }

    public int getNeed() {
        return need;
    }

    public String getMsg() {
        return msg;
    }

}
