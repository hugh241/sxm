package com.suxiaomei.admin.controller.api.business;

import java.net.URLDecoder;
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
import com.suxiaomei.admin.controller.api.member.BaseMemberRecordController;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;
import com.suxiaomei.admin.entity.isoc.extend.IsocBusinessOrderExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;
import com.suxiaomei.admin.service.business.BusinessService;
import com.suxiaomei.admin.service.employee.EmployeeIdentificationOrderService;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.QueryResult;
/**
 * 家协端 认证企业申请
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
 * 2018年10月12日 下午12:41:31
 */
@Controller
@RequestMapping("/api/abusiness")
public class IBusinessController extends BaseMemberRecordController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IsocService isocService;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private EmployeeIdentificationOrderService employeeIdentificationOrderService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="分页查询认证企业申请")
	@IIsocLog(module="家协用户",methods="分页查询认证企业申请")
	public Map<String, Object> searchByPage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<IsocBusinessOrderExtend> goodsList = isocService.findIsocBusinessOrder(condition,cUser);
			return SUCCESS(resultMap,goodsList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="findAuditRecord",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="根据审核订单id查询审核记录")
	@IIsocLog(module="家协用户",methods="根据审核订单id查询审核记录")
	public Map<String, Object> findAuditRecord(@RequestParam int isocbusinessorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocBusinessOrderRecord> list = isocService.findIsocBusinessOrderRecord(isocbusinessorderid);
			return SUCCESS(resultMap,list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	

	@RequestMapping(method = {RequestMethod.POST},value="auditItem")
	@ResponseBody
	@SystemLog(module="企业认证",methods="通过/驳回认证项")
	@IIsocLog(module="企业认证",methods="通过/驳回认证项")
	public Map<String, Object> auditItem(@RequestBody IsocBusinessOrderData data) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = employeeIdentificationOrderService.authIsocOrderItem(data);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协用户",methods="审核申请")
	@IIsocLog(module="家协用户",methods="审核申请")
	public Map<String, Object> authApply(@RequestBody IsocBusinessOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.authIsocBusinessOrder(order);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="manager",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="已认证企业管理")
	@IIsocLog(module="企业认证",methods="已认证企业管理")
	public Map<String, Object> manager(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<IsocIdentificationBusinessExtend> businessList = isocService.findIsocIdentificationBusiness(condition,cUser);
			return SUCCESS(resultMap,businessList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="getBusinessByBusinessid")
	@ResponseBody
	@SystemLog(module="家协用户",methods="根据企业id查询企业详细信息")
	@IIsocLog(module="企业认证",methods="根据企业id查询企业详细信息")
	public Map<String, Object> getBusinessByMemberid(@RequestParam int businessid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			BusinessExtend business = businessService.findDetailByBusinessid(businessid);
			return SUCCESS(resultMap,business);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="searchBUAuth",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="未授权的企业查询")
	@IIsocLog(module="企业授权",methods="未授权的企业查询")
	public Map<String, Object> searchBUAuth(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<Business> businessList = businessService.findBAuthBusiness(condition,cUser,0);
			return SUCCESS(resultMap,businessList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="searchBAuth",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="授权企业查询")
	@IIsocLog(module="企业授权",methods="授权的企业查询")
	public Map<String, Object> searchBAuth(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<Business> businessList = businessService.findBAuthBusiness(condition,cUser,1);
			return SUCCESS(resultMap,businessList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="auth",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协用户",methods="企业授权")
	@IIsocLog(module="企业授权",methods="给认证企业授权")
	public Map<String, Object> auth(@RequestParam int id,@RequestParam(required=false) Integer status) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = businessService.authBusiness(id,status,cUser);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
