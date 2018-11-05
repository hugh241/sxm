package com.suxiaomei.admin.common;

import java.util.List;

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
	/**
	 * 原图本地地址目录
	 */
	@Value("${LOCALUPLOADPATH_ORIGINAL}")
	public String LOCALUPLOADPATH_ORIGINAL;
	/**
	 * pc版本地地址目录
	 */
	@Value("${LOCALUPLOADPATH_PC}")
	public String LOCALUPLOADPATH_PC;
	/**
	 * 手机版本地地址目录
	 */
	@Value("${LOCALUPLOADPATH_MOBILE}")
	public String LOCALUPLOADPATH_MOBILE;
	/**
	 * 有效期（分钟）
	 * 0登录有效期
	 * 1验证码有效期
	 */
	@Value("#{'${TIMESTAMP}'.split(',')}")
	public List<Long> TIMESTAMP;
	/**
	 * 家协类型编号
	 */
	@Value("${INT_ISOCNO}")
	public int INT_ISOCNO;
	/**
	 * 企业类型编号
	 */
	@Value("${INT_BUSINESS}")
	public int INT_BUSINESS;
	/**
	 * 苏小妹类型编号
	 */
	@Value("${INT_SXM}")
	public int INT_SXM;
	/**
	 * 管理员
	 */
	@Value("${STR_MANAGER}")
	public String STR_MANAGER;
	/**
	 * 自动分配的家协管理员
	 */
	@Value("${STR_ISOCROLEDESC}")
	public String STR_ISOCROLEDESC;
	/**
	 * 自动分配的企业管理员
	 */
	@Value("${STR_BUSINESSROLEDESC}")
	public String STR_BUSINESSROLEDESC;
	/**
	 * 1渠道 
	 */
	@Value("${INT_BUSINESS_P_TRAFFIC}")
	public int INT_BUSINESS_P_TRAFFIC;
	/**
	 * 2 销售机会 
	 */
	@Value("${INT_BUSINESS_P_SALESLEADS}")
	public int INT_BUSINESS_P_SALESLEADS;
	/**
	 * 3 合同类型 
	 */
	@Value("${INT_BUSINESS_P_CONTRACTTYPE}")
	public int INT_BUSINESS_P_CONTRACTTYPE;
	/**
	 * 4 工作组 
	 */
	@Value("${INT_BUSINESS_P_WORKGROUP}")
	public int INT_BUSINESS_P_WORKGROUP;
	/**
	 * 5移出原因 
	 */
	@Value("${INT_BUSINESS_P_REMOVEREASON}")
	public int INT_BUSINESS_P_REMOVEREASON;
	/**
	 * 6输单原因 
	 */
	@Value("${INT_BUSINESS_P_LOSEREASON}")
	public int INT_BUSINESS_P_LOSEREASON;
	/**
	 * 7移出天数配置（每个系统最多1条）
	 */
	@Value("${INT_BUSINESS_P_REMOVEDAYS}")
	public int INT_BUSINESS_P_REMOVEDAYS;
	/**
	 * 8渠道来源 
	 */
	@Value("${INT_BUSINESS_P_SOURCE}")
	public int INT_BUSINESS_P_SOURCE;
	/**
	 * 9增员奖励分层层级 
	 */
	@Value("${INT_BUSINESS_P_ZENGYUANCJ}")
	public int INT_BUSINESS_P_ZENGYUANCJ;
	/**
	 * 10转介绍奖励分层层级 
	 */
	@Value("${INT_BUSINESS_P_ZHUANJIESHAOCJ}")
	public int INT_BUSINESS_P_ZHUANJIESHAOCJ;
	/**
	 * 11.收款渠道
	 */
	@Value("${INT_BUSINESS_P_RECEIPTTRAFFIC}")
	public int INT_BUSINESS_P_RECEIPTTRAFFIC;
	/**
	 * 客户,护理员,其他
	 */
	@Value("#{'${STR_BUSINESS_P_TRAFFIC}'.split(',')}")
	public List<String> STR_BUSINESS_P_TRAFFIC;
	/**
	 * 企业认证申请模块名称
	 */
	@Value("#{'${STR_B_BAUTH}'.split(',')}")
	public List<String> STR_B_BAUTH;
	/**
	 * "bsaudit";申请认证阿姨 "bgoods"购买产品权限 模块名称
	 */
	@Value("#{'${STR_B_SEAUDIT_MODULENAME}'.split(',')}")
	public List<String> STR_B_SEAUDIT_MODULENAME;
	/**
	 * "bcaudit";审核认证阿姨 模块名称
	 */
	@Value("#{'${STR_B_CEAUDIT_MODULENAME}'.split(',')}")
	public List<String> STR_B_CEAUDIT_MODULENAME;
	/**
	 * 增员提成默认天数
	 */
	@Value("${INT_TCTS_ZY}")
	public int INT_TCTS_ZY;
	/**
	 * 转介绍提成默认天数
	 */
	@Value("${INT_TCTS_ZJS}")
	public int INT_TCTS_ZJS;
	/**
	 * 0一般机构 1阿姨 2客户 3公司 4其他
	 */
	@Value("#{'${INT_INTRODUCER_TYPE}'.split(',')}")
	public List<Integer> INT_INTRODUCER_TYPE;
	/**
	 * 0 介绍人配置 1渠道配置
	 */
	@Value("#{'${INT_INTRODUCER_CONFIG_TYPE}'.split(',')}")
	public List<Integer> INT_INTRODUCER_CONFIG_TYPE;
	/**
	 * 是否进行背景调查
	 */
	@Value("${ISBACKCHECK}")
	public boolean ISBACKCHECK;
	/**
	 * 是否发送短信
	 */
	@Value("${ISSENDSMS}")
	public boolean ISSENDSMS;
	/**
	 * 背调地址
	 */
	@Value("${EMPLOYEE_BACKGROUND_CHECK_URL}")
	public String EMPLOYEE_BACKGROUND_CHECK_URL;
	/**
	 * 背调userid
	 */
	@Value("${EMPLOYEE_BACKGROUND_CHECK_USERID}")
	public String EMPLOYEE_BACKGROUND_CHECK_USERID;
	/**
	 * 背调账号
	 */
	@Value("${EMPLOYEE_BACKGROUND_CHECK_PASSWORD}")
	public String EMPLOYEE_BACKGROUND_CHECK_PASSWORD;
	/**
	 * 背调密码
	 */
	@Value("${EMPLOYEE_BACKGROUND_CHECK_PRODUCTID}")
	public String EMPLOYEE_BACKGROUND_CHECK_PRODUCTID;
	/**
	 * 微信接口：获取二维码地址
	 */
	@Value("${URL_QRCODE}")
	public String URL_QRCODE;
	/**
	 * 护理员默认头像地址
	 */
	@Value("${URL_DEFAULT_PORTRAIT}")
	public String URL_DEFAULT_PORTRAIT;
	/**
	 * 手机验证码常量
	 * telcodeLogin登录验证码保存常量
	 */
	@Value("#{'${STR_TELCODE}'.split(',')}")
	public List<String> STR_TELCODE;
	/**
	 * 短信接口 参数
	 * URL、USERNAME、KEY、cgid
	 */
	@Value("#{'${STR_SMS}'.split(',')}")
	public List<String> STR_SMS;
	/**
	 * 短信接口发送消息内容
	 */
	@Value("#{'${STR_SMS_MSG}'.split(',')}")
	public List<String> STR_SMS_MSG;
}
