package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocIdentificationBusiness;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;

public interface IsocIdentificationBusinessMapper {
    int deleteByPrimaryKey(Integer isocidentificationbusinessid);

    int insert(IsocIdentificationBusiness record);

    int insertSelective(IsocIdentificationBusiness record);

    IsocIdentificationBusiness selectByPrimaryKey(Integer isocidentificationbusinessid);

    int updateByPrimaryKeySelective(IsocIdentificationBusiness record);

    int updateByPrimaryKey(IsocIdentificationBusiness record);
    /**
     * 根据企业id查询企业所有家协认证列表
     * @param businessid
     * @return
     */
    List<IsocIdentificationBusinessExtend> findByBusinessid(Integer businessid);
    /**
     * 根据家协id和企业id查询出当前企业在该家协的认证信息
     * @param isocid
     * @param businessid
     * @return
     */
	IsocIdentificationBusiness findByIsocidAndBusinessid(@Param("isocid")Integer isocid,@Param("businessid")Integer businessid);
	/**
	 * 根据条件分页查询企业认证关联信息
	 * @param pageNo 索引
	 * @param pageSize 每页大小
	 * @param isoc 查询条件
	 * @return 分页列表
	 */
	List<IsocIdentificationBusinessExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("iib")IsocIdentificationBusinessExtend iib);
	/**
	 * 根据条件查询总数
	 * @param isoc
	 * @return
	 */
	Integer findCountByCondition(@Param("iib")IsocIdentificationBusinessExtend iib);
}