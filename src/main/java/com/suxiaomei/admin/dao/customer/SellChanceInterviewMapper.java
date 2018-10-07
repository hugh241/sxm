package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.SellChanceInterview;

public interface SellChanceInterviewMapper {
    int deleteByPrimaryKey(Integer sellchanceinterviewid);

    int insert(SellChanceInterview record);

    int insertSelective(SellChanceInterview record);

    SellChanceInterview selectByPrimaryKey(Integer sellchanceinterviewid);

    int updateByPrimaryKeySelective(SellChanceInterview record);

    int updateByPrimaryKey(SellChanceInterview record);
}