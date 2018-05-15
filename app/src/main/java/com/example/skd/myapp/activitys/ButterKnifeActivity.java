package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.skd.myapp.R;




/**
 * @author: skd
 * @date 2018/4/16
 * @Desc ButterKnifeActivity
 */

public class ButterKnifeActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.list_view);

    }
}
