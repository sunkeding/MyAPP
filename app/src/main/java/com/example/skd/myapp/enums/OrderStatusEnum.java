package com.example.skd.myapp.enums;

/**
 * Created by skd on 2017/8/30.
 */

public enum OrderStatusEnum {
    STATUS_YES(1), STATUS_NO(0), NONE(-1);
    int flag;


    OrderStatusEnum(int i) {
        this.flag = i;
    }

    public static OrderStatusEnum createWithCode(int flag) {
        for (OrderStatusEnum value : OrderStatusEnum.values()) {
            if (value.flag == flag) {
                return value;
            }
        }
        return NONE;
    }
}
