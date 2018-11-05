package com.suxiaomei.admin.service.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.entity.isoc.MemberRecord;
import com.suxiaomei.admin.entity.isoc.extend.MemberExtend;
import com.suxiaomei.admin.util.QueryResult;

public interface MemberService {
	/**
	 * 新增会员单位
	 * 1.家协端所有会员管理
	 * 2.企业端提交会员单位申请
	 * @param member
	 * @return
	 */
	int add(Member member);
	/**
	 * 根据当前登录账号，查询已通过审核的会员信息
	 * 1.家协端，全部会员企业管理 根据当前登录家协id分页查询
	 * @param condition
	 * @param cUser 
	 * @return
	 */
	QueryResult<MemberExtend> findPassMembersByPage(String condition, User cUser);
	/**
	 * 根据会员单位id查询会员申请的审核记录
	 * 1.家协端 全部会员企业管理 详细信息查询
	 * @param memberid
	 * @return
	 */
	List<MemberRecord> findMemberRecordByMemberid(int memberid);
	/**
	 * 修改会员单位
	 * 1.家协端 全部会员企业管理
	 * @param member
	 * @return
	 */
	int update(Member member);
	/**
	 * 删除会员单位
	 * 1.家协端 全部会员企业管理
	 * @param memberid
	 * @return
	 */
	int delete(int memberid);
	/**
	 * 根据当前登录账号，查询符合条件的会员申请记录
	 * 1.家协端 会员申请列表查询
	 * 2.企业端提交会员单位申请
	 * @param condition
	 * @param user
	 * @return
	 */
	QueryResult<MemberExtend> findAllMembersByCondition(String condition, User user);
	/**
	 * 通过或驳回申请
	 * 1.家协端 会员申请列表
	 * @param member
	 * @return
	 */
	int updatePassOrRejectApply(Member member);
	/**
	 * 重新编辑提交会员申请
	 * 1.企业端 会员申请管理
	 * @param member
	 * @return
	 */
	int reApply(Member member);

}
