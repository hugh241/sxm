package com.suxiaomei.admin.controller.api.member;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.entity.isoc.extend.MemberExtend;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.service.isoc.MemberService;
import com.suxiaomei.admin.util.QueryResult;

/**
 * 企业端-申请会员管理
 * @author zl
 */
@Controller
@RequestMapping("/api/bmember") 
public class BMemberController extends BaseMemberRecordController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private MemberService memberService;
	@Autowired
	private IsocService isocService;
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="企业用户",methods="申请会员认证")
	public Map<String, Object> applyToIsoc(@RequestBody Member member) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			member.setBusinessid(cUser.getRole().getRelationid());
			member.setShstatus(0);
			int flag = memberService.add(member);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="会员申请列表分页查询")
	public Map<String, Object> searchByPage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<MemberExtend> members = memberService.findAllMembersByCondition(condition,cUser);
			return SUCCESS(resultMap,members);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="empowerFirm",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="查询送审单位")
	public Map<String, Object> find(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Isoc> isocRList = isocService.findIsocWitchNotAuthMember(cUser.getRole().getRelationid());
			resultMap.put("data", isocRList);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="reApplay")
	@ResponseBody
	@SystemLog(module="企业用户",methods="重新编辑申请提交")
	public Map<String, Object> reApplyToIsoc(@RequestBody Member member) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = memberService.reApply(member);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
