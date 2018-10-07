package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.SellChanceSchedule;

public interface SellChanceScheduleMapper {
    int deleteByPrimaryKey(Integer sellchancescheduleid);

    int insert(SellChanceSchedule record);

    int insertSelective(SellChanceSchedule record);

    SellChanceSchedule selectByPrimaryKey(Integer sellchancescheduleid);

    int updateByPrimaryKeySelective(SellChanceSchedule record);

    int updateByPrimaryKey(SellChanceSchedule record);
}