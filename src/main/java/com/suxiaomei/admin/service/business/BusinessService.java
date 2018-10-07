package com.suxiaomei.admin.service.business;

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
	 * @param id
	 * @return
	 */
	BusinessExtend findDetailByBusinessid(int id);
}
