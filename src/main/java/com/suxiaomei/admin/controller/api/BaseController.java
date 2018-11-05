package com.suxiaomei.admin.controller.api;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.util.redis.TokenUtil;
import com.suxiaomei.admin.util.redis.UserToken;

public class BaseController extends HttpServlet{
	@Resource
	private RedisTemplate<String,Object> redisTemplate;

	private static final long serialVersionUID = 1L;
	public static final String MESSAGE = "message";
	public static final String CODE = "code";
	public User cUser;

	public Map<String, Object> SUCCESS(Map<String, Object> map) {
		map = map == null ? map = new HashMap<>() : map;
		map.put(MESSAGE, Code.SUCCESS.getMessage());
		map.put(CODE, Code.SUCCESS.getCode());
		return map;
	}
	
	public Map<String, Object> SUCCESS(Map<String, Object> map,Object obj) {
		map = map == null ? map = new HashMap<>() : map;
		map.put("data", obj);
		map.put(MESSAGE, Code.SUCCESS.getMessage());
		map.put(CODE, Code.SUCCESS.getCode());
		return map;
	}

	public Map<String, Object> ERROR(Map<String, Object> map) {
		map = map == null ? map = new HashMap<>() : map;
		map.put(MESSAGE, Code.CONTROLLE_FAILED.getMessage());
		map.put(CODE, Code.CONTROLLE_FAILED.getCode());
		return map;
	}
	
	public Map<String, Object> ERROR(Map<String, Object> map,Code code) {
		map = map == null ? map = new HashMap<>() : map;
		map.put("data",0);
		map.put(MESSAGE, code.getMessage());
		map.put(CODE, code.getCode());
		return map;
	}

	public Map<String, Object> ERROR(Map<String, Object> resultMap, Exception e) {
		e.printStackTrace();
		resultMap = resultMap == null ? resultMap = new HashMap<>() : resultMap;
		resultMap.put(MESSAGE, Code.CONTROLLE_FAILED.getMessage());
		resultMap.put(CODE, Code.CONTROLLE_FAILED.getCode());
		return resultMap;
	}
	
	public Map<String,Object> GENERALRETURN(Map<String, Object> resultMap,int flag){
		resultMap = resultMap == null ? resultMap = new HashMap<>() : resultMap;
		resultMap.put("data",flag);
		if(flag == 1) {
			resultMap.put(CODE, 241);
			resultMap.put(MESSAGE, Code.getName(241));
		}else if(flag == 0) {
			resultMap.put(CODE, 449);
			resultMap.put(MESSAGE, Code.getName(449));
		}else {
			resultMap.put(CODE, flag);
			resultMap.put(MESSAGE, Code.getName(flag));
		}
		return resultMap;
	}
	
	@ModelAttribute
	public void before(HttpServletRequest request){
		String token = ((HttpServletRequest) request).getHeader("token");
		String url = request.getRequestURL().toString();
		if(url.indexOf("/api/") != -1 && token != null && !"".equals(token.trim())){
			UserToken userToken = (UserToken) TokenUtil.getStaticUserToken(redisTemplate,token);
			if(userToken != null && userToken.getUser() != null){
				cUser = userToken.getUser();
			}
		}
	}
}
