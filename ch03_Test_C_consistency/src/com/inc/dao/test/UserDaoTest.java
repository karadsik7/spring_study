package com.inc.dao.test;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;
import static org.junit.Assert.*;

public class UserDaoTest {
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException {
		GenericXmlApplicationContext context 
			= new GenericXmlApplicationContext("root-context.xml");
		
		UserDao userDao = 
				context.getBean("userDao", UserDao.class);
		
		userDao.deleteAll();
		
		UserVo user = new UserVo();
		user.setId("flynn");
		user.setName("장동혁");
		user.setPassword("1111");
		
		userDao.add(user);
		
		UserVo savedUser = userDao.get(user.getId());
		
		assertEquals(user.getId(), 
				            savedUser.getId());
		assertEquals(user.getName(), 
				            savedUser.getName());
		assertEquals(user.getPassword(), 
				            savedUser.getPassword());
	}
	
	@Test
	public void count() throws ClassNotFoundException, SQLException {
		GenericXmlApplicationContext context 
		= new GenericXmlApplicationContext("root-context.xml");
	
		UserDao userDao = 
				context.getBean("userDao", UserDao.class);
		
		userDao.deleteAll();
		
		UserVo user1 = new UserVo("hong", "홍길동", "1234");
		UserVo user2 = new UserVo("lim", "임꺽정", "!5@678a");
		UserVo user3 = new UserVo("lee", "이방원", "asdfsf123");
		
		assertEquals(userDao.getCount(), 0);
		userDao.add(user1);
		assertEquals(userDao.getCount(), 1);
		userDao.add(user2);
		assertEquals(userDao.getCount(), 2);
		userDao.add(user3);
		assertEquals(userDao.getCount(), 3);
	}
}








