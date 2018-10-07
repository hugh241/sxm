package com.suxiaomei.admin.util;

import java.io.IOException;  
import sun.misc.BASE64Decoder;  
import sun.misc.BASE64Encoder;  
  
public class Base64 {  
  
    /** 
     * @param args 
     */  
//    public static void main(String[] args) {  
//        Base64 base=new Base64();  
//        String pass="123";  
//        String en=base.encode(pass);  
//        String de=base.decode(en);  
//    }  
      
    //译成密码  
    public String encode(String pass){        
        BASE64Encoder base=new BASE64Encoder();  
        pass=base.encode(pass.getBytes());  
        return pass;  
    }  
      
    //  
    public String encode(byte [] b){          
        return encode(new String(b));  
    }  
      
    //解密  
    public String decode(String pass) {  
        BASE64Decoder base=new BASE64Decoder();  
        byte[] b = null;  
        try {  
            b = base.decodeBuffer(pass);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return new String(b);  
          
    }  
  
}
