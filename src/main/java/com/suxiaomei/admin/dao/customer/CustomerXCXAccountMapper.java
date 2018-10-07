package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerXCXAccount;

public interface CustomerXCXAccountMapper {
    int deleteByPrimaryKey(Integer customerxcxaccountid);

    int insert(CustomerXCXAccount record);

    int insertSelective(CustomerXCXAccount record);

    CustomerXCXAccount selectByPrimaryKey(Integer customerxcxaccountid);

    int updateByPrimaryKeySelective(CustomerXCXAccount record);

    int updateByPrimaryKey(CustomerXCXAccount record);
}