package com.inc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inc.vo.Person;

@Controller
public class HelloController{
	@RequestMapping("/hello")
	public String sayHello(@RequestParam String name, @RequestParam int age, Model model) {
		String msg = name + "님 안녕하세요.." + age;
		model.addAttribute("msg", msg);
		return "/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String sayHello2(@ModelAttribute Person person, Model model) {
		model.addAttribute("msg", person.getName() + "님 안녕하세요.." + person.getAge() + "세");
		return "/hello.jsp";
	}
	
	@RequestMapping(value="/bye", method=RequestMethod.GET)
	public String sayBye() {
		return "/bye.jsp";
	}
	
	@RequestMapping(value="/bye", method=RequestMethod.POST)
	@ResponseBody
	public String sayByePost(@CookieValue String name, @RequestBody String body) {
		System.out.println(body);
		return "hi";
	}
	
}




