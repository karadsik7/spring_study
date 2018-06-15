package com.inc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inc.service.JobService;
import com.inc.vo.SjobVo;

@Controller
public class JobController {

	@Autowired
	private JobService jobService;
	
	@RequestMapping(value="/sjob/list", method=RequestMethod.POST)
	@ResponseBody
	public List<SjobVo> sjobList(@RequestParam int b_id){
		List<SjobVo> sjobList = jobService.getSjobList(b_id);
		return sjobList;
	}
	
	
}
