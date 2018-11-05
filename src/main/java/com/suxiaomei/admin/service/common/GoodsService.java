package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.extend.BusinessExamineOrderExtend;
import com.suxiaomei.admin.entity.business.extend.BusinessGoodsExtend;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;
import com.suxiaomei.admin.entity.isoc.IsocGoods;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;
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
	QueryResult<IsocExamineOrder> findOrdersByConditionAndUserType(String condition, User user);
	/**
	 * 修改家协产品订单状态为通过状态
	 * 1.管理端产品管理
	 * @param id 家协产品订单id
	 * @return
	 */
	int updateIsocExamineOrderStatus(int id);
	/**
	 * 查询当前家协购买的所有家协产品(数量等于系统产品数量，如果没有该买系统产品，家协产品信息为空)
	 * 1.家协端 家协产品管理
	 * @param user
	 * @return
	 */
	List<IsocGoodsExtend> findAllGoodsForIsoc(User user);
	/**
	 * 家协购买产品，生成系统产品购买订单
	 * 1.家协端 家协产品管理
	 * @param order
	 * @param user
	 * @return
	 */
	int addIsocExamineOrder(IsocExamineOrder order, User user);
	/**
	 * 删除家协购买系统产品订单
	 * 1.家协端 家协产品管理
	 * @param id
	 * @return
	 */
	int deleteIsocExamineOrder(int id);
	/**
	 * 查询当前家协已购买的所有家协产品(系统产品与家协产品一一对应)
	 * 1.家协端 家协产品销售
	 * @param user
	 * @return
	 */
	List<IsocGoodsExtend> findIsocGoodsForIsoc(User user);
	/**
	 * 修改家协产品价格
	 * 1.家协端 家协产品销售
	 * @param goods
	 * @return
	 */
	int updateIsocGoodsPrice(IsocGoods goods);
	/**
	 * 条件查询企业购买产品订单列表
	 * 1.家协端 家协产品销售管理
	 * @param condition
	 * @param user
	 * @return
	 */
	QueryResult<BusinessExamineOrderExtend> findBusinessExamineOrder(String condition, User user);
	/**
	 * 通过企业购买家协产品订单申请
	 * 1.家协端 家协产品销售管理
	 * @param businessexamineorderid
	 * @return
	 */
	int passBusinessExamineOrder(int businessexamineorderid);
	/**
	 * 根据家协id和企业id查询当前企业已购买和未购买的家协产品信息，未购买的企业产品信息返回为空
	 * 1.企业端 家政人员认证申请管理
	 * @param isocid
	 * @param businessid
	 * @return
	 */
	List<BusinessGoodsExtend> findBusinessGoodsByIsocidAndBusinessidForBusinesss(int isocid, Integer businessid);
}
