package com.sdkplugin.extend;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.bowlong.reflect.JsonHelper;
import com.sdkplugin.bridge.AbsU3DListener;
import com.sdkplugin.bridge.U3DBridge;

public class PluginDemo extends AbsU3DListener {
	
	static private PluginDemo _instance;
	
	static public PluginDemo getInstance(){
		if(null == _instance){
			_instance = new PluginDemo();
		}
		return _instance;
	}
	
	public void say(){
		System.out.println("== test say==");
	}
	
	@Override
	public void receiveFromUnity(String json) throws Exception {
		JSONObject obj = JsonHelper.toJSON(json);
		System.out.println(obj.getString("key"));
		Map<String, String> ret = new HashMap<String, String>();
		ret.put("code", "success");
		ret.put("val", "这是一个demo");
		U3DBridge.response(JsonHelper.toJSON(ret).toString());
	}
}
