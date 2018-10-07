package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.AccountItem;

public interface AccountItemMapper {
    int deleteByPrimaryKey(Integer accountitemid);

    int insert(AccountItem record);

    int insertSelective(AccountItem record);

    AccountItem selectByPrimaryKey(Integer accountitemid);

    int updateByPrimaryKeySelective(AccountItem record);

    int updateByPrimaryKey(AccountItem record);
}