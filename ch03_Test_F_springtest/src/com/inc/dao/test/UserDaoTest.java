package com.inc.dao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.inc.dao.UserDao;
import com.inc.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/root-context.xml")
public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Before
	public void setUp() throws ClassNotFoundException, SQLException {

		userDao.deleteAll();
		System.out.println("before");
	}
	
	@After
	public void tearDown() {
		System.out.println("after");
	}
	
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		
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

	@Test(expected=EmptyResultDataAccessException.class)
	public void getFail() throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		
		assertSame(userDao.getCount(), 0);
		
		userDao.get("ajofsi");
	}
	
	

}








