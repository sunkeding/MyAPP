package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.skd.myapp.R;
import com.example.skd.myapp.fragment.SimpleDialogFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/7/17.
 */

public class DialogFragActivity extends Activity {
    @Bind(R.id.bt1)
    AppCompatButton bt1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogfrag);
        ButterKnife.bind(this);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDialogFragment dialogFragment = new SimpleDialogFragment();
                dialogFragment.show(getFragmentManager(), "");
            }
        });
    }
}

