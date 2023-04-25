package com.tools;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class AndroidTools {
	static private DisplayMetrics getRealDisplayMetrics() {
		try {
			Class<?> classtype = Class.forName("com.unity3d.player.UnityPlayer");
			if (classtype != null) {
				Activity curActivity = (Activity) classtype.getDeclaredField("currentActivity").get(classtype);
				WindowManager manager = curActivity.getWindowManager();
				DisplayMetrics outMetrics = new DisplayMetrics();
				manager.getDefaultDisplay().getRealMetrics(outMetrics);
				return outMetrics;
			}
		} catch (Exception e) {
		}

		return null;
	}

	static public String getScreenWidthAndHeightStr(int type) {
		int screenW = 0;
		int screenH = 0;
		DisplayMetrics outMetrics = getRealDisplayMetrics();
		if (outMetrics != null) {
			screenW = outMetrics.widthPixels;
			screenH = outMetrics.heightPixels;
		}
		switch (type) {
		case 1:
			return String.format("%d,%d", screenW, screenH);
		case 2:
			return String.format("%d@%d", screenW, screenH);
		default:
			return String.format("{\"width\":%d,\"height\":%d}", screenW, screenH);
		}
	}

	static public String getScreenWidthAndHeightJson() {
		return getScreenWidthAndHeightStr(0);
	}
	
	static public String getScreenWidthAndHeightSplit() {
		return getScreenWidthAndHeightStr(1);
	}

	static public String getScreenWidthAndHeightAt() {
		return getScreenWidthAndHeightStr(2);
	}

	public static void main(String[] args) {
		int screenW = 0;
		int screenH = 0;
		String val = String.format("{\"width\":%d,\"height\":%d}", screenW, screenH);
		System.out.println(val);
	}
}
