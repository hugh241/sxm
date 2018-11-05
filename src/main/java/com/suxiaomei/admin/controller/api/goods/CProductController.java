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
import com.suxiaomei.admin.entity.business.extend.BusinessExamineOrderExtend;
import com.suxiaomei.admin.entity.isoc.IsocGoods;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.util.QueryResult;
/**
 * 家协产品销售模块 卖出给企业的产品订单管理
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
 * 2018年10月25日 上午10:31:46
 */
@Controller
@RequestMapping("/api/cproduct")
public class CProductController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value="goods",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="产品",methods="家协查询已购买的所有产品")
	@IIsocLog(module="产品",methods="家协查询已购买的所有产品")
	public Map<String, Object> searchAll() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocGoodsExtend> list = goodsService.findIsocGoodsForIsoc(cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT},value="editGoodsPrice")
	@ResponseBody
	@SystemLog(module="产品",methods="家协修改产品价格")
	@IIsocLog(module="产品",methods="家协修改产品价格")
	public Map<String, Object> updateGoodsPrice(@RequestBody IsocGoods goods) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.updateIsocGoodsPrice(goods);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="产品",methods="家协分页查询企业购买申请列表")
	@IIsocLog(module="产品",methods="家协分页查询企业购买申请列表")
	public Map<String, Object> searchOrderList(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			QueryResult<BusinessExamineOrderExtend> list = goodsService.findBusinessExamineOrder(condition,cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="产品",methods="家协通过企业购买产品订单审核")
	@IIsocLog(module="产品",methods="家协通过企业购买产品订单审核")
	public Map<String, Object> setnum(@RequestParam int businessexamineorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = goodsService.passBusinessExamineOrder(businessexamineorderid);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
