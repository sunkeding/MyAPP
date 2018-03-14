package com.example.skd.myapp.activitys;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.skd.myapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: skd
 * @date 2018/3/13
 * @Desc TimerActivity
 */

public class TimerActivity extends Activity {
    private long mlCount = 0;
    private long mlTimerUnit = 100;
    private TextView tvTime;
    private Button btnStartPause;
    private Button btnStop;
    private Timer timer = null;
    private TimerTask task = null;
    private Handler handler = null;
    private Message msg = null;
    private boolean bIsRunningFlg = false;
    private static final String MYTIMER_TAG = "MYTIMER_LOG";

    // menu item
    private static final int SETTING_TIMER_UNIT_ID = Menu.FIRST;
    private static final int ABOUT_ID = Menu.FIRST + 1;
    private static final int EXIT_ID = Menu.FIRST + 2;
    private static final int SETTING_SECOND_ID = Menu.FIRST + 101;
    private static final int SETTING_100MILLISECOND_ID = Menu.FIRST + 102;

    // Setting timer unit flag
    private int settingTimerUnitFlg = SETTING_100MILLISECOND_ID;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        tvTime = (TextView) findViewById(R.id.tvTime);
        btnStartPause = (Button) findViewById(R.id.btnStartPaunse);
        btnStop = (Button) findViewById(R.id.btnStop);

        SharedPreferences sharedPreferences = getSharedPreferences("mytimer_unit", Context.MODE_PRIVATE);
        //getString()第二个参数为缺省值，如果preference中不存在该key，将返回缺省值
        mlTimerUnit = sharedPreferences.getLong("time_unit", 100);
        Log.i(MYTIMER_TAG, "mlTimerUnit = " + mlTimerUnit);

        if (1000 == mlTimerUnit) {
            // second
            settingTimerUnitFlg = SETTING_SECOND_ID;
            tvTime.setText(R.string.init_time_second);
        } else if (100 == mlTimerUnit) {
            // 100 millisecond
            settingTimerUnitFlg = SETTING_100MILLISECOND_ID;
            tvTime.setText(R.string.init_time_100millisecond);
        }

        // Handle timer message
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                switch (msg.what) {
                    case 1:
                        mlCount++;
                        Log.d("TimerActivity", "mlCount:" + mlCount);
                        int totalSec =  (int) (mlCount / 10);
                        int yushu = (int) (mlCount % 10);

                        // Set time display
                        int min = (totalSec / 60);
                        int sec = (totalSec % 60);
                        tvTime.setText(String.format("%1$02d:%2$02d:%3$d", min, sec, yushu));

                        break;

                    default:
                        break;
                }

                super.handleMessage(msg);
            }

        };

        btnStartPause.setOnClickListener(startPauseListener);
        btnStop.setOnClickListener(stopListener);
    }

    // Start and pause
    View.OnClickListener startPauseListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Log.i(MYTIMER_TAG, "Start/Pause is clicked.");

            if (null == timer) {
                if (null == task) {
                    task = new TimerTask() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            if (null == msg) {
                                msg = new Message();
                            } else {
                                msg = Message.obtain();
                            }
                            msg.what = 1;
                            handler.sendMessage(msg);
                        }

                    };
                }

                timer = new Timer(true);
                timer.schedule(task, mlTimerUnit, mlTimerUnit); // set timer duration
            }

            // start
            if (!bIsRunningFlg) {
                bIsRunningFlg = true;
            } else { // pause
                try {
                    bIsRunningFlg = false;
                    task.cancel();
                    task = null;
                    timer.cancel(); // Cancel timer
                    timer.purge();
                    timer = null;
                    handler.removeMessages(msg.what);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    };

    // Stop
    View.OnClickListener stopListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            Log.i(MYTIMER_TAG, "Stop is clicked.");

            if (null != timer) {
                task.cancel();
                task = null;
                timer.cancel(); // Cancel timer
                timer.purge();
                timer = null;
                handler.removeMessages(msg.what);
            }

            mlCount = 0;
            bIsRunningFlg = false;

            if (SETTING_SECOND_ID == settingTimerUnitFlg) {
                // second
                tvTime.setText(R.string.init_time_second);
            } else if (SETTING_100MILLISECOND_ID == settingTimerUnitFlg) {
                // 100 millisecond
                tvTime.setText(R.string.init_time_100millisecond);
            }
        }

    };


    // Menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);

        Log.i(MYTIMER_TAG, "Menu is created.");

        // Stop timer
        if (null != task) {
            task.cancel();
            task = null;
        }
        if (null != timer) {
            timer.cancel(); // Cancel timer
            timer.purge();
            timer = null;
            handler.removeMessages(msg.what);
        }

        bIsRunningFlg = false;
        mlCount = 0;


        return true;
    }

    // Menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        Log.i(MYTIMER_TAG, "Menu item is selected.");

        switch (item.getItemId()) {
            case SETTING_TIMER_UNIT_ID:
                break;

            case ABOUT_ID:
                // Display about dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.app_name)
                        .setMessage("本程序由雨梦开发/n联系作者:minyugong@163.com")
                        .setCancelable(true)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                break;

            case EXIT_ID:
                finish(); // Exit application
                break;

            case SETTING_SECOND_ID: // 秒(1000ms)
                if (SETTING_SECOND_ID != settingTimerUnitFlg) {
                    mlTimerUnit = 1000;
                    settingTimerUnitFlg = SETTING_SECOND_ID;
                }
                tvTime.setText(R.string.init_time_second);
                break;

            case SETTING_100MILLISECOND_ID: // 100毫秒
                if (SETTING_100MILLISECOND_ID != settingTimerUnitFlg) {
                    mlTimerUnit = 100;
                    settingTimerUnitFlg = SETTING_100MILLISECOND_ID;
                }
                tvTime.setText(R.string.init_time_100millisecond);
                break;

            default:
                Log.i(MYTIMER_TAG, "Other menu item...");
                break;
        }

        // Save timer unit
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("mytimer_unit", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
            editor.putLong("time_unit", mlTimerUnit);
            editor.commit();//提交修改
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(MYTIMER_TAG, "save timer unit error.");
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (KeyEvent.KEYCODE_MENU == keyCode) {
            super.openOptionsMenu();  // 调用这个，就可以弹出菜单

            Log.i(MYTIMER_TAG, "Menu key is clicked.");

            // Stop timer
            if (null != task) {
                task.cancel();
                task = null;
            }
            if (null != timer) {
                timer.cancel(); // Cancel timer
                timer.purge();
                timer = null;
                handler.removeMessages(msg.what);
            }

            bIsRunningFlg = false;
            mlCount = 0;

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
