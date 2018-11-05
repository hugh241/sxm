package com.suxiaomei.admin.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 背调返回JSON解析工具类
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
 * 2018年7月27日 下午2:33:59
 */
public class EmployeeBackgroundCheckJsonUtil {
//	public static void main(String[] args) {
//		String json = "{\"code\":200,\"data\":{\"reportId\":\"201808240014711200\",\"reportDetail\":{\"01\":[{\"queryCost\":2.0,\"itemId\":\"1170315165001801003\",\"itemName\":\"身份验证\",\"itemData\":[{\"itemPropLabel\":\"校验结果\",\"itemPropName\":\"checkResult\",\"itemPropValue\":\"校验通过\",\"set\":false}],\"itemCode\":\"001\",\"cateName\":\"校验类\",\"cateCode\":\"01\",\"isSuccess\":true},{\"queryCost\":5.0,\"itemId\":\"1170421135602914001\",\"itemName\":\"真人照片验证\",\"itemData\":[{\"itemPropLabel\":\"身份证照片\",\"itemPropName\":\"certPictures\",\"itemPropValue\":\"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\",\"set\":false},{\"itemPropLabel\":\"校验结果\",\"itemPropName\":\"checkResult\",\"itemPropValue\":\"校验通过\",\"set\":false}],\"itemCode\":\"007\",\"cateName\":\"校验类\",\"cateCode\":\"01\",\"isSuccess\":true}],\"02\":[{\"queryCost\":5.0,\"itemId\":\"1170330211338038028\",\"itemName\":\"户籍信息验证\",\"itemData\":[{\"itemPropLabel\":\"身份证号\",\"itemPropName\":\"idNo\",\"itemPropValue\":\"513902199102138875\",\"set\":false},{\"itemPropLabel\":\"性别\",\"itemPropName\":\"gender\",\"itemPropValue\":\"男\",\"set\":false},{\"itemPropLabel\":\"出生日期\",\"itemPropName\":\"birthday\",\"itemPropValue\":\"1991-02-13\",\"set\":false},{\"itemPropLabel\":\"籍贯\",\"itemPropName\":\"nativePlace\",\"itemPropValue\":\"四川省资阳简阳市\",\"set\":false},{\"itemPropLabel\":\"姓名\",\"itemPropName\":\"name\",\"itemPropValue\":\"胡波\",\"set\":false}],\"itemCode\":\"102\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true},{\"queryCost\":10.0,\"itemId\":\"1170502110900736000\",\"itemName\":\"职业资格\",\"itemData\":[{\"itemPropLabel\":\"证书列表\",\"itemPropName\":\"certificateList\",\"itemPropValue\":[[{\"itemPropLabel\":\"证书编号\",\"itemPropName\":\"certificateId\",\"itemPropValue\":\"1322090000405291\",\"set\":false},{\"itemPropLabel\":\"职业名称\",\"itemPropName\":\"occupation\",\"itemPropValue\":\"化学检验工\",\"set\":false}]],\"set\":true}],\"itemCode\":\"119\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true},{\"queryCost\":15.0,\"itemId\":\"1709011710017921008\",\"itemName\":\"个人涉诉记录\",\"itemData\":[{\"itemPropLabel\":\"失信公告摘要\",\"itemPropName\":\"sxggList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"裁判文书摘要\",\"itemPropName\":\"cpwsList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"执行公告摘要\",\"itemPropName\":\"zxggList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"网贷黑名单摘要\",\"itemPropName\":\"wdhmdList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"曝光台\",\"itemPropName\":\"bgtList\",\"itemPropValue\":[],\"set\":true}],\"itemCode\":\"135\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true}],\"03\":[{\"queryCost\":10.0,\"itemId\":\"1170417191610363057\",\"itemName\":\"不良信息验证\",\"itemData\":[],\"itemCode\":\"205\",\"cateName\":\"黑名单类\",\"cateCode\":\"03\",\"isSuccess\":false}]}}}";
////		String json = "{\"code\":200,\"data\":{\"reportId\":\"201808230014690213\",\"reportDetail\":{\"01\":[{\"queryCost\":0.0,\"itemId\":\"1170315165001801003\",\"itemName\":\"身份验证\",\"itemCode\":\"001\",\"cateName\":\"校验类\",\"cateCode\":\"01\",\"isSuccess\":false},{\"queryCost\":5.0,\"itemId\":\"1170421135602914001\",\"itemName\":\"真人照片验证\",\"itemData\":[{\"itemPropLabel\":\"校验结果\",\"itemPropName\":\"checkResult\",\"itemPropValue\":\"校验不通过\",\"set\":false},{\"itemPropLabel\":\"身份证照片\",\"itemPropName\":\"certPictures\",\"itemPropValue\":\"\",\"set\":false}],\"itemCode\":\"007\",\"cateName\":\"校验类\",\"cateCode\":\"01\",\"isSuccess\":true}],\"02\":[{\"queryCost\":5.0,\"itemId\":\"1170330211338038028\",\"itemName\":\"户籍信息验证\",\"itemData\":[{\"itemPropLabel\":\"身份证号\",\"itemPropName\":\"idNo\",\"itemPropValue\":\"513902199102138875\",\"set\":false},{\"itemPropLabel\":\"性别\",\"itemPropName\":\"gender\",\"itemPropValue\":\"男\",\"set\":false},{\"itemPropLabel\":\"出生日期\",\"itemPropName\":\"birthday\",\"itemPropValue\":\"1991-02-13\",\"set\":false},{\"itemPropLabel\":\"籍贯\",\"itemPropName\":\"nativePlace\",\"itemPropValue\":\"四川省资阳简阳市\",\"set\":false},{\"itemPropLabel\":\"姓名\",\"itemPropName\":\"name\",\"itemPropValue\":\"??\",\"set\":false}],\"itemCode\":\"102\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true},{\"queryCost\":15.0,\"itemId\":\"1709011710017921008\",\"itemName\":\"个人涉诉记录\",\"itemData\":[{\"itemPropLabel\":\"失信公告摘要\",\"itemPropName\":\"sxggList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"裁判文书\",\"itemPropName\":\"cpwsList\",\"itemPropValue\":[[{\"itemPropLabel\":\"时间\",\"itemPropName\":\"sortTime\",\"itemPropValue\":\"2015年06月01日\",\"set\":false},{\"itemPropLabel\":\"裁判文书ID\",\"itemPropName\":\"cpwsId\",\"itemPropValue\":\"c2015luxingchu49_t20150601\",\"set\":false},{\"itemPropLabel\":\"裁判文书内容\",\"itemPropName\":\"cpwsContent\",\"itemPropValue\":\"...县人民法院 0.0 历洋洋...\",\"set\":false},{\"itemPropLabel\":\"裁判文书标题\",\"itemPropName\":\"cpwsTitle\",\"itemPropValue\":\"被告人历**犯强奸罪一案\",\"set\":false},{\"itemPropLabel\":\"判决法院\",\"itemPropName\":\"sentenceCourt\",\"itemPropValue\":\"河南省鹿邑县人民法院\",\"set\":false},{\"itemPropLabel\":\"案号\",\"itemPropName\":\"refNum\",\"itemPropValue\":\"（2015）鹿刑初字第49号\",\"set\":false},{\"itemPropLabel\":\"涉诉类型\",\"itemPropName\":\"typesOfLitigation\",\"itemPropValue\":\"刑事判决书\",\"set\":false}]],\"set\":true},{\"itemPropLabel\":\"执行公告摘要\",\"itemPropName\":\"zxggList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"网贷黑名单摘要\",\"itemPropName\":\"wdhmdList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"曝光台\",\"itemPropName\":\"bgtList\",\"itemPropValue\":[],\"set\":true}],\"itemCode\":\"135\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true},{\"queryCost\":0.0,\"itemId\":\"1170502110900736000\",\"itemName\":\"职业资格\",\"itemData\":[],\"itemCode\":\"119\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":false}],\"03\":[{\"queryCost\":10.0,\"itemId\":\"1170417191610363057\",\"itemName\":\"不良信息验证\",\"itemData\":[],\"itemCode\":\"205\",\"cateName\":\"黑名单类\",\"cateCode\":\"03\",\"isSuccess\":false}]}}}";
//		Map<String,Object> map = returnMapByJSON(json);
//		System.out.println("................");
//		for (String key : map.keySet()) { 
//			Object value = map.get(key); 
//			System.out.println("Key = " + key + ", Value = " + value.toString());
//		}
//	}
	
	/**
	 * 根据json字符串返回map对象
	 * @param json
	 * @return
	 */
	public static Map<String,Object> returnMapByJSON(String jsonStr){
		Map<String,Object> map = null;
		try {
			JSONObject json = JSONObject.fromObject(jsonStr);
			if(json.containsKey("code")){//接口正确返回
				if(json.getInt("code") == 200){
					map = new HashMap<>();
					map.put("ispass", true);
					map.put("code", json.getInt("code"));
					if(json.containsKey("data")){
						JSONObject data = json.getJSONObject("data");
						map.put("reportId", data.getString("reportId"));
						JSONObject reportDetail = data.getJSONObject("reportDetail");
						
						@SuppressWarnings("unchecked")
						Iterator<String> sIterator = reportDetail.keys();
						while(sIterator.hasNext()){
							String key = sIterator.next();
							JSONArray value = reportDetail.getJSONArray(key);
							map.put(key, itemCheck(value,map));
						}
					}
				}
				return map;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Map<String,Object>> itemCheck(JSONArray jsonArray,Map<String,Object> fMap){
		List<Map<String,Object>> list = new ArrayList<>();
		for (int j = 0; j < jsonArray.size(); j++) {
			Map<String,Object> map = new HashMap<>();
			JSONObject jsonObject = jsonArray.getJSONObject(j);
			map.put("itemName", jsonObject.getString("itemName"));
			map.put("ispass", true);
			if(jsonObject.containsKey("itemData")){
				JSONArray itemData = jsonObject.getJSONArray("itemData");
				map.put("itemData", itemData);
				if(itemData.size() > 0){
					for (int i = 0; i < itemData.size(); i++) {
						JSONObject obj = itemData.getJSONObject(i);
						if(obj.containsKey("itemPropValue")){
							if(obj.get("itemPropValue") instanceof String){
								if(!"".equals(obj.getString("itemPropValue")) && !"校验通过".equals(obj.getString("itemPropValue"))){
									if("户籍信息验证".equals(map.get("itemName").toString())) {
										map.put("ispass", null);
										break;
									}else {
										map.put("ispass", false);
										fMap.put("ispass", false);
										break;
									}
								}
							}else{
								JSONArray itemPropValueArray = obj.getJSONArray("itemPropValue");
								if(itemPropValueArray.size() > 0){
									map.put("ispass", false);
									fMap.put("ispass", false);
									break;
								}
							}
						}
					}
				}
			}
			list.add(map);
		}
		return list;
	}
	
}
