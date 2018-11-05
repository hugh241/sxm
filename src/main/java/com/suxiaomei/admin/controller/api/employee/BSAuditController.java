package com.suxiaomei.admin.controller.api.employee;

import java.net.URLDecoder;
import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.business.extend.BusinessGoodsExtend;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationOrderExtend;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;
import com.suxiaomei.admin.entity.isoc.extend.IsocEmpowerExtend;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.service.employee.EmployeeIdentificationOrderService;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.file.FileUploadUtil;

/**
 * 企业 提交阿姨审核管理
 * @author zl
 */
@Controller
@RequestMapping("/api/bsaudit") 
public class BSAuditController extends BaseController {
	private static final long serialVersionUID = 1L;
	@Autowired
	private EmployeeIdentificationOrderService employeeIdentificationOrderService;
	@Autowired
	private IsocService isocService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GlobalConfig config;
	
	@RequestMapping(value="auditB",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="查询阿姨认证送审单位")
	public Map<String, Object> find(HttpServletRequest request) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocEmpowerExtend> isocRList = isocService.findIsocEmpower(cUser);
			return SUCCESS(resultMap,isocRList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="getIsocGoodsByIsocid",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="根据家协id查询企业产品(包括未购买的)")
	public Map<String, Object> getIsocGoodsByIsocid(@RequestParam int isocid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<BusinessGoodsExtend> isocRList = goodsService.findBusinessGoodsByIsocidAndBusinessidForBusinesss(isocid,cUser.getRole().getRelationid());
			return SUCCESS(resultMap,isocRList);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(value="findAuditConfig",method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="根据家协id查询护理员认证配置列表")
	public Map<String, Object> findAuditConfig(@RequestParam int isocid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			List<IsocBusinessDataConfigure> isocRList = isocService.findIsocBusinessDataConfiguresForBByIsocid(isocid,1);
			resultMap.put("data", isocRList);
			return SUCCESS(resultMap);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="createOrder")
	@ResponseBody
	@SystemLog(module="企业用户",methods="创建护理员认证订单")
	public Map<String, Object> find(@RequestBody EmployeeIdentificationOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			order.setBusinessid(cUser.getRole().getRelationid());
			int flag = employeeIdentificationOrderService.createEmployeeIdentificationOrder(order);
			if(flag < 0){//返回新增的订单id
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
	@SystemLog(module="企业用户",methods="提交阿姨认证审核项")
	public Map<String, Object> find(@RequestParam(value="files") MultipartFile[] files,@RequestParam String name,
			@RequestParam int employeeidentificationorderid) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			if(files == null || files.length == 0) {
				return GENERALRETURN(resultMap, 426);
			}
			EmployeeIdentificationOrder order = employeeIdentificationOrderService.selectByPrimaryKey(employeeidentificationorderid);
			if(order == null || order.getIdentificationstatus() != 0){//审核中的订单才能提交认证项
				return GENERALRETURN(resultMap, 426);
			}
			List<String> pathes = new ArrayList<>();
			for (int i = 0;i < files.length; i++) {//上传图片
				String currentDate = DateUtil.getCurrentDate();
				pathes.add(FileUploadUtil._saveImg(files[i], currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE));
			}
			name = URLDecoder.decode(URLDecoder.decode(name,"UTF-8"),"UTF-8");
			//添加企业认证项和项目详细图片
			int flag = isocService.addIsocBusinessOrderDataItems(employeeidentificationorderid,name,pathes,1);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="企业用户",methods="查询提交的认证")
	public Map<String, Object> find(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<EmployeeIdentificationOrderExtend> isocRList = employeeIdentificationOrderService.findByCondition(condition,3,cUser);
			resultMap.put("data", isocRList);
			return SUCCESS(resultMap);
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
			int flag = isocService.deleteIsocBusinessOrderDataDetailByIsocbusinessorderdatadetailid(isocbusinessorderdatadetailid,1);
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
			int flag = isocService.addIsocBusinessOrderDataDetail(detail,1);
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
	public Map<String, Object> reApply(@RequestBody EmployeeIdentificationOrder order) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = employeeIdentificationOrderService.reApply(order);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
