package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.common.GoodsMapper;
import com.suxiaomei.admin.dao.isoc.IsocExamineOrderMapper;
import com.suxiaomei.admin.dao.isoc.IsocGoodsMapper;
import com.suxiaomei.admin.dao.isoc.IsocOrderGoodsMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.common.extend.IsocGoodsOrder;
import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;
import com.suxiaomei.admin.entity.isoc.IsocGoods;
import com.suxiaomei.admin.entity.isoc.IsocOrderGoods;
import com.suxiaomei.admin.response.Dict;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;
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
	public QueryResult<IsocGoodsOrder> findOrdersByConditionAndUserType(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		IsocGoodsOrder order = new IsocGoodsOrder();
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
		QueryResult<IsocGoodsOrder> orderQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
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
}
