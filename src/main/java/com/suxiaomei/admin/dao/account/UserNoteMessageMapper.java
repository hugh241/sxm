package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.UserNoteMessage;

public interface UserNoteMessageMapper {
    int deleteByPrimaryKey(Integer usernotemessageid);

    int insert(UserNoteMessage record);

    int insertSelective(UserNoteMessage record);

    UserNoteMessage selectByPrimaryKey(Integer usernotemessageid);

    int updateByPrimaryKeySelective(UserNoteMessage record);

    int updateByPrimaryKey(UserNoteMessage record);
}