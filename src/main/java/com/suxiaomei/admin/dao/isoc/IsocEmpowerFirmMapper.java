package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;

public interface IsocEmpowerFirmMapper {
    int deleteByPrimaryKey(Integer isocempowerfirmid);

    int insert(IsocEmpowerFirm record);

    int insertSelective(IsocEmpowerFirm record);

    IsocEmpowerFirm selectByPrimaryKey(Integer isocempowerfirmid);

    int updateByPrimaryKeySelective(IsocEmpowerFirm record);

    int updateByPrimaryKey(IsocEmpowerFirm record);
    /**
     * 查询家协本身的授权单位
     * @param isocid
     * @return
     */
	IsocEmpowerFirm findSelfFirmByIsocid(Integer isocid);
}