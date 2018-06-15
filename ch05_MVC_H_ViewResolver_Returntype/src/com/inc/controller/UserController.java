package com.inc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String userList(Model model) {
		List<UserVo> userList = userService.getList();
		model.addAttribute("userList", userList);
		/*ModelAndView mv = new ModelAndView();
		mv.addObject("userList", userList);
		mv.setViewName("/user/list.jsp");*/
		
		return "/user/list.jsp";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String userAddForm(Model model) {
		List<BjobVo> bjobList = jobService.getBjobList();
		model.addAttribute("bjobList", bjobList);
		return "/user/add.jsp";
	}
	
	/*@RequestMapping(value="/user/add", method=RequestMethod.POST, params= {"id = admin", "name", "password"})
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
	}*/
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST, params= {"id != admin", "name", "password"})
	public ModelAndView userAdd(@ModelAttribute UserVo uvo) throws ClassNotFoundException, SQLException {
		userService.add(uvo);
		//리다이렉트
	ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/user/list");
		return mv;
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.GET)
	public String userUpdateForm(@RequestParam String id, Model model) {
		UserVo uvo = userService.selectOne(id);
		model.addAttribute("uvo", uvo);
		return "/user/modify.jsp";
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
