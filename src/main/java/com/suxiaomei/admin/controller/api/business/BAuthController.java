package com.suxiaomei.admin.controller.api.business;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;
import com.suxiaomei.admin.entity.isoc.extend.IsocBusinessOrderExtend;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.file.FileUploadUtil;

/**
 * 企业认证提交信息管理
 * @author zl
 */
@Controller
@RequestMapping("/api/bauth") 
public class BAuthController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private IsocService isocService;
	@Autowired
	private GlobalConfig config;

	@RequestMapping(value="empowerFirm",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="查询送审单位")
	public Map<String, Object> find(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<Isoc> isocRList = isocService.findIsocWitchAuthMember(cUser.getRole().getRelationid());
			return SUCCESS(resultMap,isocRList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="分页查询企业认证申请列表")
	public Map<String, Object> searchByPage(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<IsocBusinessOrderExtend> goodsList = isocService.findIsocBusinessOrder(condition,cUser);
			resultMap.put("data",goodsList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
		return SUCCESS(resultMap);
	}
	
	@RequestMapping(value="findAuditConfig",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="根据家协id查询企业认证配置/培训学校认证配置列表")
	public Map<String, Object> findAuditConfig(@RequestParam int isocid,@RequestParam(defaultValue="0") Integer type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocBusinessDataConfigure> isocRList;
			if(type == 1){//培训学校
				isocRList = isocService.findIsocBusinessDataConfiguresForBByIsocid(isocid,2);
			}else{//企业认证
				isocRList = isocService.findIsocBusinessDataConfiguresForBByIsocid(isocid,0);
			}
			resultMap.put("data", isocRList);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="createOrder")
	@ResponseBody
	@SystemLog(module="企业用户",methods="创建认证订单")
	public Map<String, Object> find(@RequestParam int isocid,@RequestParam(defaultValue="0") Integer type) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			IsocBusinessOrder order = new IsocBusinessOrder();
			order.setIsocid(isocid);
			order.setBusinessid(cUser.getRole().getRelationid());
			order.setType(type);
			int flag = isocService.createIsocBusinessOrder(order);
			if(flag < 0) {
				return SUCCESS(resultMap, -flag);
			}else {
				return GENERALRETURN(resultMap, flag);
			}
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="updateOrderItems")
	@ResponseBody
	@SystemLog(module="企业用户",methods="提交企业认证审核项")
	public Map<String, Object> find(@RequestParam(value="files") MultipartFile[] files,@RequestParam String name,@RequestParam int isocbusinessorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			//查询项目是否存在且合法
			IsocBusinessOrder order = isocService.findIsocBusinessOrderByIsocbusinessorderid(isocbusinessorderid);
			if(order == null || order.getAuditstatus() != 0){
				return GENERALRETURN(resultMap,426);
			}
			if(files == null || files.length == 0) {
				return GENERALRETURN(resultMap,426);
			}
			//上传图片
			List<String> pathes = new ArrayList<>();
			for (int i = 0;i < files.length; i++) {
				String currentDate = DateUtil.getCurrentDate();
				pathes.add(FileUploadUtil._saveImg(files[i], currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE));
			}
			name = URLDecoder.decode(URLDecoder.decode(name,"UTF-8"),"UTF-8");
			//添加企业认证项和项目详细图片
			int flag = isocService.addIsocBusinessOrderDataItems(isocbusinessorderid,name,pathes,0);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="findAuditRecord",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="根据审核订单id查询审核记录")
	public Map<String, Object> findAuditRecord(@RequestParam int isocbusinessorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocBusinessOrderRecord> list = isocService.findIsocBusinessOrderRecord(isocbusinessorderid);
			return SUCCESS(resultMap,list);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="deleteDetail",method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="企业用户",methods="删除申请项详细")
	public Map<String, Object> deleteDetail(@RequestParam int isocbusinessorderdatadetailid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.deleteIsocBusinessOrderDataDetailByIsocbusinessorderdatadetailid(isocbusinessorderdatadetailid,0);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="newDetail",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="企业用户",methods="新增申请项详细")
	public Map<String, Object> newDetail(@RequestParam(value="file") MultipartFile file,@RequestParam int isocbusinessorderdataid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			IsocBusinessOrderDataDetail detail = new IsocBusinessOrderDataDetail();
			detail.setIsocbusinessorderdataid(isocbusinessorderdataid);
			//上传图片
			detail.setUrl(FileUploadUtil._saveImg(file, DateUtil.getCurrentDate(),config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE));
			int flag = isocService.addIsocBusinessOrderDataDetail(detail,0);
			if(flag < 0) {
				return SUCCESS(resultMap, -flag);
			}else {
				return GENERALRETURN(resultMap, flag);
			}
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="reApply",method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="企业用户",methods="重新编辑提交")
	public Map<String, Object> reApply(@RequestParam int isocbusinessorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocService.reApply(isocbusinessorderid);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
