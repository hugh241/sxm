package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.SellChance;

public interface SellChanceMapper {
    int deleteByPrimaryKey(Integer sellchanceid);

    int insert(SellChance record);

    int insertSelective(SellChance record);

    SellChance selectByPrimaryKey(Integer sellchanceid);

    int updateByPrimaryKeySelective(SellChance record);

    int updateByPrimaryKey(SellChance record);
}