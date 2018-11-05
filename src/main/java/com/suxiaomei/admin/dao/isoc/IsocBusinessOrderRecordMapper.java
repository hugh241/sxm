package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;

public interface IsocBusinessOrderRecordMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderrecordid);

    int insert(IsocBusinessOrderRecord record);

    int insertSelective(IsocBusinessOrderRecord record);

    IsocBusinessOrderRecord selectByPrimaryKey(Integer isocbusinessorderrecordid);

    int updateByPrimaryKeySelective(IsocBusinessOrderRecord record);

    int updateByPrimaryKey(IsocBusinessOrderRecord record);
    /**
     * 根据认证订单id查询认证记录
     * @param isocbusinessorderid
     * @return
     */
	List<IsocBusinessOrderRecord> findByIsocbusinessidorderid(int isocbusinessorderid);
}