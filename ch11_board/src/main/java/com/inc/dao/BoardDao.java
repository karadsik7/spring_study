package com.inc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.inc.vo.Board;

public class BoardDao {
	
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<Board> selectList(Map<String, Object> searchMap){
		List<Board> boardList = session.selectList("board.selectList", searchMap);
		return boardList;
	}

	public Board selectOne(int id) {
		Board board = session.selectOne("board.selectOne",id);
		return board;
	}

	public void add(Board board) {
		session.insert("board.insert", board);
	}

	public void plusHit(int id) {
		session.update("board.plusHit", id);
	}

	public void delete(int id) {
		session.delete("board.delete", id);
	}
	
	public void modify(Board board) {
		session.update("board.modify", board);
	}
	
	public int totalCount(Map<String, Object> searchMap) {
		return session.selectOne("board.totalCount", searchMap); 
	}
	
	public void comment(Board board) {
		session.insert("board.comment", board);
	}
	
	public void updateStep(Board board) {
		session.update("board.updateStep", board);
	}
}
