package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerBespeak;

public interface CustomerBespeakMapper {
    int deleteByPrimaryKey(Integer customerbespeakid);

    int insert(CustomerBespeak record);

    int insertSelective(CustomerBespeak record);

    CustomerBespeak selectByPrimaryKey(Integer customerbespeakid);

    int updateByPrimaryKeySelective(CustomerBespeak record);

    int updateByPrimaryKey(CustomerBespeak record);
}