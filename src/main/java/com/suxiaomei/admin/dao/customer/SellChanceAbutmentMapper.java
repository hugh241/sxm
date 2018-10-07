package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.SellChanceAbutment;

public interface SellChanceAbutmentMapper {
    int deleteByPrimaryKey(Integer sellchanceabutmentid);

    int insert(SellChanceAbutment record);

    int insertSelective(SellChanceAbutment record);

    SellChanceAbutment selectByPrimaryKey(Integer sellchanceabutmentid);

    int updateByPrimaryKeySelective(SellChanceAbutment record);

    int updateByPrimaryKey(SellChanceAbutment record);
}