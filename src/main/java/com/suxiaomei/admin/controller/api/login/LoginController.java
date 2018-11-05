package com.suxiaomei.admin.controller.api.login;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.UserExtend;
import com.suxiaomei.admin.service.account.UserService;
import com.suxiaomei.admin.util.Util;
import com.suxiaomei.admin.util.redis.RedisUtil;
import com.suxiaomei.admin.util.sms.SMSUtil;

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
	@Resource
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private GlobalConfig config;
	
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
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="bLogin")
	@ResponseBody
	@SystemLog(module="用户",methods="企业用户-登陆")
	public Map<String, Object> bLogin(@RequestBody UserExtend user) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			JSONObject u = null;
			if(user.getPassword() != null && !"".equals(user.getPassword())){//账号密码登录
				u = userService.findByUsernameAndPassword(user);
			}else if(user.getCode() != null && !"".equals(user.getCode())){//手机号验证码登录
				Object object = RedisUtil.get(redisTemplate,config.STR_TELCODE.get(1)+user.getMobile());//config.STR_TELCODE.get(1)登录验证码
				String code = object == null?null:object.toString();
				if(code != null && code.equals(user.getCode())){//验证成功
					RedisUtil.del(redisTemplate, config.STR_TELCODE.get(1)+user.getMobile());//删除验证码redis中的数据
					u = userService.findByMobile(user.getMobile(),0);
				}else{
					return ERROR(resultMap,Code.VCODEERROR);
				}
			}else{
				return ERROR(resultMap,Code.SUBMIT_DATA_ERROR);
			}
			
			if(u == null) {
				resultMap.put("data", 0);
				return ERROR(resultMap,Code.LOGIN_FAILED);
			}
			resultMap.put("data",u);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	
	@RequestMapping(value="/sendSMS",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="登录",methods="企业登录_验证码发送")
	public Map<String, Object> sendSMS(@RequestParam String tel) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			//判断客户手机号是否存在账号
			JSONObject u = userService.findByMobile(tel,1);
			if(u == null){
				return ERROR(resultMap,Code.TELNOTREGISTER);
			}
			//存在该手机号的用户，创建手机验证码并发送
			String code = Util.getRandom().substring(0, 4);
			RedisUtil.set(redisTemplate, config.STR_TELCODE.get(1)+tel, code, config.TIMESTAMP.get(1));
			if(config.ISSENDSMS) {//发送短信
				boolean flag = SMSUtil.SendSmsZG(config.STR_SMS.get(0),config.STR_SMS.get(1),config.STR_SMS.get(2),
						config.STR_SMS.get(3),tel, config.STR_SMS_MSG.get(0) + code + "," + config.STR_SMS_MSG.get(1));
				if(!flag) {//发送失败
					return ERROR(resultMap,Code.SMSFAILED);
				}
			}else {//不发送，默认发送成功，返回验证码
				resultMap.put("data",code);
			}
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
