package com.suxiaomei.admin.util.sms;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.suxiaomei.admin.util.Util;
/**
 * 短信发送接口
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
 * 2018年10月29日 下午4:00:25
 */
public class SMSUtil {
	public static boolean SendSmsZG(String url,String username,String key,String cgid,String mobile, String content) throws Exception{
		HttpURLConnection httpconn = null;
		String result = "120";
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("&ac=").append(username);
		sb.append("&authkey=").append(key);
		sb.append("&cgid=").append(cgid);
		sb.append("&m=").append(mobile);
		sb.append("&c=").append(URLEncoder.encode(content, "UTF-8")); // 注意乱码的话换成UTF-8编码
		try {
			String request = sb.toString();
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(request);
			CloseableHttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpconn != null) {
				httpconn.disconnect();
				httpconn = null;
			}
		}
		return ZgdxwSMSBack(result);
	}


	/**
	 * 中国短信网短信反馈信息
	 * 
	 * @param message
	 * @return
	 */
	public static boolean ZgdxwSMSBack(String result) {
		if (Util.isEmptyStr(result)) {
			return false;
		}
		try {
			Document doc = DocumentHelper.parseText(result);
			Element root = doc.getRootElement();
			String r = root.attributeValue("result");
			switch (r) {
			case "1":
				return true;
			case "0":
				System.out.println("帐户格式不正确(正确的格式为:员工编号@企业编号)");
				return false;
			case "-1":
				System.out.println("服务器拒绝(速度过快、限时或绑定IP不对等)如遇速度过快可延时再发");
				return false;
			case "-2":
				System.out.println("密钥不正确");
				return false;
			case "-3":
				System.out.println("密钥已锁定");
				return false;
			case "-4":
				System.out.println("参数不正确(内容和号码不能为空，手机号码数过多，发送时间错误等)");
				return false;
			case "-5":
				System.out.println("无此帐户");
				return false;
			case "-6":
				System.out.println("帐户已锁定或已过期");
				return false;
			case "-7":
				System.out.println("帐户未开启接口发送");
				return false;
			case "-8":
				System.out.println("不可使用该通道组");
				return false;
			case "-9":
				System.out.println("帐户余额不足");
				return false;
			case "-10":
				System.out.println("内部错误");
				return false;
			case "-11":
				System.out.println("扣费失败");
				return false;
			default:
				System.out.println("系统错误");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
