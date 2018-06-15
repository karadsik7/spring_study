package com.inc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dao.CommentDao;

@Service(value="commentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public void add(String msgA, String msgB) {
		commentDao.add(msgA);
		//int a = 5/0;
		commentDao.add(msgB);
	}
	
}
