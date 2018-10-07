package com.suxiaomei.admin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {
	/** 
     * @param args 
     */  
    public static void main(String[] args){  
//        System.out.println(Md5.Bit32("lytzgs"+Md5.Bit32("123456")));
    }  
    
    public static String EncoderByMd5(String str){
    	byte[] b=getDigest(str.getBytes());          
        Base64 b64= new Base64();  
        return b64.encode(b);  
    }
    
    public static String DecoderByMd5(String str){
    	byte[] b=getDigest(str.getBytes());          
        Base64 b64= new Base64();  
        String decode = b64.decode(str);
        return b64.decode(str);
    }
      
    //MD5加密  
    public static byte[] getDigest(byte[] b){  
        try {  
            MessageDigest md=MessageDigest.getInstance("MD5");            
            md.update(b);  
            return md.digest();  
        } catch (NoSuchAlgorithmException e) {  
            //FIXME:DDD  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
    
    private static String toHexString(byte[] b) {  
        StringBuilder sb = new StringBuilder(b.length * 2);  
        for (int i = 0; i < b.length; i++) {  
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);  
            sb.append(HEX_DIGITS[b[i] & 0x0f]);  
        }
        return sb.toString();  
    }  
      
    public static String Bit32(String SourceString){  
    	try {
    		MessageDigest digest = java.security.MessageDigest.getInstance("MD5");  
            digest.update(SourceString.getBytes()); 
            byte messageDigest[] = digest.digest();
            return toHexString(messageDigest);  
		} catch (Exception e) {
			e.printStackTrace();
		}
        return SourceString;
    }  
      
    public static String Bit16(String SourceString) throws Exception {  
        return Bit32(SourceString).substring(8, 24);  
    }
    
    public static String getMD5(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
        try {  
            byte[] btInput = s.getBytes();  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest();  
            // 把密文转换成十六进制的字符串形式  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }
}
