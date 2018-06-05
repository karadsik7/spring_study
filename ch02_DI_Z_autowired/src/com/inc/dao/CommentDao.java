package com.inc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CommentDao {
	
	@Autowired
	DataSource dbConn;

	public void add() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection();
	}
	
	public void get() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection(); 
	}
	
	
	
}
