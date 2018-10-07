package com.suxiaomei.admin.util.wx;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * 公众号token获取工具
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月20日 下午5:31:31
 */
public class WeixinUtil {
	public static String ROOT = "https://api.weixin.qq.com/cgi-bin";
	public static String getToken(String appid,String appSecret){
		String tokenUrl = ROOT+"/token?grant_type=client_credential&appid="+appid+"&secret="+appSecret;
		return WeixinHttpUtil.doGet(tokenUrl);
	}
	
	public static String getErCode(String token,String str){
		String erCodeUrl = ROOT+"/qrcode/create?access_token="+token;
		Map<String,Object> map = new HashMap<>();
		map.put("action_name", "QR_LIMIT_STR_SCENE");
		Map<String,Object> scene_str = new HashMap<>();
		scene_str.put("scene_str", str);
		Map<String,Object> scene = new HashMap<>();
		scene.put("scene", scene_str);
		map.put("action_info", scene);
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
		String resultStr = WeixinHttpUtil.doPost(erCodeUrl, json.toString());
		System.out.println(resultStr);
		JSONObject result = JSONObject.fromObject(resultStr);
		if(result.containsKey("ticket")){
			return result.getString("ticket");
		}
		return null;
	}
	
//	public static void main(String[] args) {
////		String token = "8_n8bTTgnDRmKGc8M7D-jBJA_gfP2HbXE6coudDp-Cw0h6TqlKG4bcRFeoHTSSmoONKIjSkVRADJ-XkyIkm2vHpULrD56Lk949UWsX--RQSnh0Z1Pi9ZPxaJ4c7mFxObNqH4sLEIAS5lzOlSPEVEIgAHAGPT";
////		System.out.println(getToken("wx14dc2d81ac19a2e4","70cfbbcbbcb539bb7a6e542a4dc878bf"));
//		String str = "40_20_1";
////		{"action_name":"QR_LIMIT_STR_SCENE","action_info":{"scene_str":"1_2"}}
////		{"action_name":"QR_LIMIT_STR_SCENE","action_info": {"scene": {"scene_str": "test"}}}
////		String token = getToken("wx6fff97e64016621d","28ad4d0ea2c4ebffead0ea65a31bd078");
////		System.out.println(token);
//		String token = "8_G3sRhfzKL6o2DFU--zQ_CoB1FPdaM_qAth3W9CduNgh1hPLwOs4CJFqpI1lqApsSPKh-RtuA9eNrpEcv-6Gbp0K_l8WmezIDwjbqfNvDVGyZGFufkmM5fHBH7u4rtAMBlz-K_bGHrED1CZb5OKAeAJAZVL";
//		System.out.println(getErCode(token,str));
//	}
}

