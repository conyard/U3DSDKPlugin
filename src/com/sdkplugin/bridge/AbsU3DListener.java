package com.sdkplugin.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.unity3d.player.UnityPlayer;

public abstract class AbsU3DListener implements IU3DListener {
	
	protected String ugobjName = "";
	protected String ugobjMethod = "";

	public Activity getCurActivity() {
		return UnityPlayer.currentActivity;
	}

	public Context getCurContext() {
		return UnityPlayer.currentActivity;
	}
	
	public Intent getCurIntent() {
		return UnityPlayer.currentActivity.getIntent();
	}

	@Override
	public void init(String ugojName, String ugobjMethod){
		this.ugobjName = ugojName;
		this.ugobjMethod = ugobjMethod;
	}

	@Override
	public void response2Unity(String json) throws Exception {
		UnityPlayer.UnitySendMessage(this.ugobjName, this.ugobjMethod, json);
	}

}
