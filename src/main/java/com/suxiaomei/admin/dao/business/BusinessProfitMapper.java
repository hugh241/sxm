package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessProfit;

public interface BusinessProfitMapper {
    int deleteByPrimaryKey(Integer businessprofitid);

    int insert(BusinessProfit record);

    int insertSelective(BusinessProfit record);

    BusinessProfit selectByPrimaryKey(Integer businessprofitid);

    int updateByPrimaryKeySelective(BusinessProfit record);

    int updateByPrimaryKey(BusinessProfit record);
}