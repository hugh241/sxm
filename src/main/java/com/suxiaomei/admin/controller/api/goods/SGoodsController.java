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

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.common.extend.IsocGoodsOrder;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.util.QueryResult;

/**
 * 系统系统产品管理
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
 * 2018年9月25日 下午4:40:17
 */
@Controller
@RequestMapping("api/goods")
public class SGoodsController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="系统产品",methods="根据上/下架状态查询产品")
	public Map<String, Object> find(@RequestParam(required=false) Integer status) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Goods> goodsList = goodsService.findAllByStatus(status);
			resultMap.put("data",goodsList);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLEFAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="系统产品",methods="新增系统产品")
	public Map<String, Object> insertIsoc(@RequestBody Goods goods) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.addGoods(goods);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="系统产品",methods="修改系统产品")
	public Map<String, Object> updateKey(@RequestBody Goods goods) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.updateGoods(goods);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="系统产品",methods="上/下架系统产品")
	public Map<String, Object> updateStatus(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.upDownGoods(id);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(value="order",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="系统产品",methods="查询产品订单")
	public Map<String, Object> searchOrderList(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			QueryResult<IsocGoodsOrder> goodsList = goodsService.findOrdersByConditionAndUserType(condition,cUser);
			resultMap.put("data",goodsList);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLEFAILED);
		}
	}
	
	@RequestMapping(value="close",method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="系统产品",methods="确定产品订单到账，修改状态")
	public Map<String, Object> close(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.updateIsocExamineOrderStatus(id);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLEFAILED);
		}
	}
}
