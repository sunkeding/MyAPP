package com.example.skd.myapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.ResultReceiver;
import android.util.Log;

/**
 * Created by skd on 2018/1/28.
 */

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("default");
    }
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Sam", "handleIntent");
        ResultReceiver receiver = (ResultReceiver) intent.getExtras().get("result_receiver");
        if (receiver != null){
            receiver.send(19, null);
        }
    }

}
