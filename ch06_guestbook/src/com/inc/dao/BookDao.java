package com.inc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.vo.BookVo;

public class BookDao {
	
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<BookVo> selectList(Map<String, String> searchMap) {
		List<BookVo> bookList = sqlSession.selectList("guestbook.selectList", searchMap);
		return bookList;
	}

	public void add(BookVo bvo) {
		sqlSession.insert("guestbook.add", bvo);
	}
	
	public void del(int id) {
		sqlSession.delete("guestbook.del", id);
	}
	
	public BookVo selectOne(int id) {
		BookVo bvo = sqlSession.selectOne("guestbook.selectOne", id);
		return bvo;
	}
	
	public void modify(BookVo bvo) {
		sqlSession.update("guestbook.modify", bvo);
	}
	
	public String getPassword(int id) {
		String password = sqlSession.selectOne("guestbook.getPassword", id);
		return password;
	}
	
	public int getWriterCheck(String writer) {
		int result = 404404;
		result = sqlSession.selectOne("guestbook.getWriterCheck", writer);
		return result;
	}
	
}
