package com.inc.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.inc.service.UserService;
import com.inc.service.JobService;
import com.inc.vo.BjobVo;
import com.inc.vo.UserVo;

/*@Component : 생략하는 이유 @Controller가 Component를 상속했기 때문에*/
@Controller
@SessionAttributes(value= {"uvo"})
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private JobService jobService;
	
	
	@RequestMapping("/user/list")
	public String userList(Model model) {
		List<UserVo> userList = userService.getList();
		model.addAttribute("userList", userList);
		
		return "/user/list.jsp";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String userAddForm(Model model) {
		List<BjobVo> bjobList = jobService.getBjobList();
		model.addAttribute("bjobList", bjobList);
		return "/user/add.jsp";
	}
	
	@RequestMapping(value="/user/add", method=RequestMethod.POST, params= {"id != admin", "name", "password"})
	public String userAdd(@ModelAttribute UserVo uvo) throws ClassNotFoundException, SQLException {
		userService.add(uvo);
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.GET)
	public String userUpdateForm(@RequestParam String id, Model model) {
		UserVo uvo = userService.selectOne(id);
				//request.getSession().setAttribute("uvo", uvo);
		//클래스 레벨 @SessionAttributes("uvo")
		//세션에 같은 이름의 키값의 밸류가 저장
		model.addAttribute("uvo", uvo);
		return "/user/modify.jsp";
	}
	
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	public String userModify(@ModelAttribute("uvo") UserVo uvo, SessionStatus status) {
		//@ModelAttribute("uvo")
		//세션의 uvo와 파라미터로 가져온 모델의 uvo를 대조해서 모델의 uvo중 null 값을 자동으로 세션에서 충당한다.
		
				//UserVo sessionUvo = (UserVo)session.getAttribute("uvo");
				//uvo.setId(sessionUvo.getId());
		userService.modify(uvo);
				//session.invalidate();
		//@SessionAttributes에 저장된 객체를 모두 null로 변경
		status.setComplete();
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/user/dualCheck", method=RequestMethod.POST)
	@ResponseBody
	public String dualCheck(@RequestParam String id) {
		UserVo uvo = userService.selectOne(id);
		if(uvo == null) {
			return "notDual";
		}else {
			return "dual";
		}
	}
	
	
}
