package com.inc.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.inc.exception.ProductException;
import com.inc.service.ProductService;
import com.inc.vo.ProductVo;

@Controller
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product/list", method=RequestMethod.GET)
	public String productList(Model model){
		//logger.info("/product/list에 요청");
		model.addAttribute("productMap", productService.productMap());
		model.addAttribute("productInVo", new ProductVo());
		model.addAttribute("productOutVo", new ProductVo());
		return "/product/list.jsp";
	}
	
	@RequestMapping(value="/product/add/in", method=RequestMethod.POST)
	public String productAddIn(@ModelAttribute("productInVo") @Valid ProductVo productVo, BindingResult result, Model model) {
		//logger.info("/product/add/in에 요청");
		if(result.hasErrors()) {
			model.addAttribute("productOutVo", new ProductVo());
			model.addAttribute("productMap", productService.productMap());
			return "/product/list.jsp";
		}
		productService.addIn(productVo);
		return "redirect:/product/list";
	}
	
	@RequestMapping(value="/product/add/out", method=RequestMethod.POST)
	public String productAddOut(@ModelAttribute("productOutVo") @Valid ProductVo productVo, BindingResult result, Model model) {
		//logger.info("/product/add/out에 요청");
		if(result.hasErrors()) {
			model.addAttribute("productInVo", new ProductVo());
			model.addAttribute("productMap", productService.productMap());
			return "/product/list.jsp";
		}
		try {
			productService.addOut(productVo);
		} catch (ProductException e) {
			model.addAttribute("msg", e.getMessage());
			model.addAttribute("url", "/product/list");
			return "/error.jsp";
		}catch(RuntimeException e) {
			model.addAttribute("msg", "서버 오류입니다. 잠시 후 다시 시도하세요.");
			model.addAttribute("url", "/product/list");
			return "/error.jsp";
		}
		return "redirect:/product/list";
	}
	

	
	
}
