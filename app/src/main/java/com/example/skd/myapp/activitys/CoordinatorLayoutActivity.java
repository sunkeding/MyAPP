package com.example.skd.myapp.activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.skd.myapp.R;
import com.example.skd.myapp.fragment.RecycleViewDemoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skd on 2018/1/8.
 */

public class CoordinatorLayoutActivity extends AppCompatActivity {
    private List<Fragment> mFragments;
    private String[] mTabTitles = {"消息", "好友", "动态"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorlayout);
        initFragment();

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp_main);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_main);

        // 初始化Adapter
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), this);
        // 设置adapter将ViewPager和Fragment关联起来
        viewPager.setAdapter(adapter);
        // 将TabLayout和ViewPager关联，达到TabLayout和Viewpager、Fragment联动的效果
        tabLayout.setupWithViewPager(viewPager);

    }
    /**
     * 初始化Fragment
     */
    private void initFragment() {
        RecycleViewDemoFragment msgFragment = new RecycleViewDemoFragment();
        RecycleViewDemoFragment friendFragment = new RecycleViewDemoFragment();
        RecycleViewDemoFragment foundFragment = new RecycleViewDemoFragment();
        // 将三个fragment放入List里面管理，方便使用
        mFragments = new ArrayList<>();
        mFragments.add(msgFragment);
        mFragments.add(friendFragment);
        mFragments.add(foundFragment);
    }


    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        private Context context;

        public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            // 获取指定位置的Fragment对象
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            // ViewPager管理页面的数量
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // 设置indicator的标题（TabLayout中tab的标题）
            return mTabTitles[position];
        }
    }
}
