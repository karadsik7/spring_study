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
		//별다른 비지니스 로직이 없으면 dao가 전달해주는 모델을 리턴함
		return userDao.getList();
	}

	public void add(UserVo uvo) throws ClassNotFoundException, SQLException {
		userDao.add(uvo);
		
	}
	
	
}






