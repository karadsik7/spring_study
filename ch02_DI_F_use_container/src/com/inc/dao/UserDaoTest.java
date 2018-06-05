package com.inc.dao;

import java.sql.SQLException;

import com.inc.util.OracleConnector;
import com.inc.vo.UserVo;

import container.DaoContainer;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DaoContainer daoContainer = new DaoContainer();
		UserDao userDao = daoContainer.userDao();
		
		//users테이블에서 모든 튜플 삭제
		userDao.deleteAll();
		
		UserVo user = new UserVo();
		
		user.setId("test");
		user.setName("테스트");
		user.setPassword("1234");
		
		userDao.add(user);
		
		
		UserVo savedUser = userDao.get(user.getId());
		System.out.println(savedUser.getId());
		System.out.println(savedUser.getName());
		System.out.println(savedUser.getPassword());

	}

}
