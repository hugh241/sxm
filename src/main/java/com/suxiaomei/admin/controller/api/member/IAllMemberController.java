package com.suxiaomei.admin.controller.api.member;

import java.net.URLDecoder;
import java.util.HashMap;
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
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.entity.isoc.extend.MemberExtend;
import com.suxiaomei.admin.service.business.BusinessService;
import com.suxiaomei.admin.util.QueryResult;
/**
 * 家协端 所有会员企业管理
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
 * 2018年10月8日 上午11:37:43
 */
@Controller
@RequestMapping("/api/iAllMember")
public class IAllMemberController extends BaseMemberRecordController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="会员企业列表分页查询")
	@IIsocLog(module="家协用户",methods="会员企业列表分页查询")
	public Map<String, Object> searchByPage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<MemberExtend> members = memberService.findPassMembersByPage(condition,cUser);
			return SUCCESS(resultMap,members);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协用户",methods="添加会员单位")
	@IIsocLog(module="家协用户",methods="添加会员单位")
	public Map<String, Object> addMember(@RequestBody Member member) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			member.setShstatus(1);
			member.setIsocid(cUser.getRole().getRelationid());
			int flag = memberService.add(member);
			if(flag >= 0) {//正常返回码
				return GENERALRETURN(resultMap, flag);
			}else {//返回新增后的id
				return SUCCESS(resultMap,-flag);
			}
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET},value="getBusinessByMemberid")
	@ResponseBody
	@SystemLog(module="家协用户",methods="根据会员申请id查询企业详细信息")
	@IIsocLog(module="家协用户",methods="根据会员申请id查询企业详细信息")
	public Map<String, Object> getBusinessByMemberid(@RequestParam int memberid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			BusinessExtend business = businessService.findDetailByMemberid(memberid);
			return SUCCESS(resultMap,business);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="家协用户",methods="修改会员单位")
	public Map<String, Object> updateMember(@RequestBody Member member) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = memberService.update(member);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="家协用户",methods="删除会员单位")
	public Map<String, Object> deleteMember(@RequestParam int memberid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = memberService.delete(memberid);
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
