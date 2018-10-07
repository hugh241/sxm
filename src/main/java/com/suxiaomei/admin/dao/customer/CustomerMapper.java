package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer customerid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer customerid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
}