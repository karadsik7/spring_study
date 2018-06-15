package com.inc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.inc.service.UserService;
import com.inc.vo.UserVo;

public class UserAddController implements Controller {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public ModelAndView handleRequest(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		if(request.getMethod().equals("GET")) {
			//get방식으로 요청이 왔을 때
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/views/user/add.jsp");
			return mv;
		}else {
			//post방식으로 요청이 왔을 때
			UserVo uvo = new UserVo(
						request.getParameter("id"),
						request.getParameter("name"),
						request.getParameter("password"));
			userService.add(uvo);
			//리다이렉트
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/user/list");
			return mv;
		}
		
	}
	
}




