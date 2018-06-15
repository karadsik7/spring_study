package com.inc.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.inc.dao.BookDao;
import com.inc.vo.BookVo;

public class BookService {
	private BookDao bookDao;
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookVo> selectList(Map<String, String> searchMap) {
		return bookDao.selectList(searchMap);
	}

	public void add(BookVo bookVo) {
		bookDao.add(bookVo);
	}

	public String dualCheck(String name) {
		int count = bookDao.getNameCount(name);
		if(count == 0) {
			return "n";
		}else {
			return "y";
		}
		
	}

	public String getPassword(int id) {
		return bookDao.getPassword(id);
	}
	
	public void delete(int id) {
		bookDao.delete(id);
	}
	
	public BookVo selectOne(int id) {
		return bookDao.selectOne(id);
	}

	public void update(BookVo bvo) {
		bookDao.update(bvo);
	}
	
}





