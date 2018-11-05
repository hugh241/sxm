package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.account.ContactMapper;
import com.suxiaomei.admin.entity.account.Contact;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.service.common.ContactService;
/**
 * 联系人管理
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
 * 2018年10月8日 上午11:02:12
 */
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactMapper contactDao;

	@Override
	public List<Contact> findAll(User user) {
		return contactDao.findByRelationidAndType(user.getRole().getRelationid(), user.getRole().getType());
	}

	@Override
	public int add(Contact contact, User user) {
		contact.setType(user.getRole().getType());
		contact.setRelationid(user.getRole().getRelationid());
		return contactDao.insert(contact);
	}

	@Override
	public int update(Contact c) {
		Contact contact = contactDao.selectByPrimaryKey(c.getContactid());
		contact.setPhone(c.getPhone());
		contact.setName(c.getName());
		return contactDao.updateByPrimaryKey(contact);
	}

	@Override
	public int delete(int id) {
		contactDao.deleteByPrimaryKey(id);
		return 1;
	}
}
