package com.suxiaomei.admin.service.impl.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.account.UserNoteMessageMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.UserNoteMessage;
import com.suxiaomei.admin.service.account.UserNoteMessageService;

@Service
@Transactional
public class UserNoteMessageServiceImpl implements UserNoteMessageService{
	@Autowired
	private UserNoteMessageMapper userNoteMessageDao;

	@Override
	public List<UserNoteMessage> findByConditionAndType(String condition,int type, User cUser) {
		List<UserNoteMessage> list = userNoteMessageDao.findListByCondition(condition,type,cUser.getUserid());
		return list;
	}

	@Override
	public int updateRead(int id) {
		UserNoteMessage message = userNoteMessageDao.selectByPrimaryKey(id);
		if(message.getReadstatus() == 0){
			message.setReadstatus(1);
			return userNoteMessageDao.updateByPrimaryKey(message);
		}
		return 426;
	}
}
