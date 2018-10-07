package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.AssessmentDetail;

public interface AssessmentDetailMapper {
    int deleteByPrimaryKey(Integer assessmentdetailid);

    int insert(AssessmentDetail record);

    int insertSelective(AssessmentDetail record);

    AssessmentDetail selectByPrimaryKey(Integer assessmentdetailid);

    int updateByPrimaryKeySelective(AssessmentDetail record);

    int updateByPrimaryKey(AssessmentDetail record);
}