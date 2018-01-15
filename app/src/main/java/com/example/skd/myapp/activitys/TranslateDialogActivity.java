package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by skd on 2018/1/14.
 */

public class TranslateDialogActivity extends Activity {
    ;
    private AlertDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
//                alertDialog.setTitle("主页的弹窗");
//                alertDialog.show();
//                alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                    @Override
//                    public void onCancel(DialogInterface dialog) {
//                        Toast.makeText(TranslateDialogActivity.this, "关闭对话框", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                });
//            }
//        },500);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        if (dialog != null && dialog.isShowing()) {
//            dialog.dismiss();
//        }
    }
}
