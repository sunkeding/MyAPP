package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.CommonAdapter;
import com.example.skd.myapp.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skd on 2017/7/10.
 */

public class ListActivity extends Activity {
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView listView = (ListView) findViewById(R.id.list);
        for (int i = 0; i < 50; i++) {
            list.add("item" + i);
        }
        listView.setAdapter(new CommonAdapter<String>(this, list, R.layout.item_simpletext) {
            @Override
            public void convert(ViewHolder helper, String item) {
                TextView view = (TextView) helper.getView(R.id.tv);
                view.setText(item);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    Log.d("ListActivity", "SCROLL_STATE_IDLE");
                } else if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    Log.d("ListActivity", "SCROLL_STATE_TOUCH_SCROLL");

                } else if ((scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING)) {
                    Log.d("ListActivity", "SCROLL_STATE_FLING");
                }
            }


            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d("ListActivity", "onScroll");
            }
        });
    }
}
