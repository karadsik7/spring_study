package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;

import com.inc.vo.UserVo;

public class UserDao {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void add(UserVo uvo) 
					throws ClassNotFoundException, SQLException {

		Connection conn = dataSource.getConnection();
		
		String query = "insert into users values(?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, uvo.getId());
		stmt.setString(2, uvo.getPassword());
		stmt.setString(3, uvo.getName());
		
		stmt.executeQuery();
		
		stmt.close();
		conn.close();
	}

	public UserVo get(String id) throws ClassNotFoundException, SQLException, EmptyResultDataAccessException {
		Connection conn = dataSource.getConnection();
		
		String sql = "select * from users where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, id);
		
		ResultSet rs = stmt.executeQuery();
		UserVo uvo = new UserVo();
		if(rs.next()) {
			uvo.setId(rs.getString("id"));
			uvo.setName(rs.getString("name"));
			uvo.setPassword(rs.getString("password"));
		}else {
			throw new EmptyResultDataAccessException(1);
		}
		rs.close();
		stmt.close();
		conn.close();
		
		
		return uvo;
	}

	public void deleteAll() throws ClassNotFoundException, SQLException {
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = 
				conn.prepareStatement("delete from users");
		stmt.executeUpdate();
		stmt.close();
		conn.close();
	}
	
	public int getCount() throws SQLException {
		int result = 0;
		Connection conn = dataSource.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select count(*) from users");
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			result = rs.getInt("count(*)"); 	
		}
		rs.close();
		stmt.close();
		conn.close();
		return result;
	}

	public List<UserVo> getList() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<UserVo> userList = new ArrayList<>();
		try {
			conn = dataSource.getConnection();
			stmt = conn.prepareStatement("select * from users");
			rs = stmt.executeQuery();
			while(rs.next()) {
				UserVo userVo = new UserVo(rs.getString("id"), rs.getString("name"), rs.getString("password"));
				userList.add(userVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userList;
	}
	
}














