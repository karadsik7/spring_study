package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommentController {

	@RequestMapping(value="/comment/list", method=RequestMethod.GET)
	public String list(HttpSession session) {
		
		return "/comment/list.jsp";
	}
	
}
