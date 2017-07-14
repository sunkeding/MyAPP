package com.example.skd.myapp.bean;

import java.util.List;

/**
 * Created by skd on 2017/7/14.
 */

public class CityBean  {

    /**
     * code : 200
     * resultmessage : success
     * data : {"list":[{"cityId":12597,"cityName":"杭州市","countyRespList":[{"countyId":12626,"countyName":"拱墅区"},{"countyId":12637,"countyName":"西湖区"},{"countyId":12685,"countyName":"余杭区"},{"countyId":12615,"countyName":"江干区"},{"countyId":12606,"countyName":"下城区"},{"countyId":12652,"countyName":"滨江区"},{"countyId":12599,"countyName":"上城区"},{"countyId":12656,"countyName":"萧山区"},{"countyId":12598,"countyName":"市辖区"}]},{"cityId":2,"cityName":"北京市","countyRespList":[{"countyId":39,"countyName":"朝阳区"},{"countyId":115,"countyName":"海淀区"},{"countyId":105,"countyName":"石景山区"},{"countyId":245,"countyName":"大兴区"},{"countyId":3,"countyName":"东城区"},{"countyId":14,"countyName":"西城区"},{"countyId":110229,"countyName":"延庆县"}]},{"cityId":10544,"cityName":"上海市","countyRespList":[{"countyId":10575,"countyName":"长宁区"},{"countyId":10636,"countyName":"闵行区"},{"countyId":10664,"countyName":"嘉定区"},{"countyId":10623,"countyName":"杨浦区"},{"countyId":10678,"countyName":"浦东新区"},{"countyId":10715,"countyName":"松江区"},{"countyId":10560,"countyName":"徐汇区"},{"countyId":10612,"countyName":"虹口区"},{"countyId":10545,"countyName":"黄浦区"},{"countyId":10650,"countyName":"宝山区"},{"countyId":10735,"countyName":"青浦区"},{"countyId":10586,"countyName":"静安区"},{"countyId":10592,"countyName":"普陀区"}]},{"cityId":10809,"cityName":"南京市","countyRespList":[{"countyId":10860,"countyName":"浦口区"},{"countyId":10831,"countyName":"秦淮区"},{"countyId":10894,"countyName":"雨花台区"},{"countyId":10845,"countyName":"鼓楼区"}]},{"cityId":19281,"cityName":"济南市","countyRespList":[{"countyId":19295,"countyName":"市中区"},{"countyId":19283,"countyName":"历下区"}]},{"cityId":339,"cityName":"天津市","countyRespList":[{"countyId":120101,"countyName":"和平区"}]},{"cityId":1291,"cityName":"邯郸市","countyRespList":[{"countyId":1307,"countyName":"丛台区"}]}]}
     */

    private int code;
    private String resultmessage;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResultmessage() {
        return resultmessage;
    }

    public void setResultmessage(String resultmessage) {
        this.resultmessage = resultmessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * cityId : 12597
             * cityName : 杭州市
             * countyRespList : [{"countyId":12626,"countyName":"拱墅区"},{"countyId":12637,"countyName":"西湖区"},{"countyId":12685,"countyName":"余杭区"},{"countyId":12615,"countyName":"江干区"},{"countyId":12606,"countyName":"下城区"},{"countyId":12652,"countyName":"滨江区"},{"countyId":12599,"countyName":"上城区"},{"countyId":12656,"countyName":"萧山区"},{"countyId":12598,"countyName":"市辖区"}]
             */

            private int cityId;
            private String cityName;
            private List<CountyRespListBean> countyRespList;

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public List<CountyRespListBean> getCountyRespList() {
                return countyRespList;
            }

            public void setCountyRespList(List<CountyRespListBean> countyRespList) {
                this.countyRespList = countyRespList;
            }

            public static class CountyRespListBean {
                /**
                 * countyId : 12626
                 * countyName : 拱墅区
                 */

                private int countyId;
                private String countyName;

                public int getCountyId() {
                    return countyId;
                }

                public void setCountyId(int countyId) {
                    this.countyId = countyId;
                }

                public String getCountyName() {
                    return countyName;
                }

                public void setCountyName(String countyName) {
                    this.countyName = countyName;
                }
            }
        }
    }
}
