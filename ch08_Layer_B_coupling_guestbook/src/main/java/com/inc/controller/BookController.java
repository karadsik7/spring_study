package com.inc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.inc.service.BookService;
import com.inc.vo.BookVo;

@Controller
@SessionAttributes("bvo")
public class BookController{
	
	private BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	

	@RequestMapping(value = "/book/list", method = RequestMethod.GET)
	public String bookList(@RequestParam(required = false) String search_option,
			@RequestParam(required = false) String search_text, Model model) {
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("search_option", search_option);
		searchMap.put("search_text", search_text);
		model.addAttribute("bookList", bookService.selectList(searchMap));
		return "/book/list.jsp";
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.GET)
	public String bookAdd(Model model) {
		model.addAttribute("bookVo", new BookVo());
		return "/book/add.jsp";
	}

	@RequestMapping(value = "/book/add", method = RequestMethod.POST)
	public String bookAdd(@ModelAttribute @Valid BookVo bookVo, BindingResult result, HttpServletRequest request) {
		bookVo.setIp(request.getRemoteAddr());
		if (result.hasErrors()) {
			return "/book/add.jsp";
		}
		bookService.add(bookVo);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/book/dualCheck", method = RequestMethod.GET)
	@ResponseBody
	public String dualCheck(@RequestParam String name) {
		String result = bookService.dualCheck(name);
		return result;
	}

	@RequestMapping(value = "/book/password", method = RequestMethod.POST)
	@ResponseBody
	public String password(@RequestParam int id) {
		return bookService.getPassword(id);
	}

	@RequestMapping(value = "/book/delete", method = RequestMethod.GET)
	public String delete(@RequestParam int id) {
		bookService.delete(id);
		return "redirect:/book/list";
	}

	@RequestMapping(value = "/book/update", 
			        method = RequestMethod.GET)
	public String update(@RequestParam int id, Model model) {
		BookVo bookVo = bookService.selectOne(id);
		model.addAttribute("bvo", bookVo);
		return "/book/update.jsp";
	}
	@RequestMapping(value="/book/update",
			        method=RequestMethod.POST)
	public String update(@ModelAttribute("bvo") BookVo bvo) {
		bookService.update(bvo);
		return "redirect:/book/list";
	}

}






