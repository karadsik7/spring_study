package com.inc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.service.BoardService;
import com.inc.service.BoardServiceImpl;
import com.inc.util.Paging;
import com.inc.vo.Board;

@Controller
public class BoardController {

	private BoardService boardService;
	
	private Paging paging;
	
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String list(@RequestParam(required=false) String option,
						@RequestParam(required=false) String text,
						@RequestParam(defaultValue="1") int page,
						Model model) {
		
		String searchParam = "";
		if(option != null && !option.equals("all")) {
			searchParam = "&option="+option+"&text="+text;
		}
		
		model.addAttribute("boardList", boardService.list(option, text, page));
		model.addAttribute("paging", paging.getPaging("/board/list", page,
				boardService.getTotalCount(option, text, page), BoardServiceImpl.maxCountOfOneList, 
				BoardServiceImpl.maxCountOfOnePage,
				searchParam));
		
		return "/board/list.jsp";
	}
	
	@RequestMapping(value="/board/add", method=RequestMethod.GET)
	public String addForm() {
		return "/board/add.jsp";
	}
	
	@RequestMapping(value="/board/add", method=RequestMethod.POST)
	public String add(@ModelAttribute Board board, HttpServletRequest request) {
		board.setIp(request.getRemoteAddr());
		boardService.add(board);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/view", method=RequestMethod.GET)
	public String view(@RequestParam int id, Model model) {
		Board board = boardService.selectOneView(id);
		boardService.plusHit(id);
		model.addAttribute("board", board);
		return "/board/view.jsp";
	}
	
	@RequestMapping(value="/board/del", method=RequestMethod.POST)
	@ResponseBody
	public String del(@RequestParam int id) {
		boardService.del(id);
		return "";
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.GET)
	public String modifyForm(@RequestParam int id, Model model) {
		model.addAttribute("board", boardService.selectOneView(id));
		return "/board/modify.jsp";
	}
	
	@RequestMapping(value="/board/modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute Board board) {
		boardService.modify(board);
		return "redirect:/board/view?id=" + board.getId();
	}
	
	@RequestMapping(value="/board/comment", method=RequestMethod.GET)
	public String commentForm(@ModelAttribute Board board, Model model) {
		Board getBoard = boardService.selectOneView(board.getId());
		model.addAttribute("board", getBoard);
		return "/board/comment.jsp";
	}
	
	@RequestMapping(value="/board/comment", method=RequestMethod.POST)
	public String comment(@RequestParam int reference_id, @ModelAttribute Board board, HttpServletRequest request) {
		Board original_board = boardService.selectOneView(reference_id);
		
		int ref = original_board.getRef();
		int step = original_board.getStep() + 1;
		int depth = original_board.getDepth() + 1;
		
		board.setRef(ref);
		board.setStep(step);
		board.setDepth(depth);
		board.setIp(request.getRemoteAddr());
		
		boardService.updateStep(board);
		boardService.comment(board);
		
		return "redirect:/board/list";
	}
	
	/*@RequestMapping(value="/board/fileupload")
	public String fileupload(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload");
		
		
	}*/

	
	
	
	
	
	
}
