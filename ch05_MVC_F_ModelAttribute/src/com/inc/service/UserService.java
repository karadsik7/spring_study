package com.inc.service;

import java.sql.SQLException;
import java.util.List;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<UserVo> getList() {
		return userDao.getList();
	}

	public void add(UserVo uvo) throws ClassNotFoundException, SQLException {
		userDao.add(uvo);
		
	}
	
	public UserVo selectOne(String id) {
		return userDao.selectOne(id);
	}

	public void modify(UserVo uvo) {
		userDao.modify(uvo);
	}
	
	
}






