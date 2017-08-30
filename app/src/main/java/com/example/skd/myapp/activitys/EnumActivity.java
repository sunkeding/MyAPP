package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.skd.myapp.Interface.DialogConfig;
import com.example.skd.myapp.R;
import com.example.skd.myapp.enums.DialogShowEnum;
import com.example.skd.myapp.enums.OrderStatusEnum;

/**
 * Created by skd on 2017/8/30.
 */

public class EnumActivity extends Activity {
    OrderStatusEnum testEnum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum);
        testEnum1();
        testEnum2(1);
        testEnum2(0);
        testInterfaceConfig(1);


    }

    private void testInterfaceConfig(int i) {
        if (i== DialogConfig.SHOWDIALOG){
            Toast.makeText(this, "show", Toast.LENGTH_SHORT).show();
        }else if (i==DialogConfig.NODIALOG){
            Toast.makeText(this, "noshow", Toast.LENGTH_SHORT).show();
        }
    }

    private void testEnum2(int i) {
        if (i == DialogShowEnum.NEEDSHOW.getNeed()) {
            String msg = DialogShowEnum.NEEDSHOW.getMsg();
            Log.d("EnumActivity", msg);
        } else if (i == DialogShowEnum.NOSHOW.getNeed()) {
            String msg = DialogShowEnum.NOSHOW.getMsg();
            Log.d("EnumActivity", msg);
        }
    }

    private void testEnum1() {
        testEnum = OrderStatusEnum.createWithCode(1);
        switch (testEnum) {
            case STATUS_YES:
                Log.d("EnumActivity", "YES");
                break;
            case STATUS_NO:
                Log.d("EnumActivity", "NO");
                break;
        }
    }
}
