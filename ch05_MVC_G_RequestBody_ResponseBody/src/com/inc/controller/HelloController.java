package com.inc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.inc.vo.Person;

@Controller
public class HelloController{
	@RequestMapping("/hello/{name}/{age}")
	public ModelAndView sayHello(@PathVariable String name, @PathVariable int age) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", name + "님 안녕하세요.." + age);
		mv.setViewName("/views/hello.jsp");
		return mv;
	}
	
	@RequestMapping("/hello2")
	public ModelAndView sayHello2(@ModelAttribute Person person) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", person.getName() + "님 안녕하세요.." + person.getAge());
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
	@ResponseBody
	public String sayByePost(@CookieValue String name, @RequestBody String body) {
		System.out.println(body);
		/*Cookie[] cookies = request.getCookies();
		for(Cookie ck : cookies) {
			if(ck.getName().equals("name")) {
				System.out.println(ck.getValue());
			}
		}*/
		/*System.out.println(name);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/hello");*/
		return "hi";
	}
	
}




