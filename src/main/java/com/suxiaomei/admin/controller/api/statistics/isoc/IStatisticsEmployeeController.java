package com.suxiaomei.admin.controller.api.statistics.isoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.aop.IIsocLog;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.service.common.StatisticsService;

@Controller
@RequestMapping("/api/statisticsEmployee")
public class IStatisticsEmployeeController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(method = {RequestMethod.GET},value="gender")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="性别统计")
	@IIsocLog(module="护理员统计",methods="性别统计")
	public Map<String, Object> gender(@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeGenderStatistics(cUser,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="worktype")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="工种统计")
	@IIsocLog(module="护理员统计",methods="工种统计")
	public Map<String, Object> worktype(@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeWorktypeStatistics(cUser,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="age")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="年龄统计")
	@IIsocLog(module="护理员统计",methods="年龄统计")
	public Map<String, Object> age(@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeAgeStatistics(cUser,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="experience")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="工作经验统计")
	@IIsocLog(module="护理员统计",methods="工作经验统计")
	public Map<String, Object> experience(@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeExperienceStatistics(cUser,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="province")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="所属省/直辖市/自治区统计")
	@IIsocLog(module="护理员统计",methods="所属省/直辖市/自治区统计")
	public Map<String, Object> province(@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeProvinceStatistics(cUser,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="city")
	@ResponseBody
	@SystemLog(module="护理员统计",methods="所属市")
	@IIsocLog(module="护理员统计",methods="所属市")
	public Map<String, Object> city(@RequestParam int provinceid,@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Map<String,Object>> result = statisticsService.findEmployeeCityStatistics(cUser,provinceid,type);
			return SUCCESS(resultMap,result);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
