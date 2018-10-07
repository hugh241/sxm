package com.suxiaomei.admin.util.redis;

import com.suxiaomei.admin.entity.account.User;
public class UserToken{  
	private String signature;// 签名  
    private String timestamp;// 时间戳  
    private String random;// 随机数  
    private String authorizationCode;//授权码  
    private String token;
    private User user;
    public String getSignature()  {  
    	return signature;  
    }  
    public void setSignature(String signature){  
    	this.signature = signature;  
    }  
    public String getTimestamp()  {  
    	return timestamp;  
    }  
    public void setTimestamp(String timestamp)  {  
    	this.timestamp = timestamp;  
    }  
    public String getRandom()  {  
    	return random;  
    }  
    public void setRandom(String random)  {  
    	this.random = random;  
    }  
    public String getAuthorizationCode()  {  
        return authorizationCode;  
    }  
    public void setAuthorizationCode(String authorizationCode)  {  
        this.authorizationCode = authorizationCode;  
    }  
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override  
    public String toString(){  
    	return "signature=" + signature + "&timestamp=" + timestamp + "&random=" + random+ "&authorizationCode=" + authorizationCode;  
    }  
}  
