package com.suxiaomei.admin.controller.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.response.Dict;
import com.suxiaomei.admin.util.redis.RedisUtil;

@Controller
@RequestMapping("/common/dict") 
public class RedisController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> findModule(@RequestParam String key) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",RedisUtil.getList(redisTemplate, key, new Dict()));
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(value="getJson",method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> getJson(String key) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			Object obj = RedisUtil.get(redisTemplate, key);
			if(obj != null){
		    	JSONArray provinceArray = JSONArray.fromObject(obj.toString());
				resultMap.put("data",provinceArray);
			}else{
				resultMap.put("data","[]");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
		return SUCCESS(resultMap);
	}
}
