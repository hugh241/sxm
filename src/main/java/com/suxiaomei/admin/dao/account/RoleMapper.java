package com.suxiaomei.admin.dao.account;

import java.util.List;

import com.suxiaomei.admin.entity.account.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    /**
     * 根据角色查询角色列表
     * @param role
     * @return
     */
	List<Role> findByRole(Role role);
}