package com.sdkplugin.bridge;

public interface IU3DListener {
	public void init(String ugojName, String ugobjMethod);

	public void receiveFromUnity(String json) throws Exception;

	public void response2Unity(String json) throws Exception;
}
