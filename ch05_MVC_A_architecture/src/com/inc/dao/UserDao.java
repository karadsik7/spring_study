package com.inc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.EmptyResultDataAccessException;

import com.inc.vo.UserVo;


public class UserDao {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public void add(UserVo uvo) {
		
	}

	public UserVo get(String id) {
		return null;
	}

	public void deleteAll(){
		
	}

	public int getCount() {
		return 0;
	}


	public List<UserVo> getList() {
		return sqlSession.selectList("users.getList");
	}


	


	
	
}














