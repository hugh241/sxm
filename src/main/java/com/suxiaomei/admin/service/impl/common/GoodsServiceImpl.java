package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.business.BusinessExamineOrderMapper;
import com.suxiaomei.admin.dao.business.BusinessGoodsMapper;
import com.suxiaomei.admin.dao.common.GoodsMapper;
import com.suxiaomei.admin.dao.isoc.IsocExamineOrderMapper;
import com.suxiaomei.admin.dao.isoc.IsocGoodsMapper;
import com.suxiaomei.admin.dao.isoc.IsocOrderGoodsMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.BusinessGoods;
import com.suxiaomei.admin.entity.business.extend.BusinessExamineOrderExtend;
import com.suxiaomei.admin.entity.business.extend.BusinessGoodsExtend;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;
import com.suxiaomei.admin.entity.isoc.IsocGoods;
import com.suxiaomei.admin.entity.isoc.IsocOrderGoods;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;
import com.suxiaomei.admin.response.Dict;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.Util;
import com.suxiaomei.admin.util.redis.RedisUtil;

import net.sf.json.JSONObject;
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private IsocExamineOrderMapper isocExamineOrderDao;
	@Autowired
	private IsocOrderGoodsMapper isocOrderGoodsDao;
	@Autowired
	private IsocGoodsMapper isocGoodsDao;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private GlobalConfig config;
	@Autowired
	private BusinessExamineOrderMapper businessExamineOrderDao;
	@Autowired
	private BusinessGoodsMapper businessGoodsDao;
	
	@Override
	public void updateGoodsListToRedis() {
		List<Dict> goodsList = goodsDao.findAllUP();
		RedisUtil.setList(redisTemplate,config.redisGoods,goodsList);
	}

	@Override
	public List<Goods> findAllByStatus(Integer status) {
		return goodsDao.findAllByStatus(status);
	}

	@Override
	public int addGoods(Goods g) {
		//查询产品工种是否存在
		Goods goods = goodsDao.findByPositionId(g.getPositionid());
		if(goods != null){//工种对应的产品已存在
			return 457;
		}
		goodsDao.insert(g);
		updateGoodsListToRedis();
		return 1;
	}

	@Override
	public int updateGoods(Goods g) {
		Goods goods = goodsDao.selectByPrimaryKey(g.getGoodsid());
		if(goods == null) {
			return 426;
		}
		goodsDao.updateByPrimaryKeySelective(g);
		updateGoodsListToRedis();
		return 1;
	}

	@Override
	public int upDownGoods(int id) {
		Goods goods = goodsDao.selectByPrimaryKey(id);
		if(goods == null) {
			return 426;
		}
		return goodsDao.updateGoodsStatus(id,Math.abs(goods.getStatus()-1));
	}

	@Override
	public QueryResult<IsocExamineOrder> findOrdersByConditionAndUserType(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		IsocExamineOrder order = new IsocExamineOrder();
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("createtime")){
				order.setCreatetime(whereObj.getString("createtime"));
			}
			if(user.getRole().getType() == config.INT_ISOCNO){//家协查询
				order.setIsocid(user.getRole().getRelationid());
			}
			if(whereObj.containsKey("name")){
				order.setIsocname(whereObj.getString("name"));
			}
		}
		QueryResult<IsocExamineOrder> orderQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		orderQ.setList(isocExamineOrderDao.findByPageList((orderQ.getPageIndex()-1)*orderQ.getPageSize(),orderQ.getPageSize(),order));
		orderQ.setTotalRow(isocExamineOrderDao.findCountByCondition(order));
		return orderQ;
	}

	@Override
	public int updateIsocExamineOrderStatus(int id) {
		IsocExamineOrder ieo = isocExamineOrderDao.selectByPrimaryKey(id);
		if(ieo == null || ieo.getOrderstatus() != 0){
			return 426;
		}
		ieo.setOrderstatus(1);
		ieo.setPaytime(DateUtil.getCurrentTime());
		isocExamineOrderDao.updateIsocExamineOrderStatus(ieo);//修改订单状态为通过状态
		/*
		 * 为家协添加购买数量
		 */
		//查询出该订单下的所有产品
		List<IsocOrderGoods> ogList = isocOrderGoodsDao.findByIsocexamineorderid(ieo.getIsocexamineorderid());
		for (int i = 0;ogList != null && i < ogList.size(); i++) {
			//查询提交该订单的家协是否购买过当前产品
			IsocGoods isocGoods = isocGoodsDao.findByIsocidAndGoodsid(ieo.getIsocid(),ogList.get(i).getGoodsid());
			if(isocGoods == null){
				isocGoods = new IsocGoods();
				isocGoods.setIsocid(ieo.getIsocid());
				isocGoods.setGoodsid(ogList.get(i).getGoodsid());
				isocGoods.setPrice(ogList.get(i).getUnitprice());
				isocGoods.setTotal(ogList.get(i).getNum());
				isocGoodsDao.insertSelective(isocGoods);
			}else{
				isocGoods.setTotal(isocGoods.getTotal()+ogList.get(i).getNum());
				isocGoodsDao.updateByPrimaryKeySelective(isocGoods);
			}
		}
		return 1;
	}

	@Override
	public List<IsocGoodsExtend> findAllGoodsForIsoc(User user) {
		List<IsocGoodsExtend> list = isocGoodsDao.findAllGoodsByIsocid(user.getRole().getRelationid());
		return list;
	}

	@Override
	public int addIsocExamineOrder(IsocExamineOrder order, User user) {
		IsocExamineOrder ieo = new IsocExamineOrder();
		ieo.setOrdernum(Util.getOrderNo());
		ieo.setIsocid(user.getRole().getRelationid());
		for (int i = 0;order.getIsocOrderGoods() != null && i < order.getIsocOrderGoods().size(); i++) {
			order.getIsocOrderGoods().get(i).setGoods(goodsDao.selectByPrimaryKey(order.getIsocOrderGoods().get(i).getGoodsid()));
			ieo.setTotalprice(order.getIsocOrderGoods().get(i).getGoods().getPrice()*order.getIsocOrderGoods().get(i).getNum()+ieo.getTotalprice());//计算产品总价
		}
		isocExamineOrderDao.insert(ieo);
		//为订单下的每个产品增加购买详细
		for (int i = 0;order.getIsocOrderGoods() != null && i < order.getIsocOrderGoods().size(); i++) {
			IsocOrderGoods iog = new IsocOrderGoods(0,ieo.getIsocexamineorderid(),
				order.getIsocOrderGoods().get(i).getGoods().getGoodsid(),order.getIsocOrderGoods().get(i).getNum(),
				order.getIsocOrderGoods().get(i).getGoods().getPrice(),
				order.getIsocOrderGoods().get(i).getGoods().getPrice()*order.getIsocOrderGoods().get(i).getNum());
			isocOrderGoodsDao.insert(iog);
		}
		return 1;
	}

	@Override
	public int deleteIsocExamineOrder(int id) {
		IsocExamineOrder ieo = isocExamineOrderDao.selectByPrimaryKey(id);
		if(ieo == null || ieo.getOrderstatus() != 0){
			return 426;
		}
		isocOrderGoodsDao.deleteByIsocexamineorderid(id);
		isocExamineOrderDao.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public List<IsocGoodsExtend> findIsocGoodsForIsoc(User user) {
		List<IsocGoodsExtend> list = isocGoodsDao.findIsocGoodsByIsocid(user.getRole().getRelationid());
		return list;
	}

	@Override
	public int updateIsocGoodsPrice(IsocGoods goods) {
		//根据家协产品id查询家协产品
		IsocGoods ig = isocGoodsDao.selectByPrimaryKey(goods.getIsocgoodsid());
		if(ig == null){
			return 426;
		}
		//判断修改价格是否合法
		if(goods.getPrice() <= 0){
			return 426;
		}
		ig.setPrice(goods.getPrice());
		return isocGoodsDao.updateByPrimaryKeySelective(ig);
	}

	@Override
	public QueryResult<BusinessExamineOrderExtend> findBusinessExamineOrder(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		BusinessExamineOrderExtend order = new BusinessExamineOrderExtend();
		if(user.getRole().getType() == config.INT_ISOCNO){
			order.setIsocid(user.getRole().getRelationid());
		}else if(user.getRole().getType() == config.INT_BUSINESS) {
			order.setBusinessid(user.getRole().getRelationid());
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.get("name") != null){
				order.setBusinessname(whereObj.getString("name").trim());
			}
		}
		QueryResult<BusinessExamineOrderExtend> orderQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		orderQ.setList(businessExamineOrderDao.findByPageList((orderQ.getPageIndex()-1)*orderQ.getPageSize(),orderQ.getPageSize(),order));
		orderQ.setTotalRow(businessExamineOrderDao.findCountByCondition(order));
		return orderQ;
	}

	@Override
	public int passBusinessExamineOrder(int businessexamineorderid) {
		BusinessExamineOrderExtend order = businessExamineOrderDao.findDetailByBusinessexamineorderid(businessexamineorderid);
		if(order == null || order.getOrderstatus() != 0 || 
				order.getBusinessOrderGoods() != null || order.getBusinessOrderGoods().size() == 0){
			return 426;
		}
		/*
		 * 1.查询订单下产品数量是否足够
		 * 2.如果数量不够，提示不能审核通过 返回结束流程
		 * 3.如果数量足够，修改订单状态为审核通过状态
		 * 4.修改家协下对应产品的消耗
		 * 5.企业产品新增对应的数量
		 */
		//查询出该订单下的所有产品
		for (int i = 0; i < order.getBusinessOrderGoods().size(); i++) {
			//查询出家协产品
			IsocGoods isocGoods = isocGoodsDao.selectByPrimaryKey(order.getBusinessOrderGoods().get(i).getIsocgoodsid());
			int remainingQuantity = isocGoods.getTotal()-isocGoods.getConsume();//剩余数量
			if(remainingQuantity < order.getBusinessOrderGoods().get(i).getNum()){//如果剩余数量小于本次将要消耗的数量，则不能通过，提示产品数量不足
				Util.callBackT();
				return 482;
			}
			//修改产品消耗
			isocGoods.setConsume(isocGoods.getConsume()+order.getBusinessOrderGoods().get(i).getNum());
			isocGoodsDao.updateByPrimaryKeySelective(isocGoods);
			
			//查询企业是否存在该家协产品
			BusinessGoods businessGoods = businessGoodsDao.findByBusinessidAndIsocGoodsid(order.getBusinessid(), isocGoods.getIsocgoodsid());
			if(businessGoods == null){
				businessGoods = new BusinessGoods();
				businessGoods.setBusinessid(order.getBusinessid());
				businessGoods.setIsocgoodsid(isocGoods.getIsocgoodsid());
			}
			businessGoods.setTotal(businessGoods.getTotal()+order.getBusinessOrderGoods().get(i).getNum());
			if(businessGoods.getBusinessgoodsid() > 0){
				businessGoodsDao.updateByPrimaryKey(businessGoods);
			}else{
				businessGoodsDao.insert(businessGoods);
			}
		}
		//修改订单状态为审核通过状态
		order.setOrderstatus(1);
		order.setPaytime(DateUtil.getCurrentTime());
		businessExamineOrderDao.updateByPrimaryKey(order);
		return 1;
	}

	@Override
	public List<BusinessGoodsExtend> findBusinessGoodsByIsocidAndBusinessidForBusinesss(int isocid,Integer businessid) {
		return businessGoodsDao.findBusinessGoodsByIsocidAndBusinessidForBusinesss(isocid,businessid);
	}
}
