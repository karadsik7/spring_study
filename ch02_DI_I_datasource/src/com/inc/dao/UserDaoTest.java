package com.inc.dao;

import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inc.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//스프링 컨테이너 생성
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("root-context.xml");
		//DAO 컨테이너 등록
		//container.load("root-context.xml");
		//컨테이너 새로고침
		//container.refresh();
		
		UserDao userDao = container.getBean("userDao", UserDao.class);
		System.out.println(UserDao.class);
		
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
