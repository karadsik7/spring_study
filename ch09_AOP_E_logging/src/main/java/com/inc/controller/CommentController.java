package com.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/comment/add")
	@ResponseBody
	public String commentAdd(@RequestParam String msgA, @RequestParam String msgB) {
		commentService.add(msgA, msgB);
		return msgA + msgB;
	}
	
	
}
