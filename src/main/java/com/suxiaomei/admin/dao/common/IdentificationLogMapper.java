package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.IdentificationLog;

public interface IdentificationLogMapper {
    int deleteByPrimaryKey(Integer identificationlogid);

    int insert(IdentificationLog record);

    int insertSelective(IdentificationLog record);

    IdentificationLog selectByPrimaryKey(Integer identificationlogid);

    int updateByPrimaryKeySelective(IdentificationLog record);

    int updateByPrimaryKey(IdentificationLog record);
}