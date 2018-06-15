package com.inc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inc.dao.BoardDao;
import com.inc.vo.Board;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao;
	
	public static final int maxCountOfOneList = 5;
	public static final int maxCountOfOnePage = 3;

	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	public List<Board> list(String option, String text, int page) {
		
		Map<String, Object> searchMap = getSearchMap(option, text, page);
		
		return boardDao.selectList(searchMap);
	}

	@Override
	public int getTotalCount(String option, String text, int page) {
		
		return boardDao.totalCount(getSearchMap(option, text, page));
	}
	
	private Map<String, Object> getSearchMap(String option, String text, int page){
		int startRownum = (page - 1) * maxCountOfOneList + 1;
		int endRownum = startRownum + (maxCountOfOneList - 1);
		
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("start", startRownum);
		searchMap.put("end", endRownum);
		searchMap.put("option", option);
		searchMap.put("text", text);
		
		return searchMap;
	}

	@Override
	public void add(Board board) {
		boardDao.add(board);
	}

	@Override
	public Board selectOneView(int id) {
		return boardDao.selectOne(id);
	}

	@Override
	public void plusHit(int id) {
		boardDao.plusHit(id);
	}

	@Override
	public void del(int id) {
		boardDao.delete(id);
	}

	@Override
	public void modify(Board board) {
		boardDao.modify(board);
	}

	@Override
	public void updateStep(Board board) {
		boardDao.updateStep(board);
	}

	@Override
	public void comment(Board board) {
		boardDao.comment(board);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
