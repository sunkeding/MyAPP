//package com.example.skd.myapp.activitys;
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.util.Log;
//import android.view.View;
//
//import com.example.skd.myapp.R;
//import com.example.skd.myapp.base.BaseActivity;
//import com.example.skd.myapp.bean.LekeChargeBean;
//import com.example.skd.myapp.views.CustomTextView;
//import com.google.gson.Gson;
//import com.pingplusplus.android.Pingpp;
//
//import java.io.IOException;
//
//import butterknife.Bind;
//import butterknife.OnClick;
//import okhttp3.Call;
//import okhttp3.Callback;
//import okhttp3.MediaType;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.RequestBody;
//import okhttp3.Response;
//import rx.Observable;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Action1;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;
//
///**
// * Created by skd on 2017/3/28.
// */
//
//public class PingActivity extends BaseActivity {
//
//    @Bind(R.id.tv1)
//    CustomTextView tv1;
//    @Bind(R.id.tv2)
//    CustomTextView tv2;
////    @Bind(R.id.tv3)
////    CustomTextView tv3;
//
//    /**
//     * 开发者需要填一个服务端URL 该URL是用来请求支付需要的charge。务必确保，URL能返回json格式的charge对象。
//     * 服务端生成charge 的方式可以参考ping++官方文档，地址 https://pingxx.com/guidance/server/import
//     * <p>
//     * 【 http://218.244.151.190/demo/charge 】是 ping++ 为了方便开发者体验 sdk 而提供的一个临时 url 。
//     * 该 url 仅能调用【模拟支付控件】，开发者需要改为自己服务端的 url 。
//     */
////    private static String YOUR_URL = "http://218.244.151.190/demo/charge";
//    private static String YOUR_URL = "http://dms.leoao.com/test/pay";
//    //    private static String YOUR_URL = "http://192.168.213.60:8080";
//    public static final String URL = YOUR_URL;
//
//    /**
//     * 银联支付渠道
//     */
//    private static final String CHANNEL_UPACP = "upacp";
//    /**
//     * 微信支付渠道
//     */
//    private static final String CHANNEL_WECHAT = "wx";
//    /**
//     * 微信支付渠道
//     */
//    private static final String CHANNEL_QPAY = "qpay";
//    /**
//     * 支付支付渠道
//     */
//    private static final String CHANNEL_ALIPAY = "alipay";
//    /**
//     * 百度支付渠道
//     */
//    private static final String CHANNEL_BFB = "bfb";
//    /**
//     * 京东支付渠道
//     */
//    private static final String CHANNEL_JDPAY_WAP = "jdpay_wap";
//    private int num = 1;
//
//    @Override
//    protected void initListener() {
//    }
//
//    @Override
//    public void setMyContentView() {
//        setContentView(R.layout.activity_ping);
//    }
//
//    @Override
//    public void initView() {
//
//    }
//
//    @Override
//    public void initData() {
//
//    }
//
//
//    @OnClick({R.id.tv1, R.id.tv2})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tv1:
////                new PaymentTask().execute(new PaymentRequest(CHANNEL_ALIPAY, 1));
////                RxAsycTask();
//                //异步
//                LekeChargeBean paymentRequest =new LekeChargeBean();
//                paymentRequest.setPay(new LekeChargeBean.PayBean("850927297769766912", CHANNEL_ALIPAY, null));
//
//                String json = new Gson().toJson(paymentRequest);
//                OkHttpClient client = new OkHttpClient();//创建okhttp实例
//                MediaType type = MediaType.parse("application/json; charset=utf-8");
//                RequestBody body = RequestBody.create(type, json);
//                Request request = new Request.Builder()
//                        .url(URL)
//                        .post(body)
//                        .build();
//                Call call = client.newCall(request);
//                call.enqueue(new Callback() {
//                    //请求失败时调用
//                    @Override
//                    public void onFailure(Call call, IOException e) {
//
//                    }
//
//                    //请求成功时调用
//                    @Override
//                    public void onResponse(Call call, final Response response) throws IOException {
//                        if (response.isSuccessful()) {
//                            Log.d("skd", "" + "onResponse: " + response.body().string());
//                            String string = response.body().string();
//                            Pingpp.createPayment(PingActivity.this, string);
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//
//                                }
//                            });
//                        }
//                    }
//                });
//                break;
//            case R.id.tv2:
//                num++;
//                LekeChargeBean lekeChargeBean = new LekeChargeBean();
//                lekeChargeBean.setPay(new LekeChargeBean.PayBean("850927297769766912", CHANNEL_ALIPAY, null));
//                new PaymentTask().execute(lekeChargeBean);
//
//                break;
////            case R.id.tv3:
////                break;
//        }
//    }
//
//    private void RxAsycTask() {
//        PaymentRequest p = new PaymentRequest(CHANNEL_ALIPAY, 1);
//        Observable.just(p).map(new Func1<PaymentRequest, String>() {
//            @Override
//            public String call(PaymentRequest paymentRequest) {
//                Log.d("66666", Thread.currentThread().getName());
//                String data = null;
//                String json = new Gson().toJson(paymentRequest);
//                Log.d("PingActivity", "doInBackground方法json=" + json);
//
//                try {
//                    //向Your Ping++ Server SDK请求数据
//
//                    data = postJson(URL, json);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                Log.d("PingActivity", "doInBackground方法返回的=" + data);
//                return data;
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String data) {
//                        Log.d("66666", Thread.currentThread().getName());
//                        if (null == data) {
//                            showMsg("请求出错", "请检查URL", "URL无法获取charge");
//                            return;
//                        }
//                        Log.d("PingActivity", "onPostExecute方法data=" + data);
////            Pingpp.createPayment(ClientSDKActivity.this, data);
//                        //QQ钱包调起支付方式  “qwalletXXXXXXX”需与AndroidManifest.xml中的data值一致
//                        //建议填写规则:qwallet + APP_ID
//                        Pingpp.createPayment(PingActivity.this, data, "qwalletXXXXXXX");
//                    }
//                });
//    }
//
//    class PaymentTask extends AsyncTask<LekeChargeBean, Void, String> {
//
//        @Override
//        protected void onPreExecute() {
//            //按键点击之后的禁用，防止重复点击
////            wechatButton.setOnClickListener(null);
////            alipayButton.setOnClickListener(null);
////            upmpButton.setOnClickListener(null);
////            bfbButton.setOnClickListener(null);
////            qpayButton.setOnClickListener(null);
//        }
//
//        @Override
//        protected String doInBackground(LekeChargeBean... pr) {
//
//            LekeChargeBean paymentRequest = pr[0];
//            String data = null;
//            String json = new Gson().toJson(paymentRequest);
//            Log.d("PingActivity", "doInBackground方法json=" + json);
//
//            try {
//                //向Your Ping++ Server SDK请求数据
//
//                data = postJson(URL, json);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            Log.d("PingActivity", "doInBackground方法返回的=" + data);
//            return data;
//        }
//
//        /**
//         * 获得服务端的charge，调用ping++ sdk。
//         */
//        @Override
//        protected void onPostExecute(String data) {
//            if (null == data) {
//                showMsg("请求出错", "请检查URL", "URL无法获取charge");
//                return;
//            }
//            Log.d("PingActivity", "onPostExecute方法data=" + data);
//            Pingpp.createPayment(PingActivity.this, data);
//            //QQ钱包调起支付方式  “qwalletXXXXXXX”需与AndroidManifest.xml中的data值一致
//            //建议填写规则:qwallet + APP_ID
////            Pingpp.createPayment(PingActivity.this, data, "qwalletXXXXXXX");
//        }
//
//    }
//
//    /**
//     * onActivityResult 获得支付结果，如果支付成功，服务器会收到ping++ 服务器发送的异步通知。
//     * 最终支付成功根据异步通知为准
//     */
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//
//        //支付页面返回处理
//        if (requestCode == Pingpp.REQUEST_CODE_PAYMENT) {
//            if (resultCode == Activity.RESULT_OK) {
//                String result = data.getExtras().getString("pay_result");
//                /* 处理返回值
//                 * "success" - payment succeed
//                 * "fail"    - payment failed
//                 * "cancel"  - user canceld
//                 * "invalid" - payment plugin not installed
//                 */
//                String errorMsg = data.getExtras().getString("error_msg"); // 错误信息
//                String extraMsg = data.getExtras().getString("extra_msg"); // 错误信息
//                Log.d("PingActivity", "result=" + result);
//                Log.d("PingActivity", "errorMsg=" + errorMsg);
//                Log.d("PingActivity", "extraMsg=" + extraMsg);
//                showMsg(result, errorMsg, extraMsg);
//            }
//        }
//    }
//
//    public void showMsg(String title, String msg1, String msg2) {
//        String str = title;
//        if (null != msg1 && msg1.length() != 0) {
//            str += "\n" + msg1;
//        }
//        if (null != msg2 && msg2.length() != 0) {
//            str += "\n" + msg2;
//        }
//        AlertDialog.Builder builder = new AlertDialog.Builder(PingActivity.this);
//        builder.setMessage(str);
//        builder.setTitle("提示");
//        builder.setPositiveButton("OK", null);
//        builder.create().show();
//    }
//
//    private static String postJson(String url, String json) throws IOException {
//        MediaType type = MediaType.parse("application/json; charset=utf-8");
//        RequestBody body = RequestBody.create(type, json);
//        Request request = new Request.Builder().url(url).post(body).build();
//
//        OkHttpClient client = new OkHttpClient();
//        Response response = client.newCall(request).execute();
//
//        return response.body().string();
//    }
//
//    class PaymentRequest {
//        String channel;
//        int amount;
//
//        public PaymentRequest(String channel, int amount) {
//            this.channel = channel;
//            this.amount = amount;
//        }
//    }
//}
