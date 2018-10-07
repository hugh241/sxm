package com.suxiaomei.admin.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value="classpath:global.properties",encoding ="utf-8")
public class GlobalConfig {
	/**
	 * 是否跟新redis 
	 * true|false
	 */
	@Value("${redis.update}")
	public String redisupdate;
	/**
	 * 省市县
	 */
	@Value("${redis.provinceCityCounty}")
	public String provinceCityCounty;
	/**
	 * 省
	 */
	@Value("${redis.province}")
	public String redisProvince;
	/**
	 * 市
	 */
	@Value("${redis.city}")
	public String redisCity;
	/**
	 * 区县
	 */
	@Value("${redis.county}")
	public String redisCounty;
	/**
	 * 系统产品
	 */
	@Value("${redis.goods}")
	public String redisGoods;
	/**
	 * 系统
	 */
	@Value("${redis.sxmsystem}")
	public String redisSxmsystem;
	/**
	 * 原图地址
	 */
	@Value("${UPLOADPATH_ORIGINAL}")
	public String UPLOADPATH_ORIGINAL;
	/**
	 * 电脑板地址
	 */
	@Value("${UPLOADPATH_PC}")
	public String UPLOADPATH_PC;
	/**
	 * 手机版地址
	 */
	@Value("${UPLOADPATH_MOBILE}")
	public String UPLOADPATH_MOBILE;
	
	@Value("${LOCALUPLOADPATH_ORIGINAL}")
	public String LOCALUPLOADPATH_ORIGINAL;
	
	@Value("${LOCALUPLOADPATH_PC}")
	public String LOCALUPLOADPATH_PC;
	
	@Value("${LOCALUPLOADPATH_MOBILE}")
	public String LOCALUPLOADPATH_MOBILE;
	/**
	 * 登录有效期
	 */
	@Value("${USERINFOSAVETIME}")
	public long USERINFOSAVETIME;
	
	@Value("${INT_ISOCNO}")
	public int INT_ISOCNO;
	
	@Value("${INT_BUSINESS}")
	public int INT_BUSINESS;
	
	@Value("${INT_SXM}")
	public int INT_SXM;
	
	@Value("${STR_MANAGER}")
	public String STR_MANAGER;
	
	@Value("${STR_ISOCROLEDESC}")
	public String STR_ISOCROLEDESC;
	
	@Value("${STR_BUSINESSROLEDESC}")
	public String STR_BUSINESSROLEDESC;
}
