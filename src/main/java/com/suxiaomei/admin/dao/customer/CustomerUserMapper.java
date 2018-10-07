package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerUser;

public interface CustomerUserMapper {
    int deleteByPrimaryKey(Integer customeruserid);

    int insert(CustomerUser record);

    int insertSelective(CustomerUser record);

    CustomerUser selectByPrimaryKey(Integer customeruserid);

    int updateByPrimaryKeySelective(CustomerUser record);

    int updateByPrimaryKey(CustomerUser record);
}