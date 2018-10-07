package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.Banner;

public interface BannerService {
	/**
	 * 根据类型查询
	 * 1.管理系统
	 * @param type
	 * @return
	 */
	List<Banner> findByType(int type);
	/**
	 * 根据id查询
	 * 1.管理系统
	 * @param id
	 * @return
	 */
	Banner findById(int id);
	/**
	 * 根据传入的id拼接字符串排序
	 * 1.管理系统
	 * @param ids
	 * @return
	 */
	int updateBannerSort(String ids);
	/**
	 * 新增banner
	 * 1.管理系统
	 * @param banner
	 * @return
	 */
	int add(Banner banner);
	/**
	 * 删除banner
	 * 1.管理系统
	 * @param id
	 * @return
	 */
	int delete(int id);
	/**
	 * 修改banner
	 * 1.管理系统
	 * @param banner
	 * @return
	 */
	int update(Banner banner);

}
