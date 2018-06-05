package com.inc.dao;

import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inc.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//스프링컨테이너 생성
		GenericXmlApplicationContext container =
			new GenericXmlApplicationContext("root-context.xml");
		
		//dao컨테이너 등록
		//container.load("root-context.xml");
		
		//컨테이너 새로고침
		//container.refresh();
		
		UserDaoInterface userDao = 
			container.getBean("userDao", UserDaoInterface.class);
		
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
