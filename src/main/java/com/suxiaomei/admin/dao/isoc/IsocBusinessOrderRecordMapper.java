package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;

public interface IsocBusinessOrderRecordMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderrecordid);

    int insert(IsocBusinessOrderRecord record);

    int insertSelective(IsocBusinessOrderRecord record);

    IsocBusinessOrderRecord selectByPrimaryKey(Integer isocbusinessorderrecordid);

    int updateByPrimaryKeySelective(IsocBusinessOrderRecord record);

    int updateByPrimaryKey(IsocBusinessOrderRecord record);
}