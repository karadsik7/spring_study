package com.inc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.inc.service.UserService;
import com.inc.vo.UserVo;

public class UserListController implements Controller{
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		List<UserVo> userList = userService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("/views/user/list.jsp");
		
		return mv ;
	}
	
}






