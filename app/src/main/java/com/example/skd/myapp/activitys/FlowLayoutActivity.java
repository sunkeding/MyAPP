package com.example.skd.myapp.activitys;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;
import com.example.skd.myapp.views.flowlayout.FlowLayout;
import com.example.skd.myapp.views.flowlayout.TagAdapter;
import com.example.skd.myapp.views.flowlayout.TagFlowLayout;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by skd on 2017/6/6.
 */

public class FlowLayoutActivity extends BaseActivity {
    private String[] mVals = new String[]
            {"Hello", "Weclome Hi ", "Button", "TextView",
                    "Weclome", "Button ImageView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text"};

    private TagFlowLayout mFlowLayout;
    private TextView tv_sure;
    private TagFlowLayout mFlowLayout2;
    private TextView tv_sure2;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_flowlayout);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.id_flowlayout);
        mFlowLayout2 = (TagFlowLayout) findViewById(R.id.id_flowlayout2);
        tv_sure = (TextView) findViewById(R.id.tv_sure);
        tv_sure2 = (TextView) findViewById(R.id.tv_sure2);
        multype();
        singletype();


    }

    private void singletype() {
        TagAdapter<String> tagAdapter = new TagAdapter<String>(mVals) {

            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) View.inflate(FlowLayoutActivity.this,R.layout.tv,
                         null);
                tv.setText(s);

                return tv;
            }
        };
        mFlowLayout2.setAdapter(tagAdapter);
        tagAdapter.setSelectedList(1);//设置默认勾选状态
        mFlowLayout2.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {
//                Toast.makeText(mContext, mVals[position], Toast.LENGTH_SHORT).show();
                //view.setVisibility(View.GONE);
                return true;
            }
        });


        mFlowLayout2.setOnSelectListener(new TagFlowLayout.OnSelectListener()
        {
            @Override
            public void onSelected(Set<Integer> selectPosSet)
            {
                mContext.setTitle("choose:" + selectPosSet.toString());
            }
        });
    }

    private void multype() {
        TagAdapter<String> tagAdapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) View.inflate(FlowLayoutActivity.this, R.layout.tv,
                        null);
                tv.setText(s);
                return tv;
            }
        };
        mFlowLayout.setAdapter(tagAdapter);
//        tagAdapter.setSelectedList(1,2,3);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        tagAdapter.setSelectedList(set);//设置默认选择
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                Set<Integer> selectedList = mFlowLayout.getSelectedList();
                if (selectedList.size() == 3 && !selectedList.contains(position)) {
                    Toast.makeText(mContext, "您最多只可以选择3个哦", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Set<Integer> selectedList = mFlowLayout.getSelectedList();
                for (Integer integer : selectedList) {
                    Log.d("FlowLayoutActivity", "integer:" + integer);
                    Log.d("FlowLayoutActivity", "选择了：" + mVals[integer]);
                }
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
