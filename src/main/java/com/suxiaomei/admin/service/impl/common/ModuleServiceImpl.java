package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.account.RoleModuleMapper;
import com.suxiaomei.admin.dao.common.ModuleMapper;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.RoleModule;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.service.common.ModuleService;
/**
 * 菜单模块
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
 * 2018年9月25日 下午1:18:08
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	private ModuleMapper moduleDao;
	@Autowired
	private RoleModuleMapper roleModuleDao;
	
	@Override
	public List<Module> getMenu(User user) {
		List<Module> moduleList = moduleDao.findByRoleid(user.getRoleid());
		return moduleList;
	}

	@Override
	public boolean isRight(Role role, String module) {
		RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(role.getRoleid(),module,role.getType());
		if(rm != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Module> getAllModulesByRoleid(int id) {
		return moduleDao.findAllByRoleid(id);
	}

}
