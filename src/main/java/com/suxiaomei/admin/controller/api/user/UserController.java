package com.suxiaomei.admin.controller.api.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.common.paramer.UserParamer;
import com.suxiaomei.admin.controller.api.BaseController;
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
		Map<String,Object> resultMap = new HashMap<String, Object>();
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
	public Map<String, Object> updatePassword(@RequestBody UserParamer pp) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
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
}
