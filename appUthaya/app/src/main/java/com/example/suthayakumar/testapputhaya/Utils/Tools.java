package com.example.suthayakumar.testapputhaya.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class Tools {

	public static String getVersionName(Context context) {
		String version;
		try {
			PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			version = packageInfo.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		Log.d(Tools.class.getName(), "version : " + version);
		return version;
	}
}
