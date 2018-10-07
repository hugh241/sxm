package com.suxiaomei.admin.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 对比两个时间字符串判断大小
	 * @param DATE1 第一个时间字符串
	 * @param DATE2 第二个时间字符串
	 * @param formatStr 时间格式 ps：yyyy-MM-dd
	 * @return 1第一个时间大于第二个时间 -1第一个时间小于第二个时间 0两个时间相等
	 */
	public static int compare(String DATE1, String DATE2,String formatStr) {
        DateFormat df = new SimpleDateFormat(formatStr);
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {//dt1大于dt2
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {//dt1小于dt2
                return -1;
            } else {//相等
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 2;
    }
	
	/**
	 * 判断当前日期字符串是否合法
	 * @param dateStr 日期字符串
	 * @param formatStr 需要转换的日期格式
	 * @return
	 */
	public static boolean isDateStr(String dateStr,String formatStr){
		//利用java中的SimpleDateFormat类，指定日期格式，注意yyyy,MM大小写
		//这里的日期格式要求javaAPI中有详细的描述，不清楚的话可以下载相关API查看
		SimpleDateFormat format=new SimpleDateFormat(formatStr);
		// 设置日期转化成功标识
		boolean dateflag=true;
		// 这里要捕获一下异常信息
		try{
			Date date = format.parse(dateStr);
		} catch (Exception e){
			return false;
		}
		//成功：true ;失败:false
		return true;
	}
	
	/**
	 * 解析日期字符串，如果月份或天数为个位数字，在前面补充0
	 * @param begindate (日期格式yyyy-MM-dd)
	 * @return
	 */
	public static String initStr(String begindate) {
		String[] dateStr = begindate.split("-");
		String returnStr = dateStr[0]+"-";
		if(Integer.parseInt(dateStr[1]) < 10){
			returnStr += "0" + dateStr[1];
		}else{
			returnStr += dateStr[1];
		}
		returnStr += "-";
		if(Integer.parseInt(dateStr[2]) < 10){
			returnStr += "0" + dateStr[2];
		}else{
			returnStr += dateStr[2];
		}
		return returnStr;
	}
	
	/**
	 * 日期格式字符串转换为日期对象
	 * @param strDate
	 * @return yyyy-MM-dd
	 * @throws ParseException
	 */
    public static Date parse(String strDate){  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return parse(getCurrentDate());
    }  
  
    /**
     * 根据出身日期得到年龄
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static int getAge(Date birthDay){  
        Calendar cal = Calendar.getInstance();  
  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException("生日有误!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
  
        int age = yearNow - yearBirth;  
  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }  
    
    /**
     * 计算两个字符字符串相隔的天数
     * 日期字符串相减
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 间隔天数
     */
    public static int getDaysByTwoSTRDate(String startDate,String endDate){ 
    	Date date1 = parse(startDate);
    	Date date2 = parse(endDate);
    	
    	Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //不同年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年            
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }
            
            return timeDistance + (day2-day1) ;
        }else{//同一年
            return day2-day1;
        }
    }
    
    /**
     * 计算两个字符字符串相隔的月数
     * 日期字符串相减
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 间隔天数
     */
    public static int getMonthByTwoSTRDate(String startDate,String endDate){ 
    	Date date1 = parse(startDate);
    	Date date2 = parse(endDate);
    	
    	Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int month1 = cal1.get(Calendar.MONTH);
        int month2 = cal2.get(Calendar.MONTH);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++){
            	timeDistance += 12;
            }
            return timeDistance + (month2-month1) ;
        }else{//不同年
            return month2-month1;
        }
    }
    
    /**
     * 在日期字符串上加上天数返回结果日期字符串
     * @param dateStr
     * @param days
     * @return
     */
    public static String addDaysToDateStr(String dateStr, int days) {
    	Date date = parse(dateStr);
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		cal.add(Calendar.DATE, days);
		String result = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return result;
	}
    /**
     * 在日期字符串上加上年数返回结果
     * @param dateStr
     * @param days
     * @return
     */
    public static String addYearsToDateStr(String dateStr, int years) {
    	Date date = parse(dateStr);
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		cal.add(Calendar.YEAR, years);
		String result = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return result;
	}
    /**
     * 日期加上月数
     * @param dateStr
     * @param days
     * @return
     */
    public static String addMonthsToDateStr(String dateStr, int month) {
    	Date date = parse(dateStr);
    	Calendar cal = Calendar.getInstance();
        cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		String result = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
		return result;
	}
    /**
     * 得到两个日期间隔小时
     * @param startdate
     * @param enddate
     * @return
     */
    public static long getHoursByTwoDateStr(String startdate,String enddate){
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try
    	{
    	    Date d1 = df.parse(startdate);
    	    Date d2 = df.parse(enddate);
    	    long diff = d2.getTime() - d1.getTime();
    	    long hours = diff / (1000 * 60 * 60);
    	    return hours;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    /**
     * 得到两个日期间隔分钟数
     * @param startdate
     * @param enddate
     * @return
     */
    public static long getMiniusByTwoDateStr(String startdate,String enddate){
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	try
    	{
    	    Date d1 = df.parse(startdate);
    	    Date d2 = df.parse(enddate);
    	    long diff = d2.getTime() - d1.getTime();
    	    long hours = diff / (1000 * 60);
    	    return hours;
    	}catch (Exception e){
    		e.printStackTrace();
    	}
    	return 0;
    }
    
    /**
	 * @see 获取当前时间 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		return date.format(current);
	}
	/**
	 * @see 获取当前日期 yyyy-MM-dd
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		Date current = new Date();
		return date.format(current);
	}
	/**
	 * @see 获取指定时间、指定时间格式串
	 * @return
	 */
	public static String getDateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		if (date == null) {
			return "无";
		}
		return sdf.format(date);
	}
	/**
	 * @see 获取当前时间 指定时间模式
	 * @return
	 */
	public static String getCurrentTime(String pattern) {
		SimpleDateFormat date = new SimpleDateFormat(pattern);
		Date current = new Date();
		return date.format(current);
	}
	/**
	 * @see 将指定时间戳转换时间字符串 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getAppointCurrentTime(Long time) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return date.format(new Date(time * 1000));
	}
	/**
	 * 指定格式指定某天
	 * 
	 * @param pattern
	 * @param num
	 * @return
	 */
	public static String getAppointCurrentTime(String pattern, int num) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, num);
		String date = new SimpleDateFormat(pattern).format(cal.getTime());
		return date;
	}
	
	public static void main(String[] args) {
		//System.out.println(compare_date("2017-09-14","2017-02-14","yyyy-MM-dd"));
//		System.out.println(addDaysToDateStr("2017-12-30",20));
//		System.out.println(getMiniusByTwoDateStr("2018-06-12 16:24:00","2018-12-12 16:32:00"));
	}
}
