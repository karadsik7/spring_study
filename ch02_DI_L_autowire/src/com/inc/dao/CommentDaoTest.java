package com.inc.dao;

import java.sql.SQLException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CommentDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GenericXmlApplicationContext container 
			= new GenericXmlApplicationContext("root-context.xml");
		
		CommentDao commentDao = 
				container.getBean("commentDao",CommentDao.class);
		commentDao.add();
		commentDao.get();
		
	}
}
