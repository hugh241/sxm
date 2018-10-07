package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.AssessmentImg;

public interface AssessmentImgMapper {
    int deleteByPrimaryKey(Integer assessmentimgid);

    int insert(AssessmentImg record);

    int insertSelective(AssessmentImg record);

    AssessmentImg selectByPrimaryKey(Integer assessmentimgid);

    int updateByPrimaryKeySelective(AssessmentImg record);

    int updateByPrimaryKey(AssessmentImg record);
}