package com.suxiaomei.admin.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.account.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    /**
     * 根据用户名查询用户信息
     * @param user
     * @return
     */
	User selectByUsername(String username);
	/**
	 * 根据家协id查询家协用户（一个家协对应一个用户）
	 * @param isocid
	 * @return
	 */
	User findByIsocId(int isocid);
	/**
	 * 根据企业id查询企业管理员账号信息
	 * @param businessid
	 * @return
	 */
	User findByBusinessid(Integer businessid);
	/**
	 * 根据角色id和状态将该角色下的所有用户状态修改为传入的状态
	 * @param roleid
	 * @param status
	 * @return
	 */
	int updateStatusByRoleidAndType(@Param("roleid")int roleid,@Param("status")int status);
	/**
	 * 根据系统id和账号状态查询
	 * @param sxmsystemid
	 * @param status 0已删除 1正常
	 * @return
	 */
	List<User> findNormalUserBySystemidAndTypeAndStatus(@Param("sxmsystemid")int sxmsystemid,@Param("type")int type,@Param("status")Integer status);
	/**
	 * 根据电话号码查询用户
	 * @param fwdh
	 * @return
	 */
	User findByMobile(@Param("mobile")String mobile);
}