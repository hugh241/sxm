package com.suxiaomei.admin.util.redis;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.util.Md5;
import com.suxiaomei.admin.util.Util;
  
public class TokenUtil{
    /** 
     * 生成加密Token 
     * @param <T>
     *  
     * @param username 
     * @return 
     */  
    public static UserToken generateToken(String str){  
	    UserToken userToken = new UserToken();  
	    // 设置签名  
	    userToken.setSignature(str);  
	    // 设置时间戳 
	    userToken.setTimestamp(Util.getTimeStamp());  
	    // 设置随机数  
	    userToken.setRandom(Util.getRandom());  
	    // 设置授权码  
	    userToken.setAuthorizationCode(getAuthorizationCode(str));  
	    return userToken;  
    }
      
    /** 
     *  创建用户Token 
     * @param <T>
     * @param username 
     * @param u 
     * @return 明文加密后的字符串
     */  
    public static String createUserToken(RedisTemplate<String,Object> redisTemplate,String username,User user,long userinfosavetime){
	    UserToken userToken = generateToken(username);//得到Token对象
	    String token=encryptUserToken(userToken);//加密后的字符串
	    String encryptSignature=encryptSignature(username);
	    Object obj = RedisUtil.get(redisTemplate,encryptSignature);
	    if(obj != null){
	    	RedisUtil.del(redisTemplate, encryptSignature);
		}
	    userToken.setUser(user);
	    userToken.setToken(token);
	    RedisUtil.set(redisTemplate, encryptSignature, userToken,userinfosavetime);
	    return token;
    }
    
    /** 
     * 注销用户Token 
     * @param <T>
     * @param username 
     * @param u 
     * @return 明文加密后的字符串
     */  
    public static void deleteToken(RedisTemplate<String,Object> redisTemplate,String username){
	    String encryptSignature=encryptSignature(username);
	    RedisUtil.del(redisTemplate, encryptSignature);
    }
      
    /** 
     * 加密签名 
     * @param username 
     * @return 
     */  
    public static String encryptSignature(String username){  
    	return JCSharpDESUtil.encrypt(username);  
    }  
      
    /** 
     * 解密签名 
     * @param signature 
     * @return 
     */  
    public static String decryptSignature(String signature){
    	return JCSharpDESUtil.decrypt(signature);  
    }  
      
    /** 
     * 加密用户Token 
     * @param <T>
     * @param userToken 
     * @return 
     */  
    public static <T> String encryptUserToken(UserToken userToken){
    	return JCSharpDESUtil.encrypt(userToken.toString());  
    }  
      
    /** 
     * 解析加密用户Token 
     * @param <T>
     * @param token 
     * @return 
     */  
    public static UserToken decryptUserToken(String token){
	    String decryptToken=JCSharpDESUtil.decrypt(token);  
	    String[] params = decryptToken.split("&");  
	    UserToken userToken = new UserToken();  
	    for (int i = 0, j = params.length; i < j; i++){  
	        String[] currentParams = params[i].split("=");  
	        String param = currentParams[0];  
	        switch (param)  
	        {  
	        case "signature":  
	            userToken.setSignature(params[i].substring(currentParams[0].length()+1));  
	            break;  
	        case "timestamp":  
	            userToken.setTimestamp(params[i].substring(currentParams[0].length()+1));  
	            break;  
	        case "random":  
	            userToken.setRandom(params[i].substring(currentParams[0].length()+1));  
	            break;  
	        case "authorizationCode":  
	            userToken.setAuthorizationCode(params[i].substring(currentParams[0].length()+1));  
	            break;  
	        default:  
	            break;  
	        }  
	    }  
	    return userToken;  
    }  
      
    /** 
     * 【解密用户Token】分析用户Token 
     * @param <T>
     * @param token 
     * @return 
     */  
    public static UserToken analyseEncryptedUserToken(String token){
	    UserToken userToken=decryptUserToken(token);  
	    return userToken;  
    }  
      
    /** 
     * 验证用户Token 
     * @param redisTemplate 
     * @param <T>
     * @param token 
     * @param userToken 
     * @return 
     */  
    public static <T> boolean verifyUserToken(RedisTemplate<String, Object> redisTemplate, String token,String username){
	    // 分析用户需要验证的Token  
	    UserToken userToken= decryptUserToken(token);
	    // 给用户加密签名  
	    String encryptSignature=encryptSignature(userToken.getSignature());  
	    Object obj = RedisUtil.get(redisTemplate, encryptSignature);
	    if(obj == null){
	    	return false;
	    }
	    
	    //判断解析的用户名称和传入的名称是否相同
	    if(!userToken.getSignature().equals(username)){
	    	return false;
	    }
	    
		UserToken userToken2=(UserToken)obj;
	    if (userToken2!=null&&(userToken.toString()).equals(userToken2.toString())){  
	        // 判定时间戳是否过期
	        long currentTime = Calendar.getInstance().getTimeInMillis();  
	        long timestamp = Long.valueOf(userToken.getTimestamp());  
	        // Token有效时间为120分钟  
	        long verifyTime = 2 * 60 * 60 * 1000;  
	        if (currentTime - timestamp > verifyTime){  
		        // 移除过期的Token  
		        RedisUtil.del(redisTemplate, encryptSignature);
		        return false;  
	        }
	        return true;
	    }
	    return false;  
    }  
      
    /** 
     * 根据用户名获取MD5Token 
     * @param username 
     * @return 
     */  
    public static String getAuthorizationCode(String username){  
	    String token = Md5.EncoderByMd5("username=" + username + "&date=" + Util.getTimeStamp());  
	    return token;  
    }  
      
    public static UserToken decryptUserTokenIOS(String token){  
	    String[] params = token.split("&");  
	    // 分析用户提交过来的Token  
	    UserToken userToken = new UserToken();
	    for (int i = 0, j = params.length; i < j; i++){  
	        String[] currentParams = params[i].split("=");  
	        String param = currentParams[0];  
	        switch (param){  
	        case "signature":  
	            userToken.setSignature(currentParams[1]);  
	            break;  
	        case "timestamp":  
	            userToken.setTimestamp(currentParams[1]);  
	            break;  
	        case "random":  
	            userToken.setRandom(currentParams[1]);  
	            break;  
	        case "authorizationCode":  
	            userToken.setAuthorizationCode(currentParams[1]);  
	            break;  
	        default:  
	            break;  
	        }  
	    }  
	    return userToken;  
    }  
    
    /**
     * 获取服务器中保存的UserToken
     * @param <T>
     * @param token
     * @return
     */
    public static UserToken getStaticUserToken(RedisTemplate<String,Object> redisTemplate,String token){
	    UserToken userToken=decryptUserToken(token);  
	    String encryptSignature=encryptSignature(userToken.getSignature());  
	    return (UserToken)RedisUtil.get(redisTemplate, encryptSignature);
    }  
} 