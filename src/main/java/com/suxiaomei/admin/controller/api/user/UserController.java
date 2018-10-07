package com.suxiaomei.admin.controller.api.user;

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
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.UserExtend;
import com.suxiaomei.admin.service.account.UserService;

@Controller
@RequestMapping("api/user")
public class UserController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="logout",method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="用户管理",methods="注销当前登录用户")
	public Map<String, Object> logout() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = userService.logout(cUser);
			resultMap.put("data", flag);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="password",method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="系统",methods="修改自己的密码")
	public Map<String, Object> updatePassword(@RequestBody UserExtend pp) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int _Update = userService.updatePassword(pp,cUser);
			resultMap.put("data",_Update);
			if(_Update == 2){//
				return ERROR(resultMap,Code.SUBMIT_DATA_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="账号管理",methods="用户-查询所有用户")
	public Map<String, Object> findAll() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",userService.findAll(cUser));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="账号管理",methods="用户-新增")
	public Map<String, Object> addUser(@RequestBody User user) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = userService.add(user);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(value="resetpassword",method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="系统",methods="用户-重置密码")
	public Map<String, Object> updateResetPassword(@RequestBody UserExtend user) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = userService.resetPassword(user);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="账号管理",methods="用户-删除（将用户状态修改为删除状态）")
	public Map<String, Object> delete(@RequestParam int userid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = userService.updateUserStatus(userid,0);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
}
