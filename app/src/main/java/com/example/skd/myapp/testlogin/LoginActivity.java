package com.example.skd.myapp.testlogin;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.skd.myapp.R;

public class LoginActivity extends Activity {
	private LoginCarrier invoker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:// 登录成功
				invoker = (LoginCarrier) getIntent().getParcelableExtra(LoginInterceptor.mINVOKER);
				invoker.invoke(LoginActivity.this);
				finish();
				break;

			default:
				break;
			}
		};
	};

	/*
	 * 点击登录，这个方法模拟登录成功直接发送消息
	 */
	public void login(View v) {
		LoginAndGotoTargetActivity.is_login = true;
		/**
		 * 
		 * do something to login
		 */
		handler.sendEmptyMessage(0);
	}
}
