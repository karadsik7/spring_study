package com.inc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inc.service.UserService;
import com.inc.service.JobService;
import com.inc.vo.BjobVo;
import com.inc.vo.UserVo;

/*@Component : 생략하는 이유 @Controller가 Component를 상속했기 때문에*/
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	
	
	@RequestMapping("/user/list")
	public ModelAndView userList() {
		List<UserVo> userList = userService.getList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("/views/user/list.jsp");
		
		return mv;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public ModelAndView userAddForm() {
		List<BjobVo> bjobList = jobService.getBjobList();
		ModelAndView mv = new ModelAndView();
		mv.addObject("bjobList", bjobList);
		mv.setViewName("/views/user/add.jsp");
		return mv;
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST, params= {"id = admin", "name", "password"})
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
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST, params= {"id != admin", "name", "password"})
	public ModelAndView userAdd(@ModelAttribute UserVo uvo) throws ClassNotFoundException, SQLException {
		userService.add(uvo);
		//리다이렉트
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/user/list");
		return mv;
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.GET)
	public ModelAndView userUpdateForm(@RequestParam String id) {
		UserVo uvo = userService.selectOne(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("uvo", uvo);
		mv.setViewName("/views/user/modify.jsp");
		return mv;
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	public ModelAndView userModify(@ModelAttribute UserVo uvo) {
		ModelAndView mv = new ModelAndView();
		userService.modify(uvo);
		mv.setViewName("redirect:/user/list");
		return mv;
	}
	
	@RequestMapping(value="/user/dualCheck", method=RequestMethod.POST)
	@ResponseBody
	public String dualCheck(@RequestParam String id) {
		UserVo uvo = userService.selectOne(id);
		if(uvo == null) {
			return "no";
		}else {
			return "yes";
		}
	}
	
	
}
