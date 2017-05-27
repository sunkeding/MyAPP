package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.CommonAdapter;
import com.example.skd.myapp.adapter.ViewHolder;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.utils.MyCallBack;
import com.example.skd.myapp.views.DropView;
import com.example.skd.myapp.views.FilterView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/3/23.
 */
public class FilterViewActivity extends BaseActivity {


    @Bind(R.id.view_shade)
    View viewShade;
    @Bind(R.id.ll_pop1)
    LinearLayout llPop1;
    @Bind(R.id.ll_pop2)
    LinearLayout llPop2;
    @Bind(R.id.ll_pop3)
    LinearLayout llPop3;
    @Bind(R.id.ll_pop4)
    LinearLayout llPop4;
    @Bind(R.id.dropview)
    DropView dropview;
    FilterView filterview1, filterview2, filterview3,filterview4;
    Animation animationIn;
    String title1 = "控件1";
    String title2 = "控件2";
    String title3 = "控件3";
    String title4 = "测试";
    @Bind(R.id.lv1)
    ListView lv1;
    @Bind(R.id.lv2)
    ListView lv2;
    @Bind(R.id.lv3)
    ListView lv3;
    @Bind(R.id.lv4)
    ListView lv4;
    ArrayList<String> strlist = new ArrayList<>();
    ArrayList<String> strlist2 = new ArrayList<>();
    ArrayList<String> strlist3 = new ArrayList<>();
    ArrayList<String> strlist4 = new ArrayList<>();
    private List<View> viewsList = new ArrayList<>();

    @Override
    protected void initListener() {
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title1 = strlist.get(position);
//                setThreeFilterViewState(title1,title2,title3);
//                update(title1,title2,title3);
                dropview.updateDropView(title1, title2, title3,title4);
                hindPop();
            }
        });
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title2 = strlist2.get(position);
//                setThreeFilterViewState(title1,title2,title3);
//                update(title1,title2,title3);
                dropview.updateDropView(title1, title2, title3,title4);

                hindPop();
            }
        });
        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title3 = strlist3.get(position);
//                setThreeFilterViewState(title1,title2,title3);
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                hindPop();
            }
        });
        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title4 = strlist4.get(position);
//                setThreeFilterViewState(title1,title2,title3);
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                hindPop();
            }
        });
        filterview1.setMyCallBackListener(new MyCallBack() {
            @Override
            public void callback() {

//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                method(llPop1, filterview1,title1);

            }
        });
        filterview2.setMyCallBackListener(new MyCallBack() {
            @Override
            public void callback() {
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                method(llPop2, filterview2,title2);
            }
        });
        filterview3.setMyCallBackListener(new MyCallBack() {
            @Override
            public void callback() {
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                method(llPop3, filterview3,title3);
            }
        });
        filterview4.setMyCallBackListener(new MyCallBack() {
            @Override
            public void callback() {
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                method(llPop4, filterview4,title4);
            }
        });
        viewShade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setThreeFilterViewState(title1, title2, title3);
//                update(title1,title2,title3);
//                dropview.updateDropView(title1, title2, title3);
                dropview.updateDropView(title1, title2, title3,title4);

                hindPop();
            }
        });
    }

    private void method(View view, FilterView filterView,String title) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
            viewShade.setVisibility(View.GONE);
        } else {

            for (View view1 : viewsList) {
                if (view1 == view) {

                    view1.setVisibility(View.VISIBLE);
                    view1.startAnimation(animationIn);
                } else {
                    view1.setVisibility(View.GONE);
                }
            }
            viewShade.setVisibility(View.VISIBLE);
            filterView.setSelectedState(FilterView.UP, title);

        }
    }


    private void hindPop() {
        llPop1.setVisibility(View.GONE);
        llPop2.setVisibility(View.GONE);
        llPop3.setVisibility(View.GONE);
        llPop4.setVisibility(View.GONE);
        viewShade.setVisibility(View.GONE);
    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_filter);
        ButterKnife.bind(this);

    }

    @Override
    public void initView() {
        filterview1 = (FilterView) dropview.findViewById(R.id.filterview1);
        filterview2 = (FilterView) dropview.findViewById(R.id.filterview2);
        filterview3 = (FilterView) dropview.findViewById(R.id.filterview3);
        filterview4 = (FilterView) dropview.findViewById(R.id.filterview4);
        animationIn = AnimationUtils.loadAnimation(this, R.anim.push_top_in);
        viewsList.add(llPop1);
        viewsList.add(llPop2);
        viewsList.add(llPop3);
        viewsList.add(llPop4);
        dropview.setDefaultTitles("控件1", "控件2", "控件3","测试");
        strlist.add("控件1");
        for (int i = 0; i < 5; i++) {
            strlist.add("item" + i);
        }
        strlist2.add("控件2");
        for (int i = 0; i < 5; i++) {
            strlist2.add("测试" + i);
        }
        strlist3.add("控件3");
        for (int i = 0; i < 5; i++) {
            strlist3.add("条件" + i);
        }
        strlist4.add("测试");
        for (int i = 0; i < 5; i++) {
            strlist4.add("测试" + i);
        }
        lv1.setAdapter(new CommonAdapter<String>(this, strlist, R.layout.item_simpletext) {

            @Override
            public void convert(ViewHolder helper, String item) {
                TextView view = (TextView) helper.getView(R.id.tv);
                view.setText(item + "");
            }
        });
        lv2.setAdapter(new CommonAdapter<String>(this, strlist2, R.layout.item_simpletext) {

            @Override
            public void convert(ViewHolder helper, String item) {
                TextView view = (TextView) helper.getView(R.id.tv);
                view.setText(item + "");
            }
        });
        lv3.setAdapter(new CommonAdapter<String>(this, strlist3, R.layout.item_simpletext) {

            @Override
            public void convert(ViewHolder helper, String item) {
                TextView view = (TextView) helper.getView(R.id.tv);
                view.setText(item + "");
            }
        });
        lv4.setAdapter(new CommonAdapter<String>(this, strlist4, R.layout.item_simpletext) {

            @Override
            public void convert(ViewHolder helper, String item) {
                TextView view = (TextView) helper.getView(R.id.tv);
                view.setText(item + "");
            }
        });
    }

    @Override
    public void initData() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
