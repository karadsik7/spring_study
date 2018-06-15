package com.inc.controller;

import java.util.HashMap;
import java.util.List;
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

import com.inc.dao.BookDao;
import com.inc.vo.BookVo;

@Controller
public class BookController {
	
	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@RequestMapping(value="/book/list", method=RequestMethod.GET)
	public String bookList(@RequestParam(required=false) String search_option, @RequestParam(required=false) String search_text, Model model) {
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("search_option", search_option);
		searchMap.put("search_text", search_text);
		List<BookVo> bookList = bookDao.selectList(searchMap);
		model.addAttribute("bookList", bookList);
		return "/book/list.jsp";
	}
	
	
	@RequestMapping(value="/book/writercheck", method=RequestMethod.POST)
	@ResponseBody
	public int wCheck(@RequestParam String writer) {
		int check = bookDao.getWriterCheck(writer);
		return check;
	}
	
	@RequestMapping(value="/book/add", method=RequestMethod.GET)
	public String addForm(Model model) {
		model.addAttribute("userBookVo", new BookVo());
		return "/book/add.jsp";
	}
	
	@RequestMapping(value="/book/add", method=RequestMethod.POST)
	public String add(@ModelAttribute("userBookVo") @Valid BookVo userBookVo, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "/book/add.jsp";
		}else {
			userBookVo.setIp(request.getRemoteAddr());
			bookDao.add(userBookVo);
			return "redirect:/book/list";
		}
	}
	
	@RequestMapping(value="/book/delete", method=RequestMethod.GET)
	public String del(@RequestParam int id) {
		bookDao.del(id);
		return "redirect:/book/list";
	}
	
	@RequestMapping(value="/book/password", method=RequestMethod.POST)
	@ResponseBody
	public String password(@RequestParam int id) {
		String password = bookDao.getPassword(id);
		return password;
	}
	
	@RequestMapping(value="/book/modify", method=RequestMethod.GET)
	public String modifyForm(@RequestParam int id, Model model) {
		BookVo bvo = bookDao.selectOne(id);
		model.addAttribute("modifyBookVo", bvo);
		return "/book/modify.jsp";
	}
	
	@RequestMapping(value="/book/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("modifyBookVo") @Valid BookVo bvo, BindingResult result) {
		if(result.hasErrors()) {
			return "/book/modify.jsp";
		}else {
			bookDao.modify(bvo);
			return "redirect:/book/list";
		}
	}
	
	
	
	
}
