package com.suxiaomei.admin.controller.api.isoc;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.suxiaomei.admin.common.Code;
import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.aop.IIsocLog;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.file.FileUploadUtil;

@Controller
@RequestMapping("/api/isochome")
public class IIsocHomeController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IsocService isocService;
	@Autowired
	private GlobalConfig config;

	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协系统",methods="查询出当前登录家协的基本信息")
	@IIsocLog(module="首页",methods="获取基本信息")
	public Map<String, Object> getBaseInfo() {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			IsocExtend ir = isocService.findByIsocid(cUser.getRole().getRelationid());
			return SUCCESS(resultMap,ir);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协系统",methods="家协基本信息完善")
	@IIsocLog(module="首页",methods="基本信息完善")
	public Map<String, Object> completeBusiness(MultipartFile file,String mobile,String email,String address,String introduce) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			Isoc isoc = isocService.selectByPrimaryKey(cUser.getRole().getRelationid());
			isoc.setMobile(URLDecoder.decode(mobile,"UTF-8"));
			isoc.setEmail(URLDecoder.decode(email,"UTF-8"));
			isoc.setCaddress(URLDecoder.decode(address,"UTF-8"));
			isoc.setIntroduce(URLDecoder.decode(introduce,"UTF-8"));
			if(file != null){
				String currentDate = DateUtil.getCurrentDate();
				String path = FileUploadUtil._saveImg(file, currentDate, config.LOCALUPLOADPATH_ORIGINAL, config.LOCALUPLOADPATH_PC, config.LOCALUPLOADPATH_MOBILE);
				isoc.setLogo(path);
			}
			int flag = isocService.update(isoc);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap,Code.CONTROLLE_FAILED);
		}
	}
}
