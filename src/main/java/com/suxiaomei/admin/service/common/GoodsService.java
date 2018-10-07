package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.common.extend.IsocGoodsOrder;
import com.suxiaomei.admin.util.QueryResult;

public interface GoodsService {
	/**
	 * 保存系统产品到redis中
	 * 1.系统启动运行
	 */
	void updateGoodsListToRedis();
	/**
	 * 根据产品上下架状态查询产品
	 * 1.管理端产品管理
	 * @param status null 查询所有 0查询下架产品 1查询上架产品
	 * @return
	 */
	List<Goods> findAllByStatus(Integer status);
	/**
	 * 新增产品
	 * 1.管理端产品管理
	 * @param goods
	 * @return
	 */
	int addGoods(Goods goods);
	/**
	 * 修改产品
	 * 1.管理端产品管理
	 * @param goods
	 * @return
	 */
	int updateGoods(Goods goods);
	/**
	 * 上下架产品
	 * 1.管理端产品管理
	 * @param id
	 * @return
	 */
	int upDownGoods(int id);
	/**
	 * 根据查询用户和当前登录用户所属系统查询家协购买产品订单列表
	 * 1.管理端产品管理
	 * @param condition 查询条件（家协名称）包含分页信息
	 * @param user （当前登录用户  5家协：只查询该家协购买的产品订单 1管理系统:查询所有家协购买的产品订单）
	 * @return
	 */
	QueryResult<IsocGoodsOrder> findOrdersByConditionAndUserType(String condition, User user);
	/**
	 * 修改家协产品订单状态为通过状态
	 * 1.管理端产品管理
	 * @param id 家协产品订单id
	 * @return
	 */
	int updateIsocExamineOrderStatus(int id);
}
