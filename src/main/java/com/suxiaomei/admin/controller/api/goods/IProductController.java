package com.suxiaomei.admin.controller.api.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.aop.IIsocLog;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.util.QueryResult;

/**
 * 家协模块 向管理系统购买认证次数 购买订单管理（家协人员认证次数充值）
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
 * 2018年8月9日 上午10:33:16
 */
@Controller
@RequestMapping("/api/iproduct")
public class IProductController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="goods",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="产品",methods="家协查询所有产品")
	@IIsocLog(module="产品",methods="查询所有产品")
	public Map<String, Object> searchAll() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocGoodsExtend> goodsList = goodsService.findAllGoodsForIsoc(cUser);
			return SUCCESS(resultMap, goodsList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="产品",methods="家协购买产品")
	@IIsocLog(module="产品",methods="购买产品")
	public Map<String, Object> addGoods(@RequestBody IsocExamineOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.addIsocExamineOrder(order,cUser);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="产品",methods="家协分页查询产品订单")
	@IIsocLog(module="产品",methods="分页查询产品订单")
	public Map<String, Object> searchOrderList(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			QueryResult<IsocExamineOrder> goodsList = goodsService.findOrdersByConditionAndUserType(condition,cUser);
			return SUCCESS(resultMap,goodsList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="产品",methods="删除订单")
	@IIsocLog(module="产品",methods="删除订单")
	public Map<String, Object> deleteGoods(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.deleteIsocExamineOrder(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
