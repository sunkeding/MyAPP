package com.example.skd.myapp.bean;

import java.io.Serializable;

/**
 * Created by skd on 2017/4/9.
 */

public class LekeChargeBean implements Serializable {

    /**
     * pay : {"orderNo":"785786968cesih","channel":"alipay","extra":{}}
     */

    private PayBean pay;

    public PayBean getPay() {
        return pay;
    }

    public void setPay(PayBean pay) {
        this.pay = pay;
    }

    public static class PayBean implements Serializable {
        public PayBean(String orderNo, String channel, ExtraBean extra) {
            this.orderNo = orderNo;
            this.channel = channel;
            this.extra = extra;
        }

        /**
         * orderNo : 785786968cesih
         * channel : alipay
         * extra : {}
         */

        private String orderNo;
        private String channel;
        private ExtraBean extra;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean implements Serializable{
        }
    }
}
