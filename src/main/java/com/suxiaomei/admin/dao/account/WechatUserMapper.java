package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.WechatUser;

public interface WechatUserMapper {
    int deleteByPrimaryKey(Integer wechatuserid);

    int insert(WechatUser record);

    int insertSelective(WechatUser record);

    WechatUser selectByPrimaryKey(Integer wechatuserid);

    int updateByPrimaryKeySelective(WechatUser record);

    int updateByPrimaryKey(WechatUser record);
}