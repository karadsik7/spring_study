package com.inc.dao;

import java.sql.SQLException;

import com.inc.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao userDao = new UserDao();
		
		//users테이블에서 모든 튜플 삭제
		userDao.deleteAll();
		
		UserVo user = new UserVo();
		
		user.setId("flynn123");
		user.setName("장동");
		user.setPassword("1111asdas!");
		
		userDao.add(user);
		
		
		UserVo savedUser = userDao.get(user.getId());
		System.out.println(savedUser.getId());
		System.out.println(savedUser.getName());
		System.out.println(savedUser.getPassword());

	}

}
