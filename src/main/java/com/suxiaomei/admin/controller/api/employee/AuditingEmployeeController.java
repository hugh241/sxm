package com.suxiaomei.admin.controller.api.employee;

import java.net.URLDecoder;
import java.util.HashMap;
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
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationOrderExtend;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.service.employee.EmployeeIdentificationOrderService;
import com.suxiaomei.admin.util.QueryResult;
/**
 * 审核阿姨认证
 * 1.家协端 待认证家政人员申请
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
 * 2018年10月16日 上午9:30:16
 */
@Controller
@RequestMapping("/api/bcaudit")
public class AuditingEmployeeController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeeIdentificationOrderService employeeIdentificationOrderService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="阿姨认证",methods="待认证阿姨查询")
	@IIsocLog(module="阿姨认证",methods="待认证阿姨查询")
	public Map<String, Object> auditingEmployee(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<EmployeeIdentificationOrderExtend> isocRList = employeeIdentificationOrderService.findByCondition(condition,0,cUser);
			return SUCCESS(resultMap, isocRList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}

	@RequestMapping(value="h",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="阿姨认证",methods="历史认证阿姨查询")
	@IIsocLog(module="阿姨认证",methods="历史认证阿姨查询")
	public Map<String, Object> auditedEmployee(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<EmployeeIdentificationOrderExtend> isocRList = employeeIdentificationOrderService.findByCondition(condition,1,cUser);
			return SUCCESS(resultMap, isocRList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="auditItem")
	@ResponseBody
	@SystemLog(module="家协用户-阿姨认证",methods="通过/驳回认证项")
	@IIsocLog(module="阿姨认证",methods="通过/驳回认证项")
	public Map<String, Object> auditItem(@RequestBody IsocBusinessOrderData data) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = employeeIdentificationOrderService.authIsocOrderItem(data);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="backgroundCheck")
	@ResponseBody
	@SystemLog(module="家协用户",methods="护理员背调")
	@IIsocLog(module="阿姨认证",methods="护理员背调")
	public Map<String, Object> backgroundCheck(@RequestBody EmployeeIdentificationOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			Object flag = employeeIdentificationOrderService.backgroundCheck(order);
			if(flag instanceof Integer){
				return GENERALRETURN(resultMap,Integer.parseInt(flag.toString()));
			}else {
				return SUCCESS(resultMap, flag);
			}
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协用户",methods="审核申请")
	@IIsocLog(module="阿姨认证",methods="审核申请")
	public Map<String, Object> authApply(@RequestBody EmployeeIdentificationOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = employeeIdentificationOrderService.authApply(order);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
