package com.inc.service;

import java.util.List;

import com.inc.vo.Board;

public interface BoardService {

	List<Board> list(String option, String text, int page);

	int getTotalCount(String option, String text, int page);
	
	void add(Board board);

	Board selectOneView(int id);

	void plusHit(int id);

	void del(int id);

	void modify(Board board);

	void updateStep(Board board);

	void comment(Board board);

}
