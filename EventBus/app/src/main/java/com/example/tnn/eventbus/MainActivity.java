package com.example.tnn.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ypy.eventbus.EventBus;

public class MainActivity extends Activity {
	//测试一下能否提交到服务器
	Button btn;
	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		EventBus.getDefault().register(this);

		btn = (Button) findViewById(R.id.btn_try);
		tv = (TextView)findViewById(R.id.tv);

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
//				startActivity(intent);

				Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
				startActivityForResult(intent, 101);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 101 && resultCode == 102){
			String str = data.getStringExtra("result");
			tv.setText(str);
		}
	}

	public void onEventMainThread(FirstEvent event) {
		String msg = "监听Second页的回传值   " + event.getMsg();
		tv.setText(msg);
	}

	@Override
	protected void onDestroy(){
		super.onDestroy();
		EventBus.getDefault().unregister(this);
	}
}
