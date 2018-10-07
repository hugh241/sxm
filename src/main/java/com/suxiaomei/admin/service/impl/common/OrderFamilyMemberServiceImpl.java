package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.common.OrderFamilyMemberMapper;
import com.suxiaomei.admin.dao.common.OrderTypeMapper;
import com.suxiaomei.admin.dao.customer.FamilyMemberMapper;
import com.suxiaomei.admin.entity.common.OrderFamilyMember;
import com.suxiaomei.admin.entity.common.OrderType;
import com.suxiaomei.admin.entity.common.extend.OrderFamilyMemberExtend;
import com.suxiaomei.admin.entity.customer.FamilyMember;
import com.suxiaomei.admin.service.common.OrderFamilyMemberService;

@Service
@Transactional
public class OrderFamilyMemberServiceImpl implements OrderFamilyMemberService{
	@Autowired
	private OrderTypeMapper orderTypeDao;
	@Autowired
	private FamilyMemberMapper familyMemberDao;
	@Autowired
	private OrderFamilyMemberMapper orderFamilyMemberDao;
	
	@Override
	public List<OrderType> findOrderTypeList() {
		List<OrderType> otList = orderTypeDao.findAll();
		return otList;
	}

	@Override
	public List<FamilyMember> findFamilyMemberList() {
		return familyMemberDao.findAll();
	}

	@Override
	public List<OrderFamilyMemberExtend> findList() {
		return orderFamilyMemberDao.findAll();
	}

	@Override
	public int add(OrderFamilyMember orderFamilyMember) {
		//查询是否存在关联
		OrderFamilyMember ofm = orderFamilyMemberDao.findByOrdertypeidAndFamilymemberid(orderFamilyMember.getOrdertypeid(),orderFamilyMember.getFamilymemberid());
		if(ofm != null) {
			return 474;
		}
		orderFamilyMemberDao.insert(orderFamilyMember);
		return 1;
	}

	@Override
	public int delete(int id) {
		return orderFamilyMemberDao.deleteByPrimaryKey(id);
	}

}
