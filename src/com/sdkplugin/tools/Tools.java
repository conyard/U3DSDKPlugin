package com.sdkplugin.tools;

import java.util.HashMap;
import java.util.Map;

import com.bowlong.reflect.JsonHelper;
import com.sdkplugin.bridge.U3DBridge;

@SuppressWarnings("rawtypes")
public class Tools {
	static public final boolean isEmptyTrim(String v) {
		if (null == v || v.length() <= 0)
			return true;
		return v.trim().length() <= 0;
	}

	/*** GET参数转换为map对象 */
	static public final Map<String, String> buildMapByQuery(String query) {
		Map<String, String> ret = new HashMap<String, String>();
		if (!isEmptyTrim(query)) {
			boolean isFirst = query.indexOf("?") == 0;
			if (isFirst)
				query = query.substring(1);
			String[] params = query.split("&");
			for (String item : params) {
				if (isEmptyTrim(item))
					continue;
				int index = item.indexOf("=");
				if (index < 0)
					continue;
				String k = item.substring(0, index);
				String v = item.substring(index + 1);
				if (ret.containsKey(k)) {
					v = ret.get(k) + "," + v;
				}
				ret.put(k, v);
			}
		}
		return ret;
	}

	static public void response2U3D(Map mapJson) {
		try {
			U3DBridge.response(JsonHelper.toJSON(mapJson).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void msg2U3D(String code, String msg, String data) {
		Map<String, String> mapJson = new HashMap<String, String>();
		mapJson.put("code", code);
		mapJson.put("msg", isEmptyTrim(msg) ? "" : msg);
		mapJson.put("data", isEmptyTrim(data) ? "" : data);
		response2U3D(mapJson);
	}
}
