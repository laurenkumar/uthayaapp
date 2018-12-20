package com.example.suthayakumar.testapputhaya.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

public class DataManager {

	@SuppressLint("StaticFieldLeak")
	static private Context context;


	static Context getContext() {
		if (context == null)
			throw  new ExceptionInInitializerError("DataManager has not been initialized!");

		return context;
	}

	public static void init(@NonNull Context context) {
		DataManager.context = context.getApplicationContext();
	}
}
