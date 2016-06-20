package com.example.tnn.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
	private Button btn_FirstEvent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		btn_FirstEvent = (Button) findViewById(R.id.btn_first_event);

		btn_FirstEvent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				EventBus.getDefault().post(new FirstEvent("haha"));

				Intent intent = new Intent();
				intent.putExtra("result", "haha");
				setResult(102, intent);
				//finish();
			}
		});
	}

}
