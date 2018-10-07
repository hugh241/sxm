package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeePhotoAuditing;

public interface EmployeePhotoAuditingMapper {
    int deleteByPrimaryKey(Integer employeephotoauditingid);

    int insert(EmployeePhotoAuditing record);

    int insertSelective(EmployeePhotoAuditing record);

    EmployeePhotoAuditing selectByPrimaryKey(Integer employeephotoauditingid);

    int updateByPrimaryKeySelective(EmployeePhotoAuditing record);

    int updateByPrimaryKey(EmployeePhotoAuditing record);
}