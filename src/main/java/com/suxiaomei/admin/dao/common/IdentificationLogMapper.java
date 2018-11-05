package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.IdentificationLog;

public interface IdentificationLogMapper {
    int deleteByPrimaryKey(Integer identificationlogid);

    int insert(IdentificationLog record);

    int insertSelective(IdentificationLog record);

    IdentificationLog selectByPrimaryKey(Integer identificationlogid);

    int updateByPrimaryKeySelective(IdentificationLog record);

    int updateByPrimaryKey(IdentificationLog record);
    /**
     * 根据员工工种查询对改工种的所有操作记录
     * 根据创建时间降序排序
     * @param employeepositionid 员工工种id
     * @return
     */
	List<IdentificationLog> findByEmployeepositionid(Integer employeepositionid);
}