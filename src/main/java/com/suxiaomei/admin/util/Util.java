package com.suxiaomei.admin.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.interceptor.TransactionAspectSupport;

import net.sf.json.JSONObject;
public class Util {
	/**
	 * 判断字符串是否为空
	 * 
	 * @param target
	 * @return
	 */
	public static boolean isEmptyStr(String target) {
		if (target == null || target.equals("") || target == "") {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 判断list是否为空
	 * 
	 * @param target
	 * @return
	 */
	public static boolean isEmptyList(List<Object> list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}
	/**
	 * 判断map是否为空
	 * 
	 * @param target
	 * @return
	 */
	public static boolean isEmptyMap(Map<String, Object> map) {
		if (map == null || map.size() == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Object转String
	 * @param o
	 * @return String
	 * */
	public static String StringValueOf(Object o) {
		return o == null ? "" : o.toString();
	}
	/**
	 * Object转int
	 * 
	 * @param o
	 * @return int
	 * */
	public static int IntValueOf(Object o) {
		return o == null ? 0 : Integer.valueOf(o.toString());
	}
	/**
	 * MD5加密
	 * 
	 * @param inStr
	 * @return
	 * @author li
	 */
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	/**
	 * sha1加密
	 * @param str
	 * @return
	 */
	public static String sha1(String... str) {
		String[] s = stringSort(str);
		String ss = "";
		for (String string : s) {
			ss += string;
		}
		MessageDigest md = null;
		String outStr = null;
		try {
			md = MessageDigest.getInstance("SHA-1"); // 选择SHA-1，也可以选择MD5
			byte[] digest = md.digest(ss.getBytes()); // 返回的是byet[]，要转化为String存储比较方便
			outStr = bytetoString(digest);
		} catch (NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}
		return outStr;
	}
	/**
	 * byte 数组转字符串
	 * @param digest
	 * @return
	 */
	public static String bytetoString(byte[] digest) {
		String str = "";
		String tempStr = "";

		for (int i = 0; i < digest.length; i++) {
			tempStr = (Integer.toHexString(digest[i] & 0xff));
			if (tempStr.length() == 1) {
				str = str + "0" + tempStr;
			} else {
				str = str + tempStr;
			}
		}
		return str.toLowerCase();
	}

	/**
	 * 数组按字典排序
	 * @param s
	 * @return
	 */
	public static String[] stringSort(String[] s) {
		List<String> list = new ArrayList<String>(s.length);
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		Collections.sort(list);
		return list.toArray(s);
	}
	/**
	 * 生成随机不重复secure_key
	 * @return
	 */
	public static String getSecureKey() {
		long time = System.currentTimeMillis();
		String str = "" + Math.abs(new Random().nextInt()) % 100 + time;
		return MD5(str);
	}
	/**
	 * 获取UUID
	 * 
	 * @return
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	/**
	 * 随机生成4位验证码
	 * @return
	 */
	public static String getCheckCode() {
		Random r = new Random();
		int code = r.nextInt(9999);
		while (code <= 1000) {
			code = r.nextInt(9999);
		}
		return code + "";
	}
	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isMobile(String mobile) {
		return Pattern.matches(REGEX_MOBILE, mobile);
	}
	/* 正则表达式：验证手机号 */
	public static final String REGEX_MOBILE = "(13\\d{9}$)|(14)[5,7]\\d{8}$|(15[0,1,2,3,4,5,6,7,8,9]\\d{8}$)|(17)[0,1,2,3,4,5,6,7,8,9]\\d{8}$|(18\\d{9}$)";
	/**
	 * 将json格式的字符串解析成Map对象
	 * json格式：{"name":"admin","retries":"3fff","testname":"ddd"
	 * ,"testretries":"fffffffff"}
	 */
	public static HashMap<String, Object> json2Map(Object object) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		// 将json字符串转换成jsonObject
		JSONObject jsonObject = JSONObject.fromObject(object);
		Iterator it = jsonObject.keys();
		// 遍历jsonObject数据，添加到Map对象
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			String value = (String) jsonObject.get(key);
			data.put(key, value);
		}
		return data;
	}
	/**
	 * 解析出url请求的路径，包括页面
	 * @param strURL
	 *            url地址
	 * @return url路径
	 */
	public static String UrlPage(String strURL) {
		String strPage = null;
		String[] arrSplit = null;
		strURL = strURL.trim().toLowerCase();
		arrSplit = strURL.split("[?]");
		if (strURL.length() > 0) {
			if (arrSplit.length > 1) {
				if (arrSplit[0] != null) {
					strPage = arrSplit[0];
				}
			}
		}
		return strPage;
	}
	/**
	 * 去掉url中的路径，留下请求参数部分
	 * @param strURL
	 *            url地址
	 * @return url请求参数部分
	 */
	private static String TruncateUrlPage(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;
		strURL = strURL.trim().toLowerCase();
		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}
		return strAllParam;
	}
	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> URLRequest(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();
		String[] arrSplit = null;
		String strUrlParam = TruncateUrlPage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组
		arrSplit = strUrlParam.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * 将字符串按给定的字符截取为字符串集合
	 * @param str
	 * @param regex
	 * @return
	 */
	public static List<String> str2List(String str, String regex) {
		if (isEmptyStr(str)) {
			return null;
		} else {
			List<String> list = new ArrayList<String>();
			String[] arr = str.split(regex);
			for (String string : arr) {
				list.add(string);
			}
			return list;
		}
	}

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 如：X-Forwarded-For：192.168.1.110,
	 * 192.168.1.120, 192.168.1.130, 192.168.1.100 用户真实IP为： 192.168.1.110
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * Object转float
	 * 
	 * @param o
	 * @return
	 */
	public static float FloatValueOf(Object o) {
		return o == null ? 0 : Float.valueOf(o.toString());
	}

	/**
	 * 还原微信信息中的*号为=号
	 * 
	 * @param str
	 * @return
	 */
	public static String strFormat(String str) {
		return str.replace("*", "=");
	}

	/**
	 * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
	 * 
	 * @param request
	 * @return ip
	 */
	public static String getLocalIp(HttpServletRequest request) {
		String remoteAddr = request.getRemoteAddr();
		String forwarded = request.getHeader("X-Forwarded-For");
		String realIp = request.getHeader("X-Real-IP");

		String ip = null;
		if (realIp == null) {
			if (forwarded == null) {
				ip = remoteAddr;
			} else {
				ip = remoteAddr + "/" + forwarded.split(",")[0];
			}
		} else {
			if (realIp.equals(forwarded)) {
				ip = realIp;
			} else {
				if (forwarded != null) {
					forwarded = forwarded.split(",")[0];
				}
				ip = realIp + "/" + forwarded;
			}
		}
		return ip;
	}
	
	public static synchronized String getCustomerNum() {
	   String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	   str+=(int)Math.random()*100;
	   return str;
   }
	
   public static synchronized String getContractNum() {
	   String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	   str+=(int)Math.random()*100;
	   return str;
   }

	/**
	 * 生成时间戳
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		return Calendar.getInstance().getTimeInMillis() + "";
	}

	/**
	 * 生成随机数
	 * 
	 * @return
	 */
	public static String getRandom() {
		return new Random().nextInt(999999999) + "";
	}
	public static String getRandom4() {
		return new Random().nextInt(9999) + "";
	}

	/**
	 * 判断是否是数字
	 * 
	 * @param str
	 * @return true是数字 false不是数字
	 */
	public static boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static float decimalUtil(float f, int i) {
		BigDecimal bg = new BigDecimal(f);
		float f1 = bg.setScale(i, BigDecimal.ROUND_HALF_UP).floatValue();
		return f1;
	}

	private static String date;
	private static long orderNum = 0l;

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	public static synchronized String getOrderNo() {
		String str = new SimpleDateFormat("yyMMddHHmm").format(new Date());
		if (date == null || !date.equals(str)) {
			date = str;
			orderNum = 0l;
		}
		orderNum++;
		long orderNo = Long.parseLong((date)) * 10000;
		orderNo += orderNum;
		;
		return orderNo + "";
	}

	/**
	 * 手动回滚事务
	 */
	public static void callBackT() {
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}

	/**
	 * 出账-统一为负数
	 * 
	 * @param money
	 * @return
	 */
	public static double getpayout(double money) {
		return money > 0 ? -money : money;
	}
	/**
	 * 得到number的整数位和小数位数组
	 * 如6.32返回【6.0和0.32】
	 * @param number
	 * @return
	 */
	public static double[] getNumDecimalDigits(double number) {
		String moneyStr = String.valueOf(number);
	    String[] num = moneyStr.split("\\.");
	    double[] d = new double[2];
	    if(num.length == 2){
	    	d[0] = Double.parseDouble(num[0]);
	    	d[1] = Double.parseDouble("0."+num[1]);
	    	return d;
	    }
	    Arrays.fill(d,number);
	    d[1] = 0.0;
	    return d;
	}
}
