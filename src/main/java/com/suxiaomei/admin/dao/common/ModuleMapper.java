package com.suxiaomei.admin.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.Module;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer moduleid);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer moduleid);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
    /**
     * 根据角色id查询该角色的所有菜单
     * @param roleid
     * @return
     */
	List<Module> findByRoleid(int roleid);
	/**
	 * 根据系统id查询系统下的所有模块
	 * @param sxmsystemid
	 * @return
	 */
//	List<Module> findBySxmsystemid(int sxmsystemid);
	/**
	 * 更具角色id查询该角色系统下的所有菜单，并查询出该角色是否对菜单有权限
	 * @param id
	 * @return module List :check is true has right
	 */
	List<Module> findAllByRoleid(int id);
	/**
	 * 根据系统类型（id）查询系统下所有自动添加的菜单
	 * @param sxmsystemid
	 * @return
	 */
	List<Module> findAutomaticBySxmsystemid(int sxmsystemid);
	/**
	 * 根据模块名称和系统类型查询模块
	 * @param url
	 * @param sxmsystemid
	 * @return
	 */
	Module findByUrlAndSxmsystemid(@Param("url")String url,@Param("sxmsystemid")int sxmsystemid);
}