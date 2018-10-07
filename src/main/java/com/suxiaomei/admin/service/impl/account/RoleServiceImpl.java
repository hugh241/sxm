package com.suxiaomei.admin.service.impl.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.account.RoleMapper;
import com.suxiaomei.admin.dao.account.RoleModuleMapper;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.RoleModule;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.RoleModuleExtend;
import com.suxiaomei.admin.service.account.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private RoleModuleMapper roleModuleDao;
	
	@Override
	public List<Role> findNormalRoleByCUser(User cUser) {
		Role role = new Role();
		role.setType(cUser.getRole().getType());
		role.setRelationid(cUser.getRole().getRelationid());
		role.setIsmanager(0);
		return roleDao.findByRole(role);
	}

	@Override
	public int add(Role role, User user) {
		role.setRelationid(user.getRole().getRelationid());
		role.setType(user.getRole().getType());
		List<Role> list = roleDao.findByRole(role);
		if(list != null && list.size() > 0) {
			return 453;
		}
		role.setIsmanager(0);
		return roleDao.insertSelective(role);
	}

	@Override
	public int update(Role role) {
		Role oR = roleDao.selectByPrimaryKey(role.getRoleid());
		if(oR == null) {
			return 426;
		}
		role.setRelationid(oR.getRelationid());
		role.setType(oR.getType());
		List<Role> list = roleDao.findByRole(role);
		if(list != null && list.size() > 0 && list.get(0).getRoleid() != role.getRoleid()) {
			return 453;//存在同名的其他角色
		}
		oR.setName(role.getName());
		oR.setDescription(role.getDescription());
		return roleDao.updateByPrimaryKeySelective(oR);
	}

	@Override
	public int delete(int roleId) {
		//查询出角色
		Role oR = roleDao.selectByPrimaryKey(roleId);
		if(oR == null || oR.getStatus() == 0) {
			return 426;
		}
		//将角色设置为删除状态
		oR.setStatus(0);
		roleDao.updateByPrimaryKeySelective(oR);
		//将角色下的所有用户设置为删除状态
		userDao.updateStatusByRoleidAndType(roleId,oR.getStatus());
		return 1;
	}

	@Override
	public int updateImpower(RoleModuleExtend roleModule) {
		Role role = roleDao.selectByPrimaryKey(roleModule.getRoleid());
		if(role == null||roleModule.getModuleids()==null||"".equals(roleModule.getModuleids())){
			return 426;
		}
		String[] moduleidArr = roleModule.getModuleids().split(",");
		List<RoleModule> rmList = roleModuleDao.getByRoleid(role.getRoleid());
		boolean contain = false;
		for (int i = 0; i < moduleidArr.length; i++) {
			int moduleid = Integer.parseInt(moduleidArr[i]);
			contain = false;
			if(rmList != null) {
				for (int j = rmList.size()-1;j >= 0; j--) {
					if(rmList.get(j).getModuleid() == moduleid) {
						contain = true;//当前模块与角色已存在关联
						rmList.remove(j);//移出已存在关联的模块
					}
				}
			}
			if(!contain) {//不存在关联，则添加关联
				RoleModule rm = new RoleModule();
				rm.setModuleid(moduleid);
				rm.setRoleid(role.getRoleid());
				roleModuleDao.insert(rm);
			}
		}
		for (int i = 0;rmList != null && i < rmList.size(); i++) {//依然存在关联模块，删除
			roleModuleDao.deleteRoleModule(roleModule.getRoleid(),rmList.get(i).getModuleid());
		}
		return 1;
	}
}
