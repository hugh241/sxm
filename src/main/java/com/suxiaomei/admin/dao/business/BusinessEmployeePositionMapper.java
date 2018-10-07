package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessEmployeePosition;

public interface BusinessEmployeePositionMapper {
    int deleteByPrimaryKey(Integer businessemployeepositionid);

    int insert(BusinessEmployeePosition record);

    int insertSelective(BusinessEmployeePosition record);

    BusinessEmployeePosition selectByPrimaryKey(Integer businessemployeepositionid);

    int updateByPrimaryKeySelective(BusinessEmployeePosition record);

    int updateByPrimaryKey(BusinessEmployeePosition record);
}