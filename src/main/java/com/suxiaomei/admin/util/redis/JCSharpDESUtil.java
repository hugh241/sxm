package com.suxiaomei.admin.util.redis;

import java.security.Key;  
import java.security.spec.AlgorithmParameterSpec;  

import javax.crypto.Cipher;  
import javax.crypto.SecretKeyFactory;  
import javax.crypto.spec.DESKeySpec;  
import javax.crypto.spec.IvParameterSpec;  
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * MD5加密
 * @author zl
 */
public class JCSharpDESUtil  
{  
    // DES加密的私钥，必须是8位长的字符串  
    private static final byte[] DESkey = "sxmbackk".getBytes();// 设置密钥  
    private static final byte[] DESIV = "sxmbackk".getBytes();// 设置向量  
      
    static AlgorithmParameterSpec iv = null;// 加密算法的参数接口，IvParameterSpec是它的一个实现  
    private static Key key = null;  
      
    static{
    	DESKeySpec keySpec;  
    	try{  
	        keySpec = new DESKeySpec(DESkey);// 设置密钥参数  
	        iv = new IvParameterSpec(DESIV);// 设置向量  
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂  
	        key = keyFactory.generateSecret(keySpec);// 得到密钥对象  
	    } catch (Exception e){  
	        e.printStackTrace();
	    }  
    }  
    
    /**
     * 加密
     * @param data
     * @return
     */
    public static String encrypt(String data){  
	    try{  
	        Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher  
	        enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量  
	        byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));  
	        BASE64Encoder base64Encoder = new BASE64Encoder();  
	        return base64Encoder.encode(pasByte).replace("\n", "").replace("\r", "");// 去掉换行回车符  
	    } catch (Exception e){  
	        e.printStackTrace();
	    }  
	    return "";  
    }  
    
    /**
     * 解密
     * @param data
     * @return
     */
    public static String decrypt(String data){  
	    try{  
	        Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
	        deCipher.init(Cipher.DECRYPT_MODE, key, iv);  
	        BASE64Decoder base64Decoder = new BASE64Decoder();  
	        byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));  
	        return new String(pasByte, "UTF-8");  
	    } catch (Exception e){  
	        e.printStackTrace();
	    }  
	    return "";  
    }  
      
//    public static void main(String[] args) throws Exception{   
//	    UserToken encryptedToken = new UserToken();
//	    encryptedToken.setSignature("admin");
//	    encryptedToken.setTimestamp(Calendar.getInstance().getTimeInMillis() + "");
//	    encryptedToken.setRandom(new Random().nextInt(999999999) + "");
//	    String text = encryptedToken.toString();
//	    System.out.println("明文：" + text);
//	    String encryptData = JCSharpDESUtil.encrypt(text);
//	    System.out.println("加密：" + encryptData);
//	    System.out.println("解密：" + JCSharpDESUtil.decrypt(encryptData));
//    }  
}
