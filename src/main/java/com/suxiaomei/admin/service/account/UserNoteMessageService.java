package com.suxiaomei.admin.service.account;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.UserNoteMessage;

public interface UserNoteMessageService{
	/**
	 * 根据条件，类型，当前登录账号查询消息列表
	 * 1.企业端消息管理
	 * @param condition 查询条件
	 * @param type 1跟进消息 2订单消息 3合同关闭消息 4收款提醒消息
	 * @param cUser 当前登录账号
	 * @return 消息列表
	 */
	List<UserNoteMessage> findByConditionAndType(String condition, int type, User cUser);
	/**
	 * 根据id设置为已读
	 * 1.企业端消息管理
	 * @param id
	 * @return
	 */
	int updateRead(int id);
}
