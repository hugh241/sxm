package com.suxiaomei.admin.controller.api.employee;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.service.employee.EmployeePhotoService;

@Controller
@RequestMapping("/api/employee/photo")
public class EmployeePhotoController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeePhotoService employeePhotoService;
	
	@RequestMapping(value="getForAudit",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="员工照片",methods="根据类型审核状态分页查询")
	public Map<String, Object> getForAudit(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			resultMap.put("data", employeePhotoService.findByCondition(condition));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
