package com.inc.service;

import java.util.List;
import java.util.Map;

import com.inc.vo.BookVo;

public interface BookService {
	public List<BookVo> selectList(Map<String, String> searchMap);
	
	public void add(BookVo bookVo);
	
	public String dualCheck(String name);
	
	public String getPassword(int id);
	
	public void delete(int id);
	
	public BookVo selectOne(int id);
	
	public void update(BookVo bvo);
	
}
