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
	
	private SqlSession session;
	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	public void add(UserVo uvo) {
		session.insert("users.add", uvo);
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
		return session.selectList("users.getList");
	}
	
	public UserVo selectOne(String id) {
		return session.selectOne("users.selectOne", id);
	}

	public void modify(UserVo uvo) {
		session.update("users.modify", uvo);
	}
	
	
	


	


	
	
}














