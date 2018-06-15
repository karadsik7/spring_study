package com.inc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.service.CartService;
import com.inc.vo.CartVo;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/cart/list", method=RequestMethod.GET)
	public String list(@RequestParam String u_id, Model model) {
		List<CartVo> cartList = cartService.cartList(u_id);
		
		int total = cartService.getTotal(u_id);
		model.addAttribute("total", total);
		model.addAttribute("cartList", cartList);
		return "/cart/list.jsp";
	}
	
	@RequestMapping(value="/cart/insert")
	@ResponseBody
	public String insert(@RequestParam Map<String, Object> idMap) {
		String result = cartService.insert(idMap);
		return result;
	}
	
	@RequestMapping(value="/cart/del", method=RequestMethod.GET)
	public String del(@RequestParam int id, @RequestParam String u_id) {
		cartService.del(id);
		return "redirect:/cart/list?u_id="+u_id;
	}
	
	@RequestMapping(value="/cart/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute CartVo cvo) {
		cartService.modify(cvo);
		return "redirect:/cart/list?u_id=" + cvo.getU_id();
	}
	
	
}
