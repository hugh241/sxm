package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.entity.isoc.extend.MemberExtend;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
    /**
     * 根据企业id和家协id查询当前企业在该家协下已通过或正在申请的会员记录
     * @param businessid
     * @param isocid
     * @return
     */
	Member findApplyingOrPassApplyByBusinessidAndIsocid(@Param("businessid")Integer businessid,@Param("isocid")int isocid);
	/**
	 * 根据条件分页查询会员信息列表
	 * @param pageNo
	 * @param pageSize
	 * @param member
	 * @return
	 */
	List<MemberExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("member")Member member);
	/**
	 * 根据条件查询数量
	 * @param member
	 * @return
	 */
	Integer findCountByCondition(@Param("member")Member member);
	/**
	 * 根据企业id查询企业所有家协的会员信息
	 * @param businessid
	 * @return
	 */
	List<MemberExtend> findByBusinessid(Integer businessid);
}