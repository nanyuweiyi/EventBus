package com.example.tnn.eventbus;

public class FirstEvent {

	private String mMsg;
	public FirstEvent(String msg) {
		mMsg = msg;
	}
	public String getMsg(){
		return mMsg;
	}
}
