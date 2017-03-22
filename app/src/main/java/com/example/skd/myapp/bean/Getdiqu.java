package com.example.skd.myapp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/3/16.
 */
public class Getdiqu implements Serializable {


    /**
     * info :
     * list : [{"id":"1001","value":"西湖区"},{"id":"1002","value":"拱墅区"},{"id":"1004","value":"江干区"},{"id":"1005","value":"滨江区"},{"id":"1007","value":"上城区"},{"id":"1008","value":"下城区"},{"id":"1009","value":"余杭区"},{"id":"1010","value":"萧山区"},{"id":"1011","value":"富阳区"}]
     * state : 1
     */

    private String info;
    private String state;
    /**
     * id : 1001
     * value : 西湖区
     */

    private List<ListEntity> list;

    public void setInfo(String info) {
        this.info = info;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public String getInfo() {
        return info;
    }

    public String getState() {
        return state;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public static class ListEntity  implements Serializable {
        private String id;
        private String value;

        public void setId(String id) {
            this.id = id;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getId() {
            return id;
        }

        public String getValue() {
            return value;
        }
    }
}
