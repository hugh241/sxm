package com.suxiaomei.admin.service.impl.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.common.IdentificationLogMapper;
import com.suxiaomei.admin.dao.employee.EmployeeMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.IdentificationLog;
import com.suxiaomei.admin.entity.employee.Employee;
import com.suxiaomei.admin.entity.employee.extend.EmployeeExd;
import com.suxiaomei.admin.service.employee.EmployeeService;
import com.suxiaomei.admin.util.QueryResult;

import net.sf.json.JSONObject;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeMapper employeeDao;
	@Autowired
	private GlobalConfig config;
	@Autowired
	private IdentificationLogMapper identificationLogDao;

	@Override
	public QueryResult<EmployeeExd> findByPageList(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		Employee employee = new Employee();
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.has("condition")){
				String con = whereObj.getString("condition");
				employee.setName(con);
				employee.setMobile(con);
				employee.setIdcard(con);
			}
		}
		QueryResult<EmployeeExd> employeeQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		List<EmployeeExd> list = employeeDao.findByPageList((employeeQ.getPageIndex()-1)*employeeQ.getPageSize(),employeeQ.getPageSize(),employee,user.getRole());
		employeeQ.setList(list);
		employeeQ.setTotalRow(employeeDao.findCountByCondition(employee,user.getRole()));
		return employeeQ;
	}

	@Override
	public EmployeeExd findById(int id, User cUser) {
		EmployeeExd employee = employeeDao.findDetailById(id);
		if(employee.getPhoto() != null && !"".equals(employee.getPhoto())) {
			employee.setPhoto(config.UPLOADPATH_MOBILE+employee.getPhoto());
		}
		return employee;
	}

	@Override
	public List<IdentificationLog> findPLog(int id) {
		List<IdentificationLog> ilList = identificationLogDao.findByEmployeepositionid(id);
		return ilList;
	}
	
	
}
