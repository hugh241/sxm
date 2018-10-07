package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.WCLog;

public interface WCLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WCLog record);

    int insertSelective(WCLog record);

    WCLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WCLog record);

    int updateByPrimaryKey(WCLog record);
}