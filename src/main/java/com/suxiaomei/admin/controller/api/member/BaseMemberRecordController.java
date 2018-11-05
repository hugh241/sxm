package com.suxiaomei.admin.controller.api.member;

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
import com.suxiaomei.admin.entity.isoc.MemberRecord;
import com.suxiaomei.admin.service.isoc.MemberService;

/**
 * 
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
 * 2018年10月11日 下午1:02:28
 */
@Controller
@RequestMapping("/api/basememberrecord")
public class BaseMemberRecordController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	protected MemberService memberService;
	
	@RequestMapping(method = {RequestMethod.GET},value="getRecordByMemberid")
	@ResponseBody
	@SystemLog(module="家协用户",methods="查询会员申请的审核记录")
	@IIsocLog(module="家协用户",methods="查询会员申请的审核记录")
	public Map<String, Object> getRecordByMemberid(@RequestParam int memberid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<MemberRecord> records = memberService.findMemberRecordByMemberid(memberid);
			return SUCCESS(resultMap,records);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
