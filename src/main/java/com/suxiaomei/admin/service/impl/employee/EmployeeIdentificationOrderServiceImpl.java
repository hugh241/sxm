package com.suxiaomei.admin.service.impl.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.business.BusinessGoodsMapper;
import com.suxiaomei.admin.dao.business.BusinessMapper;
import com.suxiaomei.admin.dao.common.GoodsMapper;
import com.suxiaomei.admin.dao.common.IdentificationLogMapper;
import com.suxiaomei.admin.dao.employee.EmployeeCheckMapper;
import com.suxiaomei.admin.dao.employee.EmployeeIdentificationMapper;
import com.suxiaomei.admin.dao.employee.EmployeeIdentificationOrderMapper;
import com.suxiaomei.admin.dao.employee.EmployeeIdentificationOrderRecordMapper;
import com.suxiaomei.admin.dao.employee.EmployeePositionMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderDataMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderMapper;
import com.suxiaomei.admin.dao.isoc.IsocEmpowerFirmMapper;
import com.suxiaomei.admin.dao.isoc.IsocGoodsMapper;
import com.suxiaomei.admin.dao.isoc.IsocQrcodeMapper;
import com.suxiaomei.admin.dao.isoc.TokenMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.BusinessGoods;
import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.common.IdentificationLog;
import com.suxiaomei.admin.entity.employee.EmployeeCheck;
import com.suxiaomei.admin.entity.employee.EmployeeIdentification;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrderRecord;
import com.suxiaomei.admin.entity.employee.EmployeePosition;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationOrderExtend;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;
import com.suxiaomei.admin.entity.isoc.IsocQrcode;
import com.suxiaomei.admin.entity.isoc.Token;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;
import com.suxiaomei.admin.service.employee.EmployeeIdentificationOrderService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.EmployeeBackgroundCheckJsonUtil;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.Util;
import com.suxiaomei.admin.util.http.HttpClientUtil;
import com.suxiaomei.admin.util.wx.WeixinUtil;

import net.sf.json.JSONObject;
/**
 * 护理员认证申请订单
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
 * 2018年10月16日 上午9:45:46
 */
@Service
@Transactional
public class EmployeeIdentificationOrderServiceImpl implements EmployeeIdentificationOrderService{
	@Autowired
	private GlobalConfig config;
	@Autowired
	private EmployeeIdentificationOrderMapper employeeIdentificationOrderDao;
	@Autowired
	private IsocGoodsMapper isocGoodsDao;
	@Autowired
	private IsocBusinessOrderMapper isocBusinessOrderDao;
	@Autowired
	private IsocBusinessOrderDataMapper isocBusinessOrderDataDao;
	@Autowired
	private EmployeeCheckMapper employeeCheckDao;
	@Autowired
	private GoodsMapper goodsDao;
	@Autowired
	private IsocQrcodeMapper isocQrcodeDao;
	@Autowired
	private TokenMapper tokenDao;
	@Autowired
	private EmployeeIdentificationMapper employeeIdentificationDao;
	@Autowired
	private EmployeePositionMapper employeePositionDao;
	@Autowired
	private IdentificationLogMapper identificationLogDao;
	@Autowired
	private EmployeeIdentificationOrderRecordMapper employeeIdentificationOrderRecordDao;
	@Autowired
	private IsocEmpowerFirmMapper isocEmpowerFirmDao;
	@Autowired
	private BusinessGoodsMapper businessGoodsDao;
	@Autowired
	private BusinessMapper businessDao;
	
	@Override
	public QueryResult<EmployeeIdentificationOrderExtend> findByCondition(String condition, int status, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		Map<String, Object> map = new HashMap<>();
		map.put("iStatus", 0);//默认查询申请中的认证记录（首次申请 二次申请 三次申请）
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			map.put("status", 1);
			if(whereObj.has("condition") && whereObj.get("condition") != null){
				map.put("condition", whereObj.getString("condition").trim());
			}
			if(whereObj.has("identificationstatus") && status == 1) {//查询历史认证（包括所有驳回和认证通过的记录）
				map.put("iStatus", whereObj.getInt("identificationstatus"));
			}
			if(whereObj.has("identificationstatus") && whereObj.getInt("identificationstatus") >= 0 && status == 3) {//根据审核状态查询（对应到每一个状态）
				map.put("identificationstatus", whereObj.getInt("identificationstatus"));
				map.remove("iStatus");//移出默认查询状态
			}
		}
		if(user.getRole().getType() == config.INT_ISOCNO) {//家协查询
			map.put("isocid", user.getRole().getRelationid());
		}else if(user.getRole().getType() == config.INT_BUSINESS) {//企业查询
			map.put("businessid", user.getRole().getRelationid());
			map.put("sStatus", status);//查询状态：3提交申请企业查询 ！3审核企业查询
		}
		QueryResult<EmployeeIdentificationOrderExtend> orderQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		List<EmployeeIdentificationOrderExtend> list = employeeIdentificationOrderDao.findByPageList((orderQ.getPageIndex()-1)*orderQ.getPageSize(),orderQ.getPageSize(),map);
		for (int i = 0;list != null && i < list.size(); i++) {
			String[] pArr = list.get(i).getWorktype().split(",");
			StringBuffer pStr = new StringBuffer();
			for (int j = 0;pArr != null && j < pArr.length; j++) {
				IsocGoodsExtend isocGoods = isocGoodsDao.findDetailById(Integer.parseInt(pArr[j]));
				pStr.append(isocGoods.getGoods().getName()).append(",");
			}
			if(pStr.length() > 0){
				list.get(i).setPositionStr(pStr.substring(0, pStr.length()-1));
			}
		}
		orderQ.setList(list);
		orderQ.setTotalRow(employeeIdentificationOrderDao.findCountByCondition(map));
		return orderQ;
	}



	@Override
	public int authIsocOrderItem(IsocBusinessOrderData data) {
		IsocBusinessOrderData d = isocBusinessOrderDataDao.selectByPrimaryKey(data.getIsocbusinessorderdataid());
		if(d == null){
			return 426;
		}
		if(d.getType() == 0){//企业认证数据项
			IsocBusinessOrder order = isocBusinessOrderDao.findByIsocbusinessorderdataid(d.getIsocbusinessorderdataid());
			if(order == null || order.getAuditstatus() != 0){
				return 426;
			}
		}else if(d.getType() == 1){//护理员认证数据项
			EmployeeIdentificationOrder order = employeeIdentificationOrderDao.findByIsocbusinessorderdataid(d.getIsocbusinessorderdataid());
			if(order.getIdentificationstatus() != 0 && order.getIdentificationstatus() != 2 && order.getIdentificationstatus() != 4){
				return 426;
			}
		}else{
			return 426;
		}
		if(data.getAuditstatus() == 1 || data.getAuditstatus() == 2){
			d.setAuditstatus(data.getAuditstatus());
		}else{
			return 426;
		}
		return isocBusinessOrderDataDao.updateByPrimaryKey(d);
	}

	@Override
	public Object backgroundCheck(EmployeeIdentificationOrder order) {
		EmployeeIdentificationOrderExtend eiOrderExtend = employeeIdentificationOrderDao.findDetailByPrimaryKey(order.getEmployeeidentificationorderid());
		if(eiOrderExtend == null || (eiOrderExtend.getIdentificationstatus() != 0 && eiOrderExtend.getIdentificationstatus() != 2 && eiOrderExtend.getIdentificationstatus() != 4)){
			return 426;//数据有误
		}
		//查询提交数据是否完善
		if(order.getSchool() == null || "".equals(order.getSchool())){
			return 426;//数据有误
		}
		//检测认证子项通过驳回情况
		if(eiOrderExtend.getDatas() == null || eiOrderExtend.getDatas().size() == 0) {//没有认证子项，直接返回提交数据错误
			return 426;
		}
		if(order.getExercisesscore() < 80 || order.getTheoryscore() < 80){
			return 485;//培训分数不合格
		}
		for (int i = 0; i < eiOrderExtend.getDatas().size(); i++) {
			if(eiOrderExtend.getDatas().get(i).getAuditstatus() == 0) {//存在认证项没审核
				return 479;
			}else if(eiOrderExtend.getDatas().get(i).getAuditstatus() == 2) {//存在驳回项，不进行背调
				return 426;
			}
		}
		
		//进行背调
		Map<String,Object> map;
		EmployeeCheck check = new EmployeeCheck();
		//查询该订单是否背调过了
		if(eiOrderExtend.getEmployeecheckid() != null && eiOrderExtend.getEmployeecheckid() > 0){
			check = employeeCheckDao.selectByPrimaryKey(eiOrderExtend.getEmployeecheckid());
			map = EmployeeBackgroundCheckJsonUtil.returnMapByJSON(check.getResult());
			return map;
		}
		
		//背调该阿姨
		check.setEmployeeid(eiOrderExtend.getEmployeeid());
		check.setIdcard(eiOrderExtend.getEmployee().getIdcard());
		String result;
		if(config.ISBACKCHECK){
			result = HttpClientUtil.doPostEmployeeBackgroundCheck(eiOrderExtend.getEmployee().getName(),eiOrderExtend.getEmployee().getIdcard(),
					config.EMPLOYEE_BACKGROUND_CHECK_URL,config.EMPLOYEE_BACKGROUND_CHECK_USERID,
					config.EMPLOYEE_BACKGROUND_CHECK_PASSWORD,config.EMPLOYEE_BACKGROUND_CHECK_PRODUCTID);
		}else{
			result = "{\"code\":200,\"data\":{\"reportId\":\"201807270000093672\",\"reportDetail\":{\"01\":[{\"queryCost\":0.0,\"itemId\":\"1170315165001801003\",\"itemName\":\"身份验证\",\"itemCode\":\"001\",\"cateName\":\"校验类\",\"cateCode\":\"01\",\"isSuccess\":false}],\"02\":[{\"queryCost\":5.0,\"itemId\":\"1709011710017921008\",\"itemName\":\"个人涉诉记录\",\"itemData\":[{\"itemPropLabel\":\"裁判文书\",\"itemPropName\":\"cpwsList\",\"itemPropValue\":[[{\"itemPropLabel\":\"时间\",\"itemPropName\":\"sortTime\",\"itemPropValue\":\"2015年06月01日\",\"set\":false},{\"itemPropLabel\":\"裁判文书ID\",\"itemPropName\":\"cpwsId\",\"itemPropValue\":\"c2015luxingchu49_t20150601\",\"set\":false},{\"itemPropLabel\":\"裁判文书内容\",\"itemPropName\":\"cpwsContent\",\"itemPropValue\":\"...县人民法院 0.0 历洋洋...\",\"set\":false},{\"itemPropLabel\":\"裁判文书标题\",\"itemPropName\":\"cpwsTitle\",\"itemPropValue\":\"被告人历**犯强奸罪一案\",\"set\":false},{\"itemPropLabel\":\"判决法院\",\"itemPropName\":\"sentenceCourt\",\"itemPropValue\":\"河南省鹿邑县人民法院\",\"set\":false},{\"itemPropLabel\":\"案号\",\"itemPropName\":\"refNum\",\"itemPropValue\":\"（2015）鹿刑初字第49号\",\"set\":false},{\"itemPropLabel\":\"涉诉类型\",\"itemPropName\":\"typesOfLitigation\",\"itemPropValue\":\"刑事判决书\",\"set\":false}]],\"set\":true},{\"itemPropLabel\":\"曝光台\",\"itemPropName\":\"bgtList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"执行公告\",\"itemPropName\":\"zxggList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"网贷黑名单\",\"itemPropName\":\"wdhmdList\",\"itemPropValue\":[],\"set\":true},{\"itemPropLabel\":\"失信公告\",\"itemPropName\":\"sxggList\",\"itemPropValue\":[],\"set\":true}],\"itemCode\":\"135\",\"cateName\":\"查询类\",\"cateCode\":\"02\",\"isSuccess\":true}],\"03\":[{\"queryCost\":1.12,\"itemId\":\"1170417191610363057\",\"itemName\":\"不良信息验证\",\"itemCode\":\"205\",\"cateName\":\"黑名单类\",\"cateCode\":\"03\",\"isSuccess\":false}]}}}";
		}
		map = EmployeeBackgroundCheckJsonUtil.returnMapByJSON(result);
		if(map == null) {
			return 480;
		}
		check.setResult(result);
		//判断背调是否成功
		if(!map.containsKey("ispass")) {
			return 480;
		}
		if((boolean)map.get("ispass")) {
			check.setViastatus(1);//背调通过
		}
		employeeCheckDao.insert(check);
		EmployeeIdentificationOrder eiOrder = employeeIdentificationOrderDao.selectByPrimaryKey(eiOrderExtend.getEmployeeidentificationorderid());
		//更新订单
		eiOrder.setEmployeecheckid(check.getEmployeecheckid());
		eiOrder.setSchool(order.getSchool());
		eiOrder.setTheoryscore(order.getTheoryscore());
		eiOrder.setExercisesscore(order.getExercisesscore());
		employeeIdentificationOrderDao.updateByPrimaryKey(eiOrder);
		return map;
	}



	@Override
	public int authApply(EmployeeIdentificationOrder order) {
		EmployeeIdentificationOrderExtend eiOrderExtend = employeeIdentificationOrderDao.findDetailByPrimaryKey(order.getEmployeeidentificationorderid());
		if(eiOrderExtend == null || (eiOrderExtend.getIdentificationstatus() != 0 && eiOrderExtend.getIdentificationstatus() != 2 && eiOrderExtend.getIdentificationstatus() != 4)){
			return 426;//数据有误
		}
		//查询提交数据是否完善
		if(order.getSchool() == null || "".equals(order.getSchool()) || order.getExercisesscore() == 0 || order.getTheoryscore() == 0){
			return 426;//数据有误
		}

		EmployeeIdentificationOrder eiOrder = employeeIdentificationOrderDao.selectByPrimaryKey(order.getEmployeeidentificationorderid());
		//检测认证子项通过驳回情况
		if(eiOrderExtend.getDatas() == null || eiOrderExtend.getDatas().size() == 0) {//没有认证子项，直接驳回
			eiOrder.setIdentificationstatus(eiOrder.getIdentificationstatus()+1);//驳回
		}else {
			for (int i = 0; i < eiOrderExtend.getDatas().size(); i++) {
				if(eiOrderExtend.getDatas().get(i).getAuditstatus() == 0) {//存在认证项没审核
					return 479;
				}else if(eiOrderExtend.getDatas().get(i).getAuditstatus() == 2) {//设置订单状态未驳回
					eiOrder.setIdentificationstatus(eiOrder.getIdentificationstatus()+1);
					break;
				}
			}
		}
		
		eiOrder.setAdopttime(DateUtil.getCurrentTime());
		eiOrder.setSchool(order.getSchool());
		eiOrder.setExercisesscore(order.getExercisesscore());
		eiOrder.setTheoryscore(order.getTheoryscore());
		if(order.getIdentificationstatus() == 5) {//前台主动驳回
			eiOrder.setIdentificationstatus(5);//直接驳回且不能重复提交（背调不通过）
		}else {
			if(eiOrder.getIdentificationstatus() == 0 || eiOrder.getIdentificationstatus() == 2 || 
					eiOrder.getIdentificationstatus() == 4) {//所有认证子项都通过
				//判断分数是否通过
				if(eiOrder.getExercisesscore() < 80 || eiOrder.getTheoryscore() < 80){//分数不通过，驳回
					eiOrder.setIdentificationstatus(eiOrder.getIdentificationstatus()+1);
				}else {//所有子项认证通过且考核分数通过，默认审核通过
					eiOrder.setIdentificationstatus(6);
				}
			}
		}
		//查询本次认证的所有产品列表
		List<Goods> goodsList = new ArrayList<>();
		String[] pArr = eiOrder.getWorktype().split(",");//家协产品id数组
		for (int j = 0;j < pArr.length; j++){
			Goods goods = goodsDao.findByIsocgoodsid(Integer.parseInt(pArr[j]));
			goodsList.add(goods);
		}
		
		if(eiOrder.getIdentificationstatus() == 6){//认证通过
			//跟新订单
			eiOrder.setResult("审核通过");
			employeeIdentificationOrderDao.updateByPrimaryKey(eiOrder);
			if(eiOrderExtend.getIsoc().getAppid() != null && !"".equals(eiOrderExtend.getIsoc().getAppid()) && 
					eiOrderExtend.getIsoc().getAppsecret() != null && !"".equals(eiOrderExtend.getIsoc())) {//查询阿姨是否存在与家协对应的二维码
				IsocQrcode qrcode = isocQrcodeDao.findByIsocidAndRelationidAndType(eiOrderExtend.getIsoc().getIsocid(), eiOrder.getEmployeeid(), 2);
				if(qrcode == null){//为认证通过的阿姨生成二维码
					Token token = tokenDao.findByIsocid(eiOrderExtend.getIsoc().getIsocid());
					if(token != null && token.getTokenvalue() != null && !"".equals(token.getTokenvalue())){
						String value = eiOrder.getEmployeeid()+"_"+eiOrderExtend.getIsoc().getIsocid()+"_2";
						String tickt = WeixinUtil.getErCode(token.getTokenvalue(), value);
						if(tickt != null){
							String url = config.URL_QRCODE+tickt;
							IsocQrcode iq = new IsocQrcode();
							iq.setIsocid(eiOrderExtend.getIsoc().getIsocid());
							iq.setType(2);
							iq.setRelationid(eiOrder.getEmployeeid());
							iq.setQrcode(url);
							isocQrcodeDao.insert(iq);
						}
					}
				}
			}
			for (int i = 0;i < goodsList.size(); i++) {
				//新增护理员认证信息
				EmployeeIdentification ei = new EmployeeIdentification();
				ei.setEmployeeid(eiOrder.getEmployeeid());
				ei.setIsocid(eiOrderExtend.getIsoc().getIsocid());
				ei.setEmployeeidentificationorderid(eiOrder.getEmployeeidentificationorderid());
				ei.setWorktype(goodsList.get(i).getGoodsid());
				ei.setAdopttime(DateUtil.getCurrentTime());
				//查询该护理员在当前家协下对当前工种认证的最后的结束时间
				EmployeeIdentification hei = employeeIdentificationDao.findEmployeeLastEnddate(ei.getEmployeeid(),ei.getIsocid(),ei.getWorktype());
				if(hei != null){
					ei.setBegindate(DateUtil.addDaysToDateStr(hei.getEnddate(), 1));
				}else{
					ei.setBegindate(DateUtil.getCurrentDate());
				}
				ei.setEnddate(DateUtil.addYearsToDateStr(ei.getBegindate(), 1));
				employeeIdentificationDao.insert(ei);
				//添加护理员工种操作记录
				EmployeePosition position = employeePositionDao.findByEmployeeidAndType(eiOrder.getEmployeeid(), goodsList.get(i).getPositionid());
				identificationLogDao.insert(new IdentificationLog(position.getEmployeepositionid(),position.getType(),DateUtil.getCurrentTime(),"【"+eiOrderExtend.getIsocEmpowerFirm().getName()+ "】通过认证","有效期："+ei.getBegindate()+"至"+ei.getEnddate()));
			}
		}else{//驳回
			//更新认证申请状态
			eiOrder.setResult(order.getResult());
			eiOrder.setRemark(order.getRemark());
			employeeIdentificationOrderDao.updateByPrimaryKey(eiOrder);
			for (int i = 0;i < goodsList.size(); i++) {//添加护理员工种操作记录
				EmployeePosition position = employeePositionDao.findByEmployeeidAndType(eiOrder.getEmployeeid(), goodsList.get(i).getPositionid());
				identificationLogDao.insert(new IdentificationLog(position.getEmployeepositionid(),position.getType(),DateUtil.getCurrentTime(),"【"+eiOrderExtend.getIsocEmpowerFirm().getName()+ "】驳回该认证",""));
			}
		}
		//添加审核记录
		EmployeeIdentificationOrderRecord  record = new EmployeeIdentificationOrderRecord();
		record.setEmployeeidentificationorderid(eiOrder.getEmployeeidentificationorderid());
		record.setResult(eiOrder.getResult());
		employeeIdentificationOrderRecordDao.insert(record);
		return 1;
	}

	@Override
	public int createEmployeeIdentificationOrder(EmployeeIdentificationOrder order) {
		IsocEmpowerFirm firm = isocEmpowerFirmDao.selectByPrimaryKey(order.getIsocempowerfirmid());
		if(firm == null){
			return 426;
		}
		Business business = businessDao.selectByPrimaryKey(order.getBusinessid());
		if(order.getWorktype() == null || order.getWorktype().split(",").length == 0){
			return 426;
		}
		order.setOrdernum(Util.getOrderNo());
		//判断当前企业是否有认证产品的次数，如果次数满足更新企业产品消耗次数
		String[] isocgoodsids = order.getWorktype().split(",");
		for (int i = 0; i < isocgoodsids.length; i++) {
			if(!Util.isNumeric(isocgoodsids[i])){//传入工种不为数字
				Util.callBackT();
				return 426;
			}
			int isocgoodsid = Integer.parseInt(isocgoodsids[i]);
			//根据家协产品id查询当前企业购买该产品的次数
			BusinessGoods businessGoods = businessGoodsDao.findByBusinessidAndIsocGoodsid(order.getBusinessid(),isocgoodsid);
			if(businessGoods == null || businessGoods.getTotal()<=businessGoods.getConsume()){//产品数量不足
				Util.callBackT();//回滚
				return 482;
			}
			//数量足够，添加消耗
			businessGoods.setConsume(businessGoods.getConsume()+1);
			businessGoodsDao.updateByPrimaryKey(businessGoods);
			
			//创建工种认证日志
			Goods goods = goodsDao.findByIsocgoodsid(isocgoodsid);
			if(goods == null){
				Util.callBackT();
				return 426;
			}
			EmployeePosition ep = employeePositionDao.findByEmployeeidAndType(order.getEmployeeid(), goods.getPositionid());
			if(ep == null){
				ep = new EmployeePosition();
				ep.setEmployeeid(order.getEmployeeid());
				ep.setType(goods.getPositionid());
				employeePositionDao.insert(ep);
			}
			identificationLogDao.insert(new IdentificationLog(ep.getEmployeepositionid(),isocgoodsid,DateUtil.getCurrentTime(),"【"+business.getFullname() + "】提交资料给【"+firm.getName()+"】认证", ""));
		}
		employeeIdentificationOrderDao.insert(order);
		return -order.getEmployeeidentificationorderid();
	}



	@Override
	public EmployeeIdentificationOrder selectByPrimaryKey(int employeeidentificationorderid) {
		return employeeIdentificationOrderDao.selectByPrimaryKey(employeeidentificationorderid);
	}



	@Override
	public int reApply(EmployeeIdentificationOrder order) {
		EmployeeIdentificationOrderExtend o = employeeIdentificationOrderDao.findDatasDetailByPrimaryKey(order.getEmployeeidentificationorderid());
		if(o == null || (o.getIdentificationstatus() != 1 && o.getIdentificationstatus() != 3)){
			return 426;
		}
		o.setIdentificationstatus(o.getIdentificationstatus()+1);
		for (int i = 0;i < o.getDatas().size(); i++) {
			if(o.getDatas().get(i).getAuditstatus() == 2){//驳回
				o.getDatas().get(i).setAuditstatus(0);//修改认证项为审核中
				isocBusinessOrderDataDao.updateByPrimaryKey(o.getDatas().get(i));
			}
		}
		employeeIdentificationOrderDao.updateByPrimaryKey(o);
		return 1;
	}
}
