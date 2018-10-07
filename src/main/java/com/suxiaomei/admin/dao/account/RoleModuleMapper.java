package com.suxiaomei.admin.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.account.RoleModule;

public interface RoleModuleMapper {
    int deleteByPrimaryKey(Integer rolemoduleid);


    int insertSelective(RoleModule record);

    RoleModule selectByPrimaryKey(Integer rolemoduleid);

    int updateByPrimaryKeySelective(RoleModule record);

    int updateByPrimaryKey(RoleModule record);
    /**
     * 根据角色id，模块名称，系统类型查询角色模块关联记录
     * @param roleid
     * @param module
     * @param type
     * @return
     */
	RoleModule findByRoleidAndModulenameAndSxmsystemtype(@Param("roleid")int roleid,@Param("module")String module,@Param("type")int type);
	/**
	 * 为当前角色添加该角色所属系统下的所有自动功能模块
	 * @param roleid
	 */
	int insertByRoleidAndSxmsystemid(@Param("roleid")int roleid);
	/**
	 * 根据角色id,模块id删除关联
	 * @param roleid
	 * @return
	 */
	int deleteRoleModule(@Param("roleid")int roleid,@Param("moduleid")int moduleid);
	/**
	 * 根据角色id查询角色所有模块
	 * @param roleid
	 * @return
	 */
	List<RoleModule> getByRoleid(int roleid);
	/**
	 * 为角色模块添加关联
	 * @param record
	 * @return
	 */
    int insert(RoleModule record);
}