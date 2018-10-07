package com.suxiaomei.admin.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;

public interface BusinessMapper {
    int deleteByPrimaryKey(Integer businessid);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Integer businessid);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
    /**
     * 条件分页查询企业列表（包含认证信息、企业用户信息）
     * @param pageNo
     * @param pageSize
     * @param business
     * @return
     */
	List<BusinessExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("business")BusinessExtend business);
	/**
	 * 查询符合条件的企业数量
	 * @param business
	 * @return
	 */
	int findCountByCondition(@Param("business")BusinessExtend business);
	/**
	 * 根据企业id查询企业详细信息
	 * （包括认证信息、企业用户信息、认证家协列表、联系人列表）
	 * @param id
	 * @return
	 */
	BusinessExtend findDetailByBusinessid(Integer businessid);
}