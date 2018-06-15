package com.inc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	@RequestMapping("/hello/{name}/{age}")
	public ModelAndView sayHello(@PathVariable String name, @PathVariable int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", name + "님 안녕하세요.." + age);
		mv.setViewName("/views/hello.jsp");
		return mv;
	}
	
	@RequestMapping(value="/bye", method=RequestMethod.GET)
	public ModelAndView sayBye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("views/bye.jsp");
		return mv;
	}
	
	@RequestMapping(value="/bye", method=RequestMethod.POST)
	public ModelAndView sayByePost() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("views/bye.jsp");
		System.out.println("post");
		mv.setViewName("redirect:/hello");
		return mv;
	}
	
}




