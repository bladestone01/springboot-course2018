package org.boot.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String home() {
		System.out.println("Access to the Home page....");
		return "pages/sayhello";
	}
}
