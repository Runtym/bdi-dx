package com.bdi.sp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.NaverService;
import com.bdi.sp.vo.Naver;
import com.bdi.sp.vo.TransParam;

@Controller
public class TransController {
	private static final Logger log = 
			LoggerFactory.getLogger(TransController.class);
	
	@Autowired
	private NaverService ns;
	
	@RequestMapping(value="/trans",method=RequestMethod.GET,produces="application/json;charset=utf-8")
	public @ResponseBody Naver trans(@ModelAttribute TransParam tp) {
		return ns.getTrans(tp);
	}
}
