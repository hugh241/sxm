package com.suxiaomei.admin.service.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.util.QueryResult;

/**
 * 家协
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月20日 下午5:10:54
 */
public interface IsocService {
	/**
	 * 初始化所有家协的token
	 * 1.系统启动运行
	 */
	void updateAllToken();
	/**
	 * 条件分页查询家协列表
	 * 1.管理后台家协管理列表查询
	 * @param condition
	 * @return
	 */
	QueryResult<IsocExtend> findByPageList(String condition);
	/**
	 * 新增家协
	 * 1.管理后台新增家协并为该家协创建登录账号
	 * @param ie
	 * @return
	 */
	int add(IsocExtend ie);
	/**
	 * 修改家协
	 * 1.管理后台家协管理列表查询
	 * @param ie
	 * @return
	 */
	int update(IsocExtend ie);
	/**
	 * 启用/停用家协账号
	 * 1.管理后台家协管理列表查询
	 * @param id
	 * @return
	 */
	int updateStatus(int id);
	/**
	 * 修改家协密码
	 * 1.管理后台家协管理列表查询
	 * @param ie
	 * @return
	 */
	int updatePassword(IsocExtend ie);
	/**
	 * 根据家协id查询家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param isocid
	 * @return
	 */
	List<IsocBusinessDataConfigure> findConfigByIsocid(int isocid);
	/**
	 * 新增家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param config
	 * @return
	 */
	int addConfig(IsocBusinessDataConfigure config);
	/**
	 * 修改家协配置项
	 * 1.管理后台家协管理列表查询
	 * @param config
	 * @return
	 */
	int updateConfig(IsocBusinessDataConfigure config);
	/**
	 * 删除配置项
	 * 1.管理后台家协管理列表查询
	 * @param id
	 * @return
	 */
	int deleteConfig(int id);

}
