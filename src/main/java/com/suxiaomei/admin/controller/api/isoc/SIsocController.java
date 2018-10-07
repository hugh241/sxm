package com.suxiaomei.admin.controller.api.isoc;

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

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.service.isoc.IsocService;

/**
 * 系统家协管理
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
@RequestMapping("api/isoc")
public class SIsocController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IsocService isocService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="系统家协",methods="分页查询")
	public Map<String, Object> find(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			resultMap.put("data",isocService.findByPageList(condition));
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协",methods="新增家协")
	public Map<String, Object> insertIsoc(@RequestBody IsocExtend ie) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.add(ie);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(value="edit",method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="家协",methods="修改家协")
	public Map<String, Object> updateKey(@RequestBody IsocExtend ie) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.update(ie);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="家协",methods="停用/启用家协账号")
	public Map<String, Object> updateStatus(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.updateStatus(id);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(value="resetPassword",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协",methods="重置家协密码")
	public Map<String, Object> resetPassword(@RequestBody IsocExtend ie) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.updatePassword(ie);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	
	@RequestMapping(method = {RequestMethod.GET},value="getConfig")
	@ResponseBody
	@SystemLog(module="家协",methods="根据家协id查询配置项")
	public Map<String, Object> getConfig(@RequestParam int isocid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",isocService.findConfigByIsocid(isocid));
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="addConfig")
	@ResponseBody
	@SystemLog(module="家协",methods="新增认证配置项")
	public Map<String, Object> addConfig(@RequestBody IsocBusinessDataConfigure config) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.addConfig(config);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT},value="updateConfig")
	@ResponseBody
	@SystemLog(module="家协",methods="修改认证配置项")
	public Map<String, Object> updateConfig(@RequestBody IsocBusinessDataConfigure config) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.updateConfig(config);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE},value="deleteConfig")
	@ResponseBody
	@SystemLog(module="家协",methods="删除认证配置项")
	public Map<String, Object> deleteConfig(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.deleteConfig(id);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
}
