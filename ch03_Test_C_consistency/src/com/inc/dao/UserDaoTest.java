package com.inc.dao;

import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.inc.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//스프링컨테이너 생성
		GenericXmlApplicationContext container =
			new GenericXmlApplicationContext("root-context.xml");
		
		//dao컨테이너 등록http://yookeun.github.io/java/2014/07/04/spring-component-scan/
		//container.load("root-context.xml");
		
		//컨테이너 새로고침
		//container.refresh();
		
		UserDao userDao = 
			container.getBean("userDao", UserDao.class);
		
		//users테이블에서 모든 튜플 삭제
		userDao.deleteAll();
		
		UserVo user = new UserVo();
		
		user.setId("flynn");
		user.setName("장동혁");
		user.setPassword("1111asdas!");
		
		userDao.add(user);
		
		UserVo savedUser = userDao.get(user.getId());
		/*System.out.println("아이디:"+
			savedUser.getId().equals(user.getId()));
		System.out.println("이름:"+
			savedUser.getName().equals(user.getName()));
		System.out.println("비밀번호:"+
			savedUser.getPassword().equals(user.getPassword()));*/
		
		boolean idTest = 
				savedUser.getId().equals(user.getId());
		boolean nameTest = 
				savedUser.getName().equals(user.getName());
		boolean passwordTest =
				savedUser.getPassword().equals(user.getPassword());
		
		if(!idTest) {
			System.out.println("아이디테스트에 실패했습니다.");
		}else if(!nameTest) {
			System.out.println("이름테스트에 실패했습니다.");
		}else if(!passwordTest) {
			System.out.println("비밀번호테스트에 실패했습니다.");
		}else {
			System.out.println("테스트에 성공했습니다.");
		}
	}

}





