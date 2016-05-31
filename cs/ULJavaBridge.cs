/*
 * User: Canyon
 * Date: 2016/5/22
 * Time: 14:30
 * 
 * 本类配合 SDKPlugin 工作，提供给lua调用
 */
using UnityEngine;
using LuaInterface;
using System.Collections.Generic;

public class ULJavaBridge : MonoBehaviour {

	// java 类名
	public const string NAME_JAVA_BRIDGE_CLASS = "com.sdkplugin.bridge.U3DBridge";
	
	// GameObject对象名
	public const string NAME_Gobj = "JavaBridge";
	
	// 回调方法名
	public const string NAME_ON_RESULT_FUNC = "OnResult";
	
	// java设置方法名
	public const string NAME_JAVA_METHOD_INITALL = "initAll";

	public const string NAME_JAVA_METHOD_INITPARS = "initPars";
	
	// java消息接受方法
	public const string NAME_JAVA_METHOD_NOTIFY = "request";

	static public Dictionary<string,object> dicJo = new Dictionary<string, object>();
#if UNITY_ANDROID	
	// java连接对象
	static AndroidJavaClass jcBridge;
#endif

	// lua监听
	delegate void CallBack (string data);
	static CallBack callBack2Lua;

	public static void InitBridge(){
#if UNITY_ANDROID
		if( jcBridge != null ){
			return;
		}
		jcBridge = new AndroidJavaClass( NAME_JAVA_BRIDGE_CLASS );
		jcBridge.CallStatic(NAME_JAVA_METHOD_INITPARS,NAME_Gobj,NAME_ON_RESULT_FUNC);
#endif
	}

	public static void InitListener(string classListener){
		if(dicJo.ContainsKey(classListener)){
			return;
		}
#if UNITY_ANDROID
		AndroidJavaObject jo = new AndroidJavaObject(classListener);
		dicJo.Add(classListener,jo);
#endif
	}
	public static void Init( string classListener,LuaFunction onResult ) {
		callBack2Lua = data => onResult.Call(data);
#if UNITY_ANDROID

		InitBridge();
		InitListener(classListener);

		AndroidJavaObject joListener = (AndroidJavaObject)dicJo[classListener];

		if(joListener == null){
			Debug.LogError("joListener: java is null.");
		}

		jcBridge.CallStatic( NAME_JAVA_METHOD_INITALL, joListener, NAME_Gobj ,NAME_ON_RESULT_FUNC);
		Debug.Log("ULJavaBridge inited.");
#endif
	}
	
	
	public static void SendToJava( string param ){
#if UNITY_ANDROID
		if(jcBridge != null){
			jcBridge.CallStatic(NAME_JAVA_METHOD_NOTIFY, param);
		} else {
			Debug.LogWarning("SendToJava: jcBridge is null.");
		}
#endif
	}
	
	void Awake() {
		name = NAME_Gobj;
	}
	
	
	public void OnResult(string data){
		if(callBack2Lua != null){
			callBack2Lua(data);
		} else {
			Debug.LogWarning("OnResult: callBack2Lua is null");
		}
	}
	
}



