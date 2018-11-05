package com.suxiaomei.admin.util.http;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
    
public class HttpClientUtil {
	/**
	 * 护理员背景调查
	 * @param name
	 * @param idcard
	 * @return
	 * @throws Exception
	 */
	public static String doPostEmployeeBackgroundCheck(String name,String idcard,String url,String userid,String password,String productid){
        HttpClient httpClient = new HttpClient();
        PostMethod post = new PostMethod(url);
        post.setRequestHeader("Content-Type","application/x-www-form-urlencoded"); 
        post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8"); 
        NameValuePair[] param = { 
        		new NameValuePair("userId",userid),
                new NameValuePair("password",password),
                new NameValuePair("productId",productid),
                new NameValuePair("name",name),
                new NameValuePair("idNo",idcard)
        };
        post.setRequestBody(param);
        post.releaseConnection();
        try {
        	 httpClient.executeMethod(post);
             String response = post.getResponseBodyAsString();
             return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
}