package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocLog;

public interface IsocLogMapper {
    int deleteByPrimaryKey(Integer isoclogid);

    int insert(IsocLog record);

    int insertSelective(IsocLog record);

    IsocLog selectByPrimaryKey(Integer isoclogid);

    int updateByPrimaryKeySelective(IsocLog record);

    int updateByPrimaryKey(IsocLog record);
}