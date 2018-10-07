package com.suxiaomei.admin.controller.api.common;

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

import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.common.OrderFamilyMember;
import com.suxiaomei.admin.entity.common.OrderType;
import com.suxiaomei.admin.entity.common.extend.OrderFamilyMemberExtend;
import com.suxiaomei.admin.entity.customer.FamilyMember;
import com.suxiaomei.admin.service.common.OrderFamilyMemberService;

@Controller
@RequestMapping("/api/orderTypeFamilyMember")
public class OrderTypeFamilyMemberController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private OrderFamilyMemberService orderFamilyMemberService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="管理系统-订单类型成员配置",methods="查询关联列表")
	public Map<String, Object> findList() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<OrderFamilyMemberExtend> list = orderFamilyMemberService.findList();
			resultMap.put("data",list);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="orderType")
	@ResponseBody
	@SystemLog(module="管理系统-订单类型成员配置",methods="查询订单类型列表")
	public Map<String, Object> findOrderTypes() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<OrderType> list = orderFamilyMemberService.findOrderTypeList();
			resultMap.put("data",list);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="familyMember")
	@ResponseBody
	@SystemLog(module="管理系统-订单类型成员配置",methods="查询家庭成员列表")
	public Map<String, Object> findFamilyMembers() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<FamilyMember> list = orderFamilyMemberService.findFamilyMemberList();
			resultMap.put("data",list);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="管理系统-订单类型成员配置",methods="添加订单类型和家庭成员的关联")
	public Map<String, Object> addAssociation(@RequestBody OrderFamilyMember orderFamilyMember) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = orderFamilyMemberService.add(orderFamilyMember);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="管理系统-订单类型成员配置",methods="删除关联")
	public Map<String, Object> deleteAssociation(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = orderFamilyMemberService.delete(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
