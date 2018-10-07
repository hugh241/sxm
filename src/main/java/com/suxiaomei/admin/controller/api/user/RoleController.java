package com.suxiaomei.admin.controller.api.user;

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
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.extend.RoleModuleExtend;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.service.account.RoleService;
import com.suxiaomei.admin.service.common.ModuleService;
@Controller
@RequestMapping("/api/role")
public class RoleController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-查询")
	public Map<String, Object> getList() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",roleService.findNormalRoleByCUser(cUser));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-添加")
	public Map<String, Object> addRole(@RequestBody Role role) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = roleService.add(role, cUser);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-修改")
	public Map<String, Object> updateRole(@RequestBody Role role) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = roleService.update(role);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-删除")
	public Map<String, Object> deleteRole(@RequestParam int roleId) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = roleService.delete(roleId);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="/getModulesByRoleId",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-根据角色id查询模块")
	public Map<String, Object> getModulesByRoleId(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Module> mrList = moduleService.getAllModulesByRoleid(id);
			resultMap.put("date",mrList);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(value="/impower",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="系统",methods="用户角色-模块授权")
	public Map<String, Object> impower(@RequestBody RoleModuleExtend roleModule) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = roleService.updateImpower(roleModule);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
