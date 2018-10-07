package com.suxiaomei.admin.controller.api.common;

import java.io.File;
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
import com.suxiaomei.admin.entity.common.Banner;
import com.suxiaomei.admin.service.common.BannerService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.file.FileUploadUtil;

@Controller
@RequestMapping("/api/sxmbanner")
public class BannerController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private GlobalConfig config;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="Banner",methods="查询全部banner")
	public Map<String, Object> findAll(@RequestParam(required=false,defaultValue="-1") int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",bannerService.findByType(type));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="/byId",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="Banner",methods="根据id查询banner")
	public Map<String, Object> findbyid(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",bannerService.findById(id));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="/sort",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="Banner",methods="banner排序")
	public Map<String, Object> sortBanner(@RequestParam String ids) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			resultMap.put("data",bannerService.updateBannerSort(ids));
			return SUCCESS(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="Banner",methods="新增banner")
	public Map<String, Object> addBanner(HttpServletRequest request,@RequestParam(value="file") MultipartFile file,@RequestParam String url,@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			String currentDate = DateUtil.getCurrentDate();
			String rpath = FileUploadUtil._saveImg(file, currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE);
			
			Banner banner = new Banner();
			banner.setUrl(url);
			banner.setName(rpath.substring(rpath.indexOf("/")+1));
			banner.setImgurl(rpath);
			banner.setType(type);
			int flag = bannerService.add(banner);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(value="update",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="Banner",methods="修改banner")
	public Map<String, Object> updateBanner(HttpServletRequest request,@RequestParam(value="file",required=false) MultipartFile file,
			@RequestParam String url,@RequestParam int id,@RequestParam int type) {
		Map<String,Object> resultMap = new HashMap<>();
		Banner banner = bannerService.findById(id);
		if(file != null){
	        FileUploadUtil.deleteImg(config.LOCALUPLOADPATH_ORIGINAL+banner.getImgurl(), config.LOCALUPLOADPATH_MOBILE+banner.getImgurl(), config.LOCALUPLOADPATH_PC+banner.getImgurl());
	        
			String currentDate = DateUtil.getCurrentDate();
			String path = FileUploadUtil._saveImg(file, currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE);
	        
	        banner.setName(path.substring(path.indexOf("/")+1));
	        banner.setImgurl(path);
		}
		banner.setUrl(url);
		banner.setType(type);
		try {
			int flag = bannerService.update(banner);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="Banner",methods="删除banner（修改banner状态为删除）")
	public Map<String, Object> deleteBanner(HttpServletRequest request,@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = bannerService.delete(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR(resultMap);
		}
	}
}
