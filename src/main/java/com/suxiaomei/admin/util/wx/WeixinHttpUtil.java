package com.suxiaomei.admin.util.wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

/**
 * 微信网络请求
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
 * 2018年9月20日 下午5:32:48
 */
public class WeixinHttpUtil {    
	public static String doGet(String url){  
        String result = "";  
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);//创建HttpPost对象  
        try {
            HttpResponse res = client.execute(httpGet);
            if(res.getStatusLine().getStatusCode() == 200){
                InputStream is = res.getEntity().getContent();
                result = getStreamAsString(is, HTTP.UTF_8);
                is.close();
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
            result = e.getMessage().toString();  
        }  
        return result;  
    } 
	
	public static String doPost(String url,String json){  
        String result = "";  
        HttpClient client = new DefaultHttpClient();
        HttpPost httpRequst = new HttpPost(url);//创建HttpPost对象  
        try {
        	StringEntity s = new StringEntity(json.toString(),HTTP.UTF_8);
            httpRequst.setEntity(s);  
            try {
            	HttpResponse res = client.execute(httpRequst);
                if(res.getStatusLine().getStatusCode() == 200){
                    InputStream is = res.getEntity().getContent();
                    result = getStreamAsString(is, HTTP.UTF_8);
                    is.close();
                } 
			} catch (Exception e) {
				e.printStackTrace();
			}
        } catch (Exception e) {  
            e.printStackTrace();
            result = e.getMessage().toString();  
        }  
        return result;  
    }  
	
	/**
     * 
     * 将InputStream 转化为String
     * 
     * @param stream
     *            inputstream
     * @param charset
     *            字符集
     * @return
     * @throws IOException
     */
    public static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset), 8192);
            StringWriter writer = new StringWriter();
 
            char[] chars = new char[8192];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }
 
            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
