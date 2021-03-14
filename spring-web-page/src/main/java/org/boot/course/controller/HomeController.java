package org.boot.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@RequestMapping(value="/index")
	public String home() {
		log.info("Ready to access home.....");
		return "/pages/home.html";
	}

}
