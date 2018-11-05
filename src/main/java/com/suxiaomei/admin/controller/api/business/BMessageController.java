package com.suxiaomei.admin.controller.api.business;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.account.UserNoteMessage;
import com.suxiaomei.admin.service.account.UserNoteMessageService;
/**
 * 企业端-消息管理
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
 * 2018年10月29日 下午5:38:37
 */
@Controller
@RequestMapping("/api/bmessage")
public class BMessageController extends BaseController{
	private static final long serialVersionUID = 1L;

	@Autowired
	protected UserNoteMessageService userNoteMessageService;
	
	@RequestMapping(value="getScheduleMsg",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业-消息管理",methods="根据条件查询我的跟进消息")
	public Map<String, Object> getScheduleMessage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			List<UserNoteMessage> list = userNoteMessageService.findByConditionAndType(condition,1,cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="getOrderMsg",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业-消息管理",methods="根据条件查询我的订单消息")
	public Map<String, Object> getOrderMessage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			List<UserNoteMessage> list = userNoteMessageService.findByConditionAndType(condition,2,cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="getContractMsg",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业-消息管理",methods="根据条件查询我的合同关闭消息")
	public Map<String, Object> getContractMessage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			List<UserNoteMessage> list = userNoteMessageService.findByConditionAndType(condition,3,cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="getReceiptMsg",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业-消息管理",methods="根据条件查询我的收款消息")
	public Map<String, Object> getReceiptMsg(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			List<UserNoteMessage> list = userNoteMessageService.findByConditionAndType(condition,4,cUser);
			return SUCCESS(resultMap, list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="read",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业-消息管理",methods="设置消息为已读")
	public Map<String, Object> read(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = userNoteMessageService.updateRead(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
