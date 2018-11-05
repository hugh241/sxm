package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;

public interface IsocEmpowerFirmMapper {

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
	/**
	 * 根据家协id，企业id查询该企业在当前家协下的授权信息
	 * @param isocid
	 * @param businessid
	 * @return
	 */
	IsocEmpowerFirm findByIsocidAndBusinessid(@Param("isocid")int isocid,@Param("businessid")Integer businessid);
	/**
	 * 根据企业id查询所有授权该企业的家协下的授权信息
	 * @param businessid
	 * @return
	 */
	List<IsocEmpowerFirm> findByBusinessid(Integer businessid);
	/**
	 * 根据家协id查询家协下的所有授权企业信息
	 * @param isocid
	 * @return
	 */
	List<IsocEmpowerFirm> findByIsocid(Integer isocid);
}