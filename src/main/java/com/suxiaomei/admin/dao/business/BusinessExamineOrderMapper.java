package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessExamineOrder;

public interface BusinessExamineOrderMapper {
    int deleteByPrimaryKey(Integer businessexamineorderid);

    int insert(BusinessExamineOrder record);

    int insertSelective(BusinessExamineOrder record);

    BusinessExamineOrder selectByPrimaryKey(Integer businessexamineorderid);

    int updateByPrimaryKeySelective(BusinessExamineOrder record);

    int updateByPrimaryKey(BusinessExamineOrder record);
}