package com.example.skd.myapp.activitys;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.skd.myapp.R;
import com.example.skd.myapp.uctoast.ListenClipboardService;
import com.example.skd.myapp.uctoast.Utils;

/**
 * Created by skd on 2018/2/2.
 */

public class UCToastActivity extends AppCompatActivity {
    private final static String KEY_CONTENT = "content";
    private TextView mTextView;

    public static void startForContent(Context context, String content) {
        Intent intent = new Intent(context, UCToastActivity.class);
        intent.putExtra(KEY_CONTENT, content);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uctoast);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTextView = (TextView) findViewById(R.id.text_view);

        Intent intent = getIntent();
        Utils.printIntent("MainActivity::onCreate()", intent);

        tryToShowContent(intent);
        ListenClipboardService.start(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Utils.printIntent("MainActivity::onNewIntent()", intent);

        tryToShowContent(intent);
    }

    private void tryToShowContent(Intent intent) {
        String content = intent.getStringExtra(KEY_CONTENT);
        if (!TextUtils.isEmpty(content)) {
            mTextView.setText(content);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            String url = "https://github.com/liaohuqiu/android-UCToast";
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
