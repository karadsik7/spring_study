package com.inc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inc.util.OracleConnector;
import com.inc.vo.UserVo;

public class UserDao {

	//코드의 문제점
	//1. Connection 코드의 중복
	
	
	public void add(UserVo uvo) throws ClassNotFoundException, SQLException {
		Connection conn = OracleConnector.getInstance().getConnection();
		String query = "insert into users values(?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, uvo.getId());
		stmt.setString(2, uvo.getPassword());
		stmt.setString(3, uvo.getName());
		stmt.executeUpdate();
		stmt.close();
		conn.close();
	}
	
	public UserVo get(String id) throws SQLException, ClassNotFoundException {
		UserVo user = new UserVo();
		Connection conn = OracleConnector.getInstance().getConnection();
		String query = "select * from users where id = ?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			user.setId(rs.getString("id"));
			user.setPassword(rs.getString("password"));
			user.setName(rs.getString("name"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return user;
	}
	
}
