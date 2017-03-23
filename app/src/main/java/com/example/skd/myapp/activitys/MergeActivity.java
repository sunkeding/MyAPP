package com.example.skd.myapp.activitys;

import com.example.skd.myapp.R;
import com.example.skd.myapp.base.BaseActivity;

/**
 * Created by skd on 2017/3/23.
 */
public class MergeActivity extends BaseActivity {
    @Override
    protected void initListener() {

    }

    @Override
    public void setMyContentView() {
        setContentView(R.layout.activity_merge);//http://blog.sina.com.cn/s/blog_62f987620100sf13.html
//        merge标签基本是用来取代framelayout的
        //todo 所有的Activity视图的根节点都是frameLayout
// 1.<merge />只可以作为xml layout的根节点。

//2.当需要扩充的xml layout本身是由merge作为根节点的话，需要将被导入的xml layout置于 viewGroup中，同时需要设置attachToRoot为True。
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }
}
