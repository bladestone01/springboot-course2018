package org.boot.course.controller;

import java.util.List;

import org.boot.course.dao.entity.SchoolInfo;
import org.boot.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    @Autowired
    private SchoolService shoolService;
    
	/**
	 * 展示RequestMapping用法
	 * 
	 * @return
	 */
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String home() {
		log.info("Access the home page.....");
		return "pages/homes";
	}
	
	
}
