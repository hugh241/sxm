package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.XCXAccount;

public interface XCXAccountMapper {
    int deleteByPrimaryKey(Integer xcxaccountid);

    int insert(XCXAccount record);

    int insertSelective(XCXAccount record);

    XCXAccount selectByPrimaryKey(Integer xcxaccountid);

    int updateByPrimaryKeySelective(XCXAccount record);

    int updateByPrimaryKey(XCXAccount record);
}