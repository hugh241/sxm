package com.suxiaomei.admin.controller.api.isoc;

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
import org.springframework.web.multipart.MultipartFile;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.aop.IIsocLog;
import com.suxiaomei.admin.common.aop.SystemLog;
import com.suxiaomei.admin.controller.api.BaseController;
import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;
import com.suxiaomei.admin.service.isoc.IsocCreditCardTemplateService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.file.FileUploadUtil;

/**
 * 家协端-阿姨模板管理
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
 * 2018年10月23日 上午11:23:00
 */
@Controller
@RequestMapping("/api/iCreditCardTemplate")
public class ICreditCardTemplateController extends BaseController{
	private static final long serialVersionUID = 1L;
	@Autowired
	private IsocCreditCardTemplateService isocCreditCardTemplateService;
	@Autowired
	private GlobalConfig config;
	
	@RequestMapping(method = {RequestMethod.GET})
	@ResponseBody
	@SystemLog(module="家协用户",methods="模板列表查询")
	@IIsocLog(module="家协用户",methods="模板列表查询")
	public Map<String, Object> find(@RequestParam String condition) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			condition = URLDecoder.decode(URLDecoder.decode(condition,"utf-8"),"utf-8");
			QueryResult<IsocCreditCardTemplate> members = isocCreditCardTemplateService.findByCondition(condition,cUser);
			return SUCCESS(resultMap,members);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST})
	@ResponseBody
	@SystemLog(module="家协",methods="新增模板")
	@IIsocLog(module="家协",methods="新增模板")
	public Map<String, Object> save(@RequestBody IsocCreditCardTemplate isocCreditCardTemplate) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocCreditCardTemplateService.save(isocCreditCardTemplate,cUser);
			if(flag < 0) {//返回错误码
				return GENERALRETURN(resultMap, -flag);
			}
			return SUCCESS(resultMap,flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST},value="uploadTemplateImg")
	@ResponseBody
	@SystemLog(module="家协",methods="上传模板图片")
	@IIsocLog(module="家协",methods="上传模板图片")
	public Map<String, Object> uploadTemplateImg(@RequestParam(value="file") MultipartFile file,@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			//上传图片
			String currentDate = DateUtil.getCurrentDate();
			String url = FileUploadUtil._saveImg(file, currentDate,config.LOCALUPLOADPATH_ORIGINAL,config.LOCALUPLOADPATH_PC,config.LOCALUPLOADPATH_MOBILE);
			//跟新模板背景图片
			int flag = isocCreditCardTemplateService.updateBackImg(id,url);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT})
	@ResponseBody
	@SystemLog(module="家协",methods="修改模板")
	public Map<String, Object> update(@RequestBody IsocCreditCardTemplate isocCreditCardTemplate) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocCreditCardTemplateService.update(isocCreditCardTemplate);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.PUT},value="use")
	@ResponseBody
	@SystemLog(module="家协",methods="启用模板")
	public Map<String, Object> updateUseStatus(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocCreditCardTemplateService.updateUseStatus(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
	
	@RequestMapping(method = {RequestMethod.DELETE})
	@ResponseBody
	@SystemLog(module="家协",methods="删除模板")
	public Map<String, Object> delete(@RequestParam int id) {
		Map<String,Object> resultMap = new HashMap<>();
		try {
			int flag = isocCreditCardTemplateService.delete(id);
			return GENERALRETURN(resultMap, flag);
		} catch (Exception e) {
			return ERROR(resultMap,e);
		}
	}
}
