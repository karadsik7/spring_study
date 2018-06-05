package com.inc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.inc.util.DbConnector;
import com.inc.util.OracleConnector;

public class CommentDao {
	
	DbConnector dbConn = new OracleConnector();
	
	public void add() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection();
	}
	
	public void get() throws ClassNotFoundException, SQLException {
		 Connection conn = dbConn.getConnection(); 
	}
	
	
	
}
