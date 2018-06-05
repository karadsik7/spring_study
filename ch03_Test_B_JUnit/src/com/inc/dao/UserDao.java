package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.vo.UserVo;
@Component("userDao")
public class UserDao{
	
	//@Autowired -> byType으로 검색 후 조건에 일치하지 않는 경우 byName으로 검색
	@Autowired
	private DataSource dbConn;

	public void add(UserVo uvo) 
					throws ClassNotFoundException, SQLException {

		Connection conn = dbConn.getConnection();
		
		String query = "insert into users values(?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, uvo.getId());
		stmt.setString(2, uvo.getPassword());
		stmt.setString(3, uvo.getName());
		
		stmt.executeQuery();
		
		stmt.close();
		conn.close();
	}

	public UserVo get(String id) throws ClassNotFoundException, SQLException {
		Connection conn = dbConn.getConnection();
		
		String sql = "select * from users where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		rs.next();
		
		UserVo uvo = new UserVo();
		uvo.setId(rs.getString("id"));
		uvo.setName(rs.getString("name"));
		uvo.setPassword(rs.getString("password"));
		
		rs.close();
		stmt.close();
		conn.close();
		
		return uvo;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException {
		Connection conn = dbConn.getConnection();
		PreparedStatement stmt = 
				conn.prepareStatement("delete from users");
		stmt.executeUpdate();
		stmt.close();
		conn.close();
	}
	
}














