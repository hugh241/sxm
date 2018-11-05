package com.suxiaomei.admin.service.impl.isoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.employee.EmployeeCreditCardMapper;
import com.suxiaomei.admin.dao.employee.EmployeeIdentificationMapper;
import com.suxiaomei.admin.dao.employee.EmployeeMapper;
import com.suxiaomei.admin.dao.isoc.IsocCreditCardTemplateMapper;
import com.suxiaomei.admin.dao.isoc.IsocMapper;
import com.suxiaomei.admin.dao.isoc.IsocQrcodeMapper;
import com.suxiaomei.admin.dao.isoc.TokenMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.employee.Employee;
import com.suxiaomei.admin.entity.employee.EmployeeCreditCard;
import com.suxiaomei.admin.entity.employee.EmployeeIdentification;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;
import com.suxiaomei.admin.entity.isoc.IsocQrcode;
import com.suxiaomei.admin.entity.isoc.Token;
import com.suxiaomei.admin.service.isoc.IsocCreditCardTemplateService;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.ReputationCard;
import com.suxiaomei.admin.util.file.FileUploadUtil;
import com.suxiaomei.admin.util.wx.WeixinUtil;

import net.sf.json.JSONObject;

@Service
@Transactional
public class IsocCreditCardTemplateServiceImpl implements IsocCreditCardTemplateService {
	@Autowired
	private GlobalConfig config;
	@Autowired
	private IsocCreditCardTemplateMapper isocCreditCardTemplateDao;
	@Autowired
	private EmployeeCreditCardMapper employeeCreditCardDao;
	@Autowired
	private EmployeeMapper employeeDao;
	@Autowired
	private EmployeeIdentificationMapper employeeIdentificationDao;
	@Autowired
	private IsocQrcodeMapper isocQrcodeDao;
	@Autowired
	private IsocMapper isocDao;
	@Autowired
	private TokenMapper tokenDao;

	@Override
	public QueryResult<IsocCreditCardTemplate> findByCondition(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		IsocCreditCardTemplate t = new IsocCreditCardTemplate();
		if(user.getRole().getType() == config.INT_ISOCNO){
			t.setIsocid(user.getRole().getRelationid());
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				t.setName(whereObj.getString("name").trim());
			}
			if(whereObj.has("type")){
				t.setType(whereObj.getInt("type"));
			}
		}
		QueryResult<IsocCreditCardTemplate> tQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		tQ.setList(isocCreditCardTemplateDao.findByPageList((tQ.getPageIndex()-1)*tQ.getPageSize(),tQ.getPageSize(),t));
		tQ.setTotalRow(isocCreditCardTemplateDao.findCountByCondition(t));
		return tQ;
	}

	@Override
	public int save(IsocCreditCardTemplate template, User user) {
		if(user.getRole().getType() != config.INT_ISOCNO){
			return -426;
		}
		template.setIsocid(user.getRole().getRelationid());
		template.setUsestatus(0);
		isocCreditCardTemplateDao.insertSelective(template);
		return template.getIsoccreditcardtemplateid();
	}

	@Override
	public int updateBackImg(int id, String url) {
		IsocCreditCardTemplate t = isocCreditCardTemplateDao.selectByPrimaryKey(id);
		if(t == null || t.getUsestatus() == 1){
			return 426;
		}
		t.setUrl(url);
		isocCreditCardTemplateDao.updateByPrimaryKeySelective(t);
		return 1;
	}

	@Override
	public int update(IsocCreditCardTemplate template) {
		IsocCreditCardTemplate t = isocCreditCardTemplateDao.selectByPrimaryKey(template.getIsoccreditcardtemplateid());
		if(t == null || t.getUsestatus() == 1){
			return 426;
		}
		template.setUrl(t.getUrl());
		template.setUsestatus(t.getUsestatus());
		template.setIsocid(t.getIsocid());
		isocCreditCardTemplateDao.updateByPrimaryKeySelective(template);
		return 1;
	}

	@Override
	public int updateUseStatus(int id) {
		IsocCreditCardTemplate t = isocCreditCardTemplateDao.selectByPrimaryKey(id);
		if(t == null || t.getUsestatus() == 1){
			return 426;
		}
		//重置相同类型的模板为未使用状态
		isocCreditCardTemplateDao.updateResetTemplateByTypeAndIsocid(t.getType(),t.getIsocid());
		//设置当前模板为使用状态
		t.setUsestatus(1);
		isocCreditCardTemplateDao.updateByPrimaryKeySelective(t);
		//查询出当前家协下所有阿姨信誉卡
		List<EmployeeCreditCard> list = employeeCreditCardDao.findByIsocid(t.getIsocid());
		for (int i = 0;list != null && i < list.size(); i++) {
			if(t.getType() == 1) {//正面
				//删除图片
				FileUploadUtil.deleteImg(config.LOCALUPLOADPATH_ORIGINAL+list.get(i).getFronturl(), config.LOCALUPLOADPATH_MOBILE+list.get(i).getFronturl(), config.LOCALUPLOADPATH_PC+list.get(i).getFronturl());
				list.get(i).setFronturl("");//地址置空
			}else if(t.getType() == 2) {//背面
				//删除图片
				FileUploadUtil.deleteImg(config.LOCALUPLOADPATH_ORIGINAL+list.get(i).getBehindurl(), config.LOCALUPLOADPATH_MOBILE+list.get(i).getBehindurl(), config.LOCALUPLOADPATH_PC+list.get(i).getBehindurl());
				list.get(i).setBehindurl("");
			}
			//跟新
			employeeCreditCardDao.updateByPrimaryKey(list.get(i));
		}
		return 1;
	}

	@Override
	public int delete(int id) {
		IsocCreditCardTemplate t = isocCreditCardTemplateDao.selectByPrimaryKey(id);
		if(t == null || t.getUsestatus() == 1){
			return 426;
		}
		isocCreditCardTemplateDao.deleteByPrimaryKey(id);
		return 1;
	}

	@Override
	public EmployeeCreditCard updateAndGetEmployeeCard(Integer isocid, int employeeid) {
		//查询出阿姨信息
		Employee employee = employeeDao.selectByPrimaryKey(employeeid);
		if(employee == null){
			return null;
		}
		//查询出阿姨在家协下所有认证的最后时间
		EmployeeIdentification i = employeeIdentificationDao.findEmployeeLastEnddate(employeeid, isocid,null);
		if(i == null){
			return null;
		}
		//查询该护理员在当前家协下是否有信誉卡
		EmployeeCreditCard card = employeeCreditCardDao.findByIsocidAndEmployeeid(isocid,employeeid);
		if(card == null) {
			card = new EmployeeCreditCard();
			card.setEmployeeid(employeeid);
			card.setIsocid(isocid);
		}
		card.setValiditytime(i.getEnddate());
		String qrcode = null;
		if(card.getIsocqrcodeid() == null || card.getIsocqrcodeid() == 0) {//没有二维码
			IsocQrcode iq = isocQrcodeDao.findByIsocidAndRelationidAndType(isocid,employee.getEmployeeid(),2);//二维码
			if(iq == null){
				iq = new IsocQrcode();
				Isoc isoc = isocDao.selectByPrimaryKey(isocid);
				if(isoc != null && isoc.getAppid() != null && !"".equals(isoc.getAppid()) && isoc.getAppsecret() != null && !"".equals(isoc)){
					Token token = tokenDao.findByIsocid(isocid);
					if(token != null && token.getTokenvalue() != null && token.getTokenvalue() != ""){
						String str = employeeid+"_"+isoc.getIsocid()+"_2";
						String tickt = WeixinUtil.getErCode(token.getTokenvalue(), str);
						if(tickt != null){
							qrcode = config.URL_QRCODE+tickt;
							iq.setIsocid(isoc.getIsocid());
							iq.setType(2);
							iq.setRelationid(employeeid);
							iq.setQrcode(qrcode);
							isocQrcodeDao.insert(iq);
						}
					}
				}
			}
			card.setIsocqrcodeid(iq.getIsocqrcodeid());
		}
		if("".equals(card.getFronturl())) {//没有正面
			IsocCreditCardTemplate t = isocCreditCardTemplateDao.findUseingTemplateByTypeAndIsocid(1,isocid);
			card.setFronturl(ReputationCard.createCard(employee.getName(),config.URL_DEFAULT_PORTRAIT, qrcode, t,config.LOCALUPLOADPATH_MOBILE));
		}
		if("".equals(card.getBehindurl())) {//没有背面
			IsocCreditCardTemplate t = isocCreditCardTemplateDao.findUseingTemplateByTypeAndIsocid(2,isocid);
			card.setBehindurl(ReputationCard.createCard(employee.getName(),config.URL_DEFAULT_PORTRAIT, qrcode, t,config.LOCALUPLOADPATH_MOBILE));
		}
		if(card.getEmployeecreditcardid() != null && card.getEmployeecreditcardid() > 0) {//更新
			employeeCreditCardDao.updateByPrimaryKey(card);
		}else {//新增
			employeeCreditCardDao.insert(card);
			card = employeeCreditCardDao.selectByPrimaryKey(card.getEmployeecreditcardid());
		}
		return card;
	}

}
