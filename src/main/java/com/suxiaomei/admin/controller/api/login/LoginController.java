package com.suxiaomei.admin.controller.api.login;

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
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.service.account.UserService;

import net.sf.json.JSONObject;

/**
 * 登录（包括管理系统登录、家协端登录、企业端登录）
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
 * 2018年9月19日 上午9:18:35
 */
@Controller
@RequestMapping("api/login")
public class LoginController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="用户",methods="用户-登陆")
	public Map<String, Object> login(@RequestBody User user) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			JSONObject u = userService.findByUsernameAndPassword(user);
			if(u == null) {
				resultMap.put("data", 0);
				return ERROR(resultMap,Code.LOGIN_FAILED);
			}
			resultMap.put("data",u);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
