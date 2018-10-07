package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.Tools;
import com.suxiaomei.admin.entity.customer.FamilyMember;
import com.suxiaomei.admin.entity.customer.FamilyMemberTools;
import com.suxiaomei.admin.entity.customer.extend.FamilyMemberToolsExtend;

public interface FamilyMemberToolsService {
	/**
	 * 查询系统成员列表
	 * 1.管理系统
	 * @return
	 */
	List<FamilyMember> findFamilyMemberList();
	/**
	 * 查询所有工具列表
	 * 1.管理系统
	 * @return
	 */
	List<Tools> findToolsList();
	/**
	 * 查询系统成员工具关联列表
	 * 1.管理系统
	 * @return
	 */
	List<FamilyMemberToolsExtend> findList();
	/**
	 * 系只能管理
	 * 1.管理系统
	 * @param familyMemberTools
	 * @return
	 */
	int add(FamilyMemberTools familyMemberTools);
	/**
	 * 删除关联
	 * 1.管理系统
	 * @param id
	 * @return
	 */
	int delete(int id);

}
