package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;

public interface IsocBusinessDataConfigureMapper {
    int deleteByPrimaryKey(Integer isocbusinessdataconfigureid);

    int insert(IsocBusinessDataConfigure record);

    int insertSelective(IsocBusinessDataConfigure record);

    IsocBusinessDataConfigure selectByPrimaryKey(Integer isocbusinessdataconfigureid);

    int updateByPrimaryKeySelective(IsocBusinessDataConfigure record);

    int updateByPrimaryKey(IsocBusinessDataConfigure record);
    /**
     * 根据家协id，配置类型查询家协配置项
     * @param isocid 家协id
     * @param type 配置类型 null 查询所有配置  0企业认证项配置 1护理员认证项配置
     * @return
     */
	List<IsocBusinessDataConfigure> findByIsocid(@Param("isocid")int isocid,@Param("type")Integer type);
}