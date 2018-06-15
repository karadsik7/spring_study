package com.inc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.inc.service.UserService;
import com.inc.vo.UserVo;

/*@Component : 생략하는 이유 @Controller가 Component를 상속했기 때문에*/
@Controller
@RequestMapping("/user") //각 컨트롤러가 서블릿 상위경로가 같을 경우에 클래스단에 RequestMapping을 걸어 상위경로를 적을 수 있다.
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public ModelAndView userList() {
		List<UserVo> userList = userService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("/views/user/list.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView userAddForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/views/user/add.jsp");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params= {"id = admin"})
	public ModelAndView userAddAdmin(HttpServletRequest request) throws ClassNotFoundException, SQLException {
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
	
	@RequestMapping(value="/add", method=RequestMethod.POST, params= {"!id = admin"})
	public ModelAndView userAdd(HttpServletRequest request) throws ClassNotFoundException, SQLException {
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
