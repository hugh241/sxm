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
import com.suxiaomei.admin.service.employee.EmployeeService;
/**
 * 护理员
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
 * 2018年9月29日 上午11:07:48
 */
@Controller
@RequestMapping("api/employee")
public class SEmployeeController extends BaseController{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="员工管理",methods="员工-基本信息查询(分页条件查询)")
	public Map<String, Object> getList(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			resultMap.put("data", employeeService.findByPageList(condition,cUser));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="/byId",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="员工管理",methods="员工-根据id查询员工详细信息")
	public Map<String, Object> getById(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data", employeeService.findById(id,cUser));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
