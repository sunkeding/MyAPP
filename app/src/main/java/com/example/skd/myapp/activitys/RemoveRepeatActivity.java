package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: skd
 * @date 2018/3/31
 * @Desc RemoveRepeatActivity
 */

public class RemoveRepeatActivity extends Activity {
    List<Student> list = new ArrayList<>();
    List<Student> appendList = new ArrayList<>();
    List<Student> appendList2 = new ArrayList<>();
    int page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_removerepeat);
        for (int i = 0; i < 10; i++) {
            Student bean = new Student(String.valueOf(i), "name" + i);
            appendList.add(bean);
        }
        for (int i = 10; i < 20; i++) {
            Student bean = new Student(String.valueOf(i), "name" + i);
            appendList2.add(bean);
        }
    }

    public void addData(View view) {
        ArrayList<Student> tempList = new ArrayList<>();
        for (Student student : appendList) {
            if (!list.contains(student)) {
                tempList.add(student);
            }
        }
        list.addAll(tempList);
    }

    public void addData2(View view) {
        ArrayList<Student> tempList = new ArrayList<>();
        for (Student student : appendList2) {
            if (!list.contains(student)) {
                tempList.add(student);
            }
        }
        list.addAll(tempList);
    }

    public void showData(View view) {
        Log.d("RemoveRepeatActivity", "list.size():" + list.size());
    }

    public void judgeData(View view) {
        Student student = new Student("1", "name1");
        boolean contains = list.contains(student);
        Log.d("RemoveRepeatActivity", "contains:" + contains);
    }

    public void judgeData2(View view) {
        Student student = new Student("11", "name11");
        boolean contains = list.contains(student);
        Log.d("RemoveRepeatActivity", "contains:" + contains);
    }
}
