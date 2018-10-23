package com.bdi.sp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.JapanService;
import com.bdi.sp.vo.Japan;

@Controller
public class JapanController {

	private static final Logger logger = LoggerFactory.getLogger(JapanController.class);
	
	@Autowired
	private JapanService js;
	//
	@RequestMapping(value="/japans",method=RequestMethod.GET)
	public @ResponseBody List<Japan> japanList(@ModelAttribute Japan j){
		return js.getJapanList(j);
	}
	
	@RequestMapping(value="/japans/{jpnum}",method=RequestMethod.GET)
	public  @ResponseBody Japan japan(@PathVariable int jpnum){
		return js.getJapan(jpnum);
	}
	
	@RequestMapping(value="/japans/{jpnum}",method=RequestMethod.POST)
	public @ResponseBody int insertJapan(@ModelAttribute Japan j ,@PathVariable Integer jpnum){
		logger.debug("japan->{}",j);
		return js.insertJapan(j);
	}
	
	@RequestMapping(value="/japans/{jpnum}",method=RequestMethod.PUT)
	public @ResponseBody int updateJapan(@RequestBody Japan j,@PathVariable Integer jpnum){
		logger.debug("japan->{}",j);
		return js.updateJapan(j); 
	}
	
	@RequestMapping(value="/japans/{jpnum}",method=RequestMethod.DELETE)
	public @ResponseBody int deleteJapan(@PathVariable int jpnum){
		return js.deleteJapan(jpnum);
	}
	
	
	
	
}
