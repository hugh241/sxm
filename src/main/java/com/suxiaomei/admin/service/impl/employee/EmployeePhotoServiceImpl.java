package com.suxiaomei.admin.service.impl.employee;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.employee.EmployeePhotoMapper;
import com.suxiaomei.admin.entity.employee.EmployeePhoto;
import com.suxiaomei.admin.service.employee.EmployeePhotoService;
import com.suxiaomei.admin.util.QueryResult;

import net.sf.json.JSONObject;

@Service
@Transactional
public class EmployeePhotoServiceImpl implements EmployeePhotoService{
	@Autowired
	private EmployeePhotoMapper employeePhotoDao;
	@Autowired
	private GlobalConfig config;

	@Override
	public QueryResult<EmployeePhoto> findByCondition(String condition) {
		JSONObject json = JSONObject.fromObject(condition);
		EmployeePhoto photo = new EmployeePhoto();
		if(json.containsKey("type")) {//0头像 1生活照 2证件照
			photo.setType(json.getInt("type"));
		}
		if(json.containsKey("auditingstatus")) {
			photo.setAuditingstatus(json.getInt("auditingstatus"));
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.has("employeeid")){
				photo.setEmployeeid(whereObj.getInt("employeeid"));
			}
		}
		QueryResult<EmployeePhoto> employeeQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		List<EmployeePhoto> list = employeePhotoDao.findByPageList((employeeQ.getPageIndex()-1)*employeeQ.getPageSize(),employeeQ.getPageSize(),photo);
		for(int i = 0;list != null && i < list.size();i++) {
			list.get(i).setPhotourl(config.UPLOADPATH_MOBILE+list.get(i).getPhotourl());
		}
		employeeQ.setList(list);
		employeeQ.setTotalRow(employeePhotoDao.findCountByCondition(photo));
		return employeeQ;
	}

}
