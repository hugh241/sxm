package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocMember;

public interface IsocMemberMapper {
    int deleteByPrimaryKey(Integer isocmemberid);

    int insert(IsocMember record);

    int insertSelective(IsocMember record);

    IsocMember selectByPrimaryKey(Integer isocmemberid);

    int updateByPrimaryKeySelective(IsocMember record);

    int updateByPrimaryKey(IsocMember record);
    /**
     * 根据会员单位id查询会员家协关联
     * @param memberid
     * @return
     */
	IsocMember findByMemberid(Integer memberid);
	/**
	 * 根据企业id查询该企业所有的家协会员关联
	 * @param businessid
	 * @return
	 */
	List<IsocMember> findByBusinessid(Integer businessid);
	/**
	 * 根据家协id和企业id查询该企业在家协下的会员关联记录
	 * @param isocid
	 * @param businessid
	 * @return
	 */
	IsocMember findByIsocidAndBusinessid(@Param("isocid")Integer isocid,@Param("businessid")Integer businessid);
}