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
		System.out.println(savedUser.getId().equals(user.getId()));
		System.out.println(savedUser.getName().equals(user.getName()));
		System.out.println(savedUser.getName());
		System.out.println(user.getName());
		System.out.println(savedUser.getPassword().equals(user.getPassword()));
		
		boolean idTest = savedUser.getId().equals(user.getId());
		boolean nameTest = savedUser.getName().equals(user.getName());
		boolean passwordTest = savedUser.getPassword().equals(user.getPassword());
		
		if(!idTest) {
			System.out.println("아이디 테스트 실패");
		}else if(!nameTest) {
			System.out.println("이름 테스트 실패");
		}else if(!passwordTest) {
			System.out.println("패스워드 테스트 실패");
		}else {
			System.out.println("성공");
		}
		

	}

}
