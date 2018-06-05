package com.inc.dao.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;


public class UserDaoTest {
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("root-context.xml");
		
		UserDao userDao = context.getBean("userDao", UserDao.class);
		
		userDao.deleteAll();
		
		UserVo user = new UserVo();
		user.setId("abc");
		user.setName("ㅇㅇㅇ");
		user.setPassword("1234");
		
		userDao.add(user);
		
		UserVo savedUser = userDao.get(user.getId());
		
		Assert.assertEquals(user.getId(), savedUser.getId());
		Assert.assertEquals(user.getName(), savedUser.getName());
		Assert.assertEquals(user.getPassword(), savedUser.getPassword());
		
	}
	
}
