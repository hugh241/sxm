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

import com.suxiaomei.admin.common.aop.IIsocLog;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.account.Contact;
import com.suxiaomei.admin.service.common.ContactService;
@Controller
@RequestMapping("/api/contacter")
public class ContactController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContactService contactService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="联系人",methods="查询全部联系人")
	@IIsocLog(module="联系人",methods="查询全部联系人")
	public Map<String, Object> findAll() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Contact> list = contactService.findAll(cUser);
			return SUCCESS(resultMap,list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}

	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="联系人",methods="新增联系人")
	@IIsocLog(module="联系人",methods="新增联系人")
	public Map<String, Object> newContacter(@RequestBody Contact contact) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = contactService.add(contact,cUser);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="联系人",methods="修改联系人")
	@IIsocLog(module="联系人",methods="修改联系人")
	public Map<String, Object> updateContacter(@RequestBody Contact contact) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = contactService.update(contact);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="联系人",methods="删除联系人")
	@IIsocLog(module="联系人",methods="删除联系人")
	public Map<String, Object> deleteContacter(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = contactService.delete(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
