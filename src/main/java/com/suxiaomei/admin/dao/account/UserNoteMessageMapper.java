package com.suxiaomei.admin.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.account.UserNoteMessage;

public interface UserNoteMessageMapper {
    int deleteByPrimaryKey(Integer usernotemessageid);

    int insert(UserNoteMessage record);

    int insertSelective(UserNoteMessage record);

    UserNoteMessage selectByPrimaryKey(Integer usernotemessageid);

    int updateByPrimaryKeySelective(UserNoteMessage record);

    int updateByPrimaryKey(UserNoteMessage record);
    /**
     * 条件查询消息列表
     * @param condition 查询条件 消息标题，内容
     * @param type 消息类型 1跟进消息 2订单消息 3合同关闭消息 4收款提醒消息
     * @param userid 当前登录用户id
     * @return
     */
	List<UserNoteMessage> findListByCondition(@Param("condition")String condition,@Param("type")int type,@Param("userid")int userid);
}