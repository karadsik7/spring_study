package com.inc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnector {
	
	private static OracleConnector single;
	
	private OracleConnector() {
	}
	
	public static OracleConnector getInstance() {
		if(single == null) {
			single = new OracleConnector(); 
		}
		return single;
	}
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
				"spring", "1111");
		
		return conn;
	}
}
