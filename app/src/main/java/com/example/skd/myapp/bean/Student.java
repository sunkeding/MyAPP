package com.example.skd.myapp.bean;

import android.util.Log;

import java.io.Serializable;

/**
 * @author: skd
 * @date 2018/3/31
 * @Desc Student
 */

public class Student implements Serializable {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof Student) {
            Student student = (Student) o;
            if (student.getId().equals(this.getId())) {
                Log.d("Student", "equals:true");
                return true;
            }
        }
        Log.d("Student", "equals:false");
        return false;
    }


    String name;
}
