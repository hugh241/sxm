package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.common.ToolsMapper;
import com.suxiaomei.admin.dao.customer.FamilyMemberMapper;
import com.suxiaomei.admin.dao.customer.FamilyMemberToolsMapper;
import com.suxiaomei.admin.entity.common.Tools;
import com.suxiaomei.admin.entity.customer.FamilyMember;
import com.suxiaomei.admin.entity.customer.FamilyMemberTools;
import com.suxiaomei.admin.entity.customer.extend.FamilyMemberToolsExtend;
import com.suxiaomei.admin.service.common.FamilyMemberToolsService;

@Service
@Transactional
public class FamilyMemberToolsServiceImpl implements FamilyMemberToolsService{
	@Autowired
	private FamilyMemberMapper familyMemberDao;
	@Autowired
	private ToolsMapper toolsDao;
	@Autowired
	private FamilyMemberToolsMapper familyMemberToolsDao;
	
	@Override
	public List<FamilyMember> findFamilyMemberList() {
		return familyMemberDao.findAll();
	}

	@Override
	public List<Tools> findToolsList() {
		return toolsDao.findAll();
	}

	@Override
	public List<FamilyMemberToolsExtend> findList() {
		return familyMemberToolsDao.findList();
	}

	@Override
	public int add(FamilyMemberTools familyMemberTools) {
		//查询是否存在关联
		FamilyMemberTools fmt = familyMemberToolsDao.findByToolsidAndFamilymemberid(familyMemberTools.getToolsid(),familyMemberTools.getFamilymemberid());
		if(fmt != null) {
			return 474;
		}
		int flag = familyMemberToolsDao.insert(familyMemberTools);
		return flag;
	}

	@Override
	public int delete(int id) {
		return familyMemberToolsDao.deleteByPrimaryKey(id);
	}

}
