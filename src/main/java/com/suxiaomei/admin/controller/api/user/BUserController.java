package com.suxiaomei.admin.controller.api.user;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.service.business.BusinessService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.file.FileUploadUtil;
/**
 * 企业端 首页管理
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
 * 2018年10月29日 下午4:42:40
 */
@Controller
@RequestMapping("/api/buser")
public class BUserController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private GlobalConfig config;

	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="得到当前登陆的企业信息")
	public Map<String, Object> find(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<>();
		//查询出企业基本信息
		try {
			BusinessExtend business = businessService.findDetailByBusinessid(cUser.getRole().getRelationid());
			resultMap.put("user", cUser);
			resultMap.put("business", business);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="企业用户",methods="企业资料完善")
	public Map<String, Object> completeBusiness(@RequestParam(value="file",required=false) MultipartFile file,@RequestParam String fullname,@RequestParam String phone,@RequestParam String email,@RequestParam String url,@RequestParam String address,@RequestParam String summary) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			fullname = URLDecoder.decode(URLDecoder.decode(fullname,"utf-8"),"utf-8");
			phone = URLDecoder.decode(URLDecoder.decode(phone,"utf-8"),"utf-8");
			email = URLDecoder.decode(URLDecoder.decode(email,"utf-8"),"utf-8");
			url = URLDecoder.decode(URLDecoder.decode(url,"utf-8"),"utf-8");
			address = URLDecoder.decode(URLDecoder.decode(address,"utf-8"),"utf-8");
			summary = URLDecoder.decode(URLDecoder.decode(summary,"utf-8"),"utf-8");
			String path = null;
			if(file != null){
				String currentDate = DateUtil.getCurrentDate();
				path = FileUploadUtil._saveImg(file,currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE);
			}
			int flag = businessService.compalteBusinessInfo(cUser.getRole().getRelationid(),fullname,phone,email,url,address,summary,path);	
			return GENERALRETURN(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
