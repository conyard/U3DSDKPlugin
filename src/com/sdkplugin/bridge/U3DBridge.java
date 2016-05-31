package com.sdkplugin.bridge;

public class U3DBridge {

	private static IU3DListener uListener;
	private static String ugobjName = "";
	private static String ugobjMethod = "";

	static public void setListener(IU3DListener listener) {
		uListener = listener;
	}

	static public void setListenerPars() {
		uListener.init(ugobjName, ugobjMethod);
	}

	static public void initPars(String nmGobj, String method) {
		ugobjName = nmGobj;
		ugobjMethod = method;
	}

	static public void initListenerPars(String nmGobj, String method) {
		initPars(nmGobj, method);
		setListenerPars();
	}
	
	static public void initAll(IU3DListener listener, String ugojName,
			String ugobjMethod) {
		setListener(listener);
		initListenerPars(ugojName, ugobjMethod);
	}

	static public void request(String json) {
		try {
			uListener.receiveFromUnity(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void response(String json) {
		try {
			uListener.response2Unity(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
