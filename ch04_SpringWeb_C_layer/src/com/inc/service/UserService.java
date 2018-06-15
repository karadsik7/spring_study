package com.inc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

public class UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<UserVo> getList() {
		List<UserVo> userList = userDao.getList();
		return userList;
	}
	
	public void addUser(UserVo uvo) throws ClassNotFoundException, SQLException {
		userDao.add(uvo);
	}
	
	
	
}
