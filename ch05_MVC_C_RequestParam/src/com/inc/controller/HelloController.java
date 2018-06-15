package com.inc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController{
	//@RequestParam 속성
		//1. required = 반드시 있어야 메서드가 실행됨 (기본값 true, false시에는 없으면 자료형의 기본값으로 메서드 실행)
		//2. defaultValue = 파라미터가 들어오지 않았을 때 기본값
	@RequestMapping("/hello")
	public ModelAndView sayHello(@RequestParam(defaultValue="guest") String name) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", name + "님 안녕하세요..");
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




