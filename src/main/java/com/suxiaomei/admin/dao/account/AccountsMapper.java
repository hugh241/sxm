package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.Accounts;

public interface AccountsMapper {
    int deleteByPrimaryKey(Integer accountsid);

    int insert(Accounts record);

    int insertSelective(Accounts record);

    Accounts selectByPrimaryKey(Integer accountsid);

    int updateByPrimaryKeySelective(Accounts record);

    int updateByPrimaryKey(Accounts record);
}