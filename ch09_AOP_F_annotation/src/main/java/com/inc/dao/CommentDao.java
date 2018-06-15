package com.inc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDao {

	@Autowired
	private SqlSession session;
	
	public void add(String msg) {
		session.insert("comments.add", msg);
	}
		

		

	
}
