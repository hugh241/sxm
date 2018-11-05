package com.suxiaomei.admin.service.business;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.util.QueryResult;

public interface BusinessService {
	/**
	 * 条件分页查询企业列表
	 * 1.管理系统企业列表查询 根据认证状态（1.已认证 2未认证 其他：全部） 企业名称fullname查询
	 * @param condition
	 * @return
	 */
	QueryResult<BusinessExtend> findByPageList(String condition);
	/**
	 * 根据企业id查询企业详细信息
	 * 1.管理端企业管理
	 * 2.家协端 全部认证企业管理 详细查询
	 * 3.企业端 企业首页
	 * @param id
	 * @return
	 */
	BusinessExtend findDetailByBusinessid(int id);
	/**
	 * 根据会员单位id查询企业详细信息
	 * 1.家协端 全部会员企业管理 详细信息查询
	 * @param memberid
	 * @return
	 */
	BusinessExtend findDetailByMemberid(int memberid);
	/**
	 * 根据type类型查询认证企业
	 * 1.家协端 授权企业管理
	 * @param condition
	 * @param user
	 * @param type 0为授权的认证企业 1已授权的认证企业
	 * @return
	 */
	QueryResult<Business> findBAuthBusiness(String condition, User user, int type);
	/**
	 * 授权/取消授权
	 * 1.家协端 授权企业管理
	 * @param id 企业id
	 * @param status 1授权 ！1取消授权
	 * @param user 当前登录账号
	 * @return
	 */
	int authBusiness(int id, Integer status, User user);
	/**
	 * 完善企业信息
	 * 1.企业端 完善当前登录的企业信息
	 * @param businessid
	 * @param fullname
	 * @param phone
	 * @param email
	 * @param url
	 * @param address
	 * @param summary
	 * @param path
	 * @return
	 */
	int compalteBusinessInfo(Integer businessid, String fullname, String phone, String email, String url,
			String address, String summary, String path);
}
