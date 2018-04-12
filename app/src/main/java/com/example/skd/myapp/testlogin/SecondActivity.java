package com.example.skd.myapp.testlogin;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.skd.myapp.R;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_secondnew);
		// 接收从首页传递过来的消息
		Bundle b = getIntent().getExtras();
		Toast.makeText(this, b.getString("Type"), Toast.LENGTH_SHORT).show();
	}

	/**
	 * 模拟退出登录
	 * 
	 * @param v
	 */
	public void exitSign(View v) {
		LoginAndGotoTargetActivity.is_login = false;
		finish();
	}
}
