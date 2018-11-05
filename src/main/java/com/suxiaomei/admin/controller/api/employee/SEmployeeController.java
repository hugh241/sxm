package com.suxiaomei.admin.controller.api.employee;

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
import com.suxiaomei.admin.entity.common.IdentificationLog;
import com.suxiaomei.admin.entity.employee.EmployeeCreditCard;
import com.suxiaomei.admin.service.employee.EmployeeService;
import com.suxiaomei.admin.service.isoc.IsocCreditCardTemplateService;
/**
 * 管理端 护理员管理
 * 家协端 会员企业所有家政人员档案
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
	@Autowired
	private IsocCreditCardTemplateService isocCreditCardTemplateService;
	
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
			return ERROR(resultMap,e);
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
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="getPLog",method = { RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业",methods="查询员工工种操作记录")
	public Map<String, Object> getPLog(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IdentificationLog> ilList = employeeService.findPLog(id);
			return SUCCESS(resultMap,ilList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = { RequestMethod.GET},value="getCreditCard")
	@ResponseBody
	@SystemLog(module="家协",methods="根据阿姨id查询阿姨的名片（正反面）")
	public Map<String, Object> getEmployeeCard(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			EmployeeCreditCard card = isocCreditCardTemplateService.updateAndGetEmployeeCard(cUser.getRole().getRelationid(),id);
			return SUCCESS(resultMap,card);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
