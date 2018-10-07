package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrderEmployeeAssessment;

public interface ContractOrderEmployeeAssessmentMapper {
    int deleteByPrimaryKey(Integer contractorderemployeeassessmentid);

    int insert(ContractOrderEmployeeAssessment record);

    int insertSelective(ContractOrderEmployeeAssessment record);

    ContractOrderEmployeeAssessment selectByPrimaryKey(Integer contractorderemployeeassessmentid);

    int updateByPrimaryKeySelective(ContractOrderEmployeeAssessment record);

    int updateByPrimaryKey(ContractOrderEmployeeAssessment record);
}