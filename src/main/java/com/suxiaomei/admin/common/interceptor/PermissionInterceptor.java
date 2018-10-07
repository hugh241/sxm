package com.suxiaomei.admin.common.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.service.common.ModuleService;
import com.suxiaomei.admin.util.ExceptValidateModule;
import com.suxiaomei.admin.util.InterceptorUtil;
import com.suxiaomei.admin.util.redis.TokenUtil;
import com.suxiaomei.admin.util.redis.UserToken;

import net.sf.json.JSONObject;
/**
 * 后台请求权限拦截器，进行权限校验
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
 * 2018年9月26日 上午10:08:59
 */
public class PermissionInterceptor implements HandlerInterceptor{
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ModuleService moduleService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURL().toString();
		System.out.print(url);
		if(!InterceptorUtil.isUserPass(url)){//无论是否登录都不需拦截的连接
			return true;
		}
		String token = request.getHeader("token");
		String username = URLDecoder.decode(URLDecoder.decode(request.getHeader("username"),"utf-8"),"utf-8");
		if(token == null || username == null || "".equals(token.trim()) || "".equals(username.trim())) {
			sendUnloginJSON(response);
			return false;
		}
		String method = request.getMethod();
		System.out.println("  username:"+username + "  method:"+method);
		boolean flag = TokenUtil.<User>verifyUserToken(redisTemplate,token,username);
		if(!flag){//username token不匹配
			sendUnloginJSON(response);
			return false;
		}
		
		String menuStr = url.split("/api/")[1];
		if(ExceptValidateModule.isExist(menuStr,method)){//登录后不需拦截的链接
			return true;
		}
		//根据用户角色验证该角色是否有权限
		Role role = ((UserToken) TokenUtil.getStaticUserToken(redisTemplate,token)).getUser().getRole();
		boolean isRight = moduleService.isRight(role,menuStr.split("/|\\?")[0]);
		if(isRight){//权限验证用过
			return true;
		}
		sendUnRightJSON(response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.gc();
	}
	
	public void sendUnloginJSON(HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		Map<String,Object> obj = new HashMap<>();
		obj.put("code", Code.LOGIN_UNLOGIN.getCode());
		obj.put("message", Code.LOGIN_UNLOGIN.getMessage());
		writer.print(JSONObject.fromObject(obj).toString());
		writer.close();
	}
	
	public void sendUnRightJSON(HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		Map<String,Object> obj = new HashMap<>();
		obj.put("code", Code.PERMISSION_FAILED.getCode());
		obj.put("message", Code.PERMISSION_FAILED.getMessage());
		writer.print(JSONObject.fromObject(obj).toString());
		writer.close();
	}
}
