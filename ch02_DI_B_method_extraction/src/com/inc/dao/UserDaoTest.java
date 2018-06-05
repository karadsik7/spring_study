package com.inc.dao;

import java.sql.SQLException;

import com.inc.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		UserDao userDao = new UserDao();
		UserVo user = new UserVo();
		
		/*user.setId("test1");
		user.setName("테스트1");
		user.setPassword("12345");
		userDao.add(user);*/
		
		UserVo getUser = userDao.get("test1");
		
		System.out.println(getUser.getId());
		System.out.println(getUser.getPassword());
		System.out.println(getUser.getName());
		
		

	}

}
