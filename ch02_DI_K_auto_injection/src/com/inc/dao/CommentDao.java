package com.inc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CommentDao {
	
	DataSource dbConn;
	
	public CommentDao(DataSource dbConn) {
		this.dbConn = dbConn;
	}

	public void add() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection();
	}
	
	public void get() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection(); 
	}
	
	
	
}
