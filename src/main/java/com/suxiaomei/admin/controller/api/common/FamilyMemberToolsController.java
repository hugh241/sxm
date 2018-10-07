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
import com.suxiaomei.admin.entity.common.Tools;
import com.suxiaomei.admin.entity.customer.FamilyMember;
import com.suxiaomei.admin.entity.customer.FamilyMemberTools;
import com.suxiaomei.admin.entity.customer.extend.FamilyMemberToolsExtend;
import com.suxiaomei.admin.service.common.FamilyMemberToolsService;
/**
 * 家庭成员工具配置
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
 * 2018年10月7日 下午4:35:22
 */
@Controller
@RequestMapping("/api/familyMemberTools") 
public class FamilyMemberToolsController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private FamilyMemberToolsService familyMemberToolsService;
	
	@RequestMapping(method = {RequestMethod.GET},value="familyMember")
	@ResponseBody
	@SystemLog(module="管理系统-家庭成员工具配置",methods="查询家庭成员列表")
	public Map<String, Object> findFamilyMember() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<FamilyMember> list = familyMemberToolsService.findFamilyMemberList();
			resultMap.put("data",list);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="tools")
	@ResponseBody
	@SystemLog(module="管理系统-家庭成员工具配置",methods="查询工具类型列表")
	public Map<String, Object> findTools() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Tools> list = familyMemberToolsService.findToolsList();
			resultMap.put("data",list);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
		return SUCCESS(resultMap);
	}

	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="管理系统-家庭成员工具配置",methods="查询关联列表")
	public Map<String, Object> findList() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<FamilyMemberToolsExtend> list = familyMemberToolsService.findList();
			resultMap.put("data",list);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="管理系统-家庭成员工具配置",methods="添加家庭成员和工具类的关联")
	public Map<String, Object> addAssociation(@RequestBody FamilyMemberTools familyMemberTools) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = familyMemberToolsService.add(familyMemberTools);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="管理系统-家庭成员工具配置",methods="删除关联")
	public Map<String, Object> deleteAssociation(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = familyMemberToolsService.delete(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
