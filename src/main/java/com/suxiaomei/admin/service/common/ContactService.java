package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.account.Contact;
import com.suxiaomei.admin.entity.account.User;

public interface ContactService {
	/**
	 * 根据当前登录账号查询改账号所属系统下的所有联系人
	 * 1.家协端联系人管理
	 * 2.企业端 联系人管理
	 * @param user
	 * @return
	 */
	List<Contact> findAll(User user);
	/**
	 * 根据当前登录账号，联系人基本信息新增联系人
	 * 1.家协端联系人管理
	 * @param contact
	 * @param user
	 * @return
	 */
	int add(Contact contact, User user);
	/**
	 * 修改联系人
	 * 1.家协端联系人管理
	 * @param contact
	 * @return
	 */
	int update(Contact contact);
	/**
	 * 根据联系人id删除联系人
	 * 1.家协端联系人管理
	 * @param id
	 * @return
	 */
	int delete(int id);

}
