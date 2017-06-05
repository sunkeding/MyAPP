package com.example.skd.myapp.utils.recycleviewutil;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecycleUtils {

    /**
     * 初始化水平的Recycle
     * @param recyclerView
     */
    public static void initHorizontalRecyle(RecyclerView recyclerView, Context context){

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
    }


    /**
     * 初始化水平的Recycle
     * @param recyclerView
     */
    public static void initVerticalRecyle(RecyclerView recyclerView, Context context){

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }
    /**
     * 初始化GridView形式的的Recycle
     * @param recyclerView
     */
    public static void initGridViewRecyle(RecyclerView recyclerView, Context context, int num){

        GridLayoutManager layoutManager = new GridLayoutManager(context,num);
        recyclerView.setLayoutManager(layoutManager);
    }
}
