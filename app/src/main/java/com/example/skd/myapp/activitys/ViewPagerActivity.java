package com.example.skd.myapp.activitys;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/5/17.
 */

public class ViewPagerActivity extends BaseActivity {
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    List<View> viewList = new ArrayList<>();
    @Bind(R.id.ll)
    LinearLayout ll;

    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_viewpager);
        ButterKnife.bind(this);
        for (int i = 0; i < 3; i++) {
            View view = View.inflate(this, R.layout.item_viewpager, null);
            Button btn = (Button) view.findViewById(R.id.btn);
            btn.setText("position" + i);
            viewList.add(view);
        }

        viewpager.setAdapter(new MyAdapter(viewList));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("ViewPagerActivity", "position:" + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        ll.removeAllViews();
        for (int i = 0; i < 3; i++) {
            ImageView checkimg = new ImageView(this);
            if (i == 0) {
                checkimg.setImageResource(R.drawable.selected_icon);
            } else {
                checkimg.setImageResource(R.drawable.unselected_icon);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            ll.addView(checkimg, layoutParams);
        }
    }

    @Override
    public void initView() {

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

    class MyAdapter extends PagerAdapter {
        public MyAdapter(List<View> mLists) {
            this.mLists = mLists;
        }

        private List<View> mLists;

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mLists.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager) container).removeView(mLists.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager) container).addView(mLists.get(position));
            return mLists.get(position);
        }
    }

}
