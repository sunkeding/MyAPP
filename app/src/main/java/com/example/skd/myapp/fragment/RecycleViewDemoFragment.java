package com.example.skd.myapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skd.myapp.R;
import com.example.skd.myapp.adapter.RecycleViewFrgDemoAdpater;

import java.util.ArrayList;

/**
 * Created by skd on 2018/1/8.
 */

public class RecycleViewDemoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frg_recycledemo,container,false);
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rv);
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("item"+i);
        }
        RecycleViewFrgDemoAdpater adpater=new RecycleViewFrgDemoAdpater(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adpater);
        adpater.notifyDataSetChanged();
        return view;
    }
}
