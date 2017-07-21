package com.example.skd.myapp.fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.skd.myapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by skd on 2017/7/17.
 */

public class SimpleDialogFragment extends DialogFragment {
    View rootView;
    @Bind(R.id.bt1)
    Button bt1;
    @Bind(R.id.bt2)
    Button bt2;
    @Bind(R.id.bt3)
    Button bt3;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag_simple, null);
        ButterKnife.bind(this, rootView);

        // 设置宽度为屏宽、靠近屏幕底部。
        final Window window = getDialog().getWindow();

        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams wl = window.getAttributes();

        wl.gravity = Gravity.BOTTOM;

        wl.x = 0;
        wl.y = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        // 以下这两句是为了保证按钮可以水平满屏
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        window.setAttributes(wl);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.ActionSheetDialogStyle);
        setCancelable(false);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
