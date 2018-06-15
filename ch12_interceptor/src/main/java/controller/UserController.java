package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDao;
import vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value="/user/signin", method=RequestMethod.POST)
	public String signIn(@ModelAttribute UserVo userVo, HttpSession session, Model model) {
		UserVo savedUserVo = userDao.selectOne(userVo.getId(), userVo.getPassword());
		if(savedUserVo == null) {
			//로그인 실패
			model.addAttribute("msg", "아이디 혹은 비밀번호가 틀립니다.");
			model.addAttribute("url", "redirect:/main");
			return "/error.jsp";
		}else {
			//로그인 성공
			session.setAttribute("vo", savedUserVo);
			return "redirect:/main";
		}
	}
	
}
