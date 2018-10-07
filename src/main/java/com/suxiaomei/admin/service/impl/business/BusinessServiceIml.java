package com.suxiaomei.admin.service.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.business.BusinessMapper;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.service.business.BusinessService;
import com.suxiaomei.admin.util.QueryResult;

import net.sf.json.JSONObject;

@Service
@Transactional
public class BusinessServiceIml implements BusinessService{
	
	@Autowired
	private BusinessMapper businessDao;
	
	@Override
	public QueryResult<BusinessExtend> findByPageList(String condition) {
		JSONObject json = JSONObject.fromObject(condition);
		BusinessExtend business = new BusinessExtend();
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				business.setFullname(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("identificationstatus") && whereObj.getString("identificationstatus") != null){
				business.setIdentificationstatus(whereObj.getInt("identificationstatus"));
			}
		}
		QueryResult<BusinessExtend> businessQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		businessQ.setList(businessDao.findByPageList((businessQ.getPageIndex()-1)*businessQ.getPageSize(),businessQ.getPageSize(),business));
		businessQ.setTotalRow(businessDao.findCountByCondition(business));
		return businessQ;
	}

	@Override
	public BusinessExtend findDetailByBusinessid(int id) {
		return businessDao.findDetailByBusinessid(id);
	}

}
