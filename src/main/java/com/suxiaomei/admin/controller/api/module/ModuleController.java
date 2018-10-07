package com.suxiaomei.admin.controller.api.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.service.common.ModuleService;

@Controller
@RequestMapping("api/module")
public class ModuleController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	public Map<String, Object> findModule(){
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Module> list = moduleService.getMenu(cUser);
			resultMap.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
		return SUCCESS(resultMap);
	}
	
}
