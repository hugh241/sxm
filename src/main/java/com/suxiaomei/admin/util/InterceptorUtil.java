package com.suxiaomei.admin.util;

/**
 * 拦截器工具类
 * @author zl
 */
public class InterceptorUtil {
	/**
	 * 判断是否进行账号拦截
	 * @param url
	 * @return
	 */
	public static boolean isUserPass(String url){
		if(url.indexOf("api/login") == -1 && url.indexOf("register") == -1 && url.indexOf("bLogin") == -1){
			return true;
		}
		return false;
	}
}
