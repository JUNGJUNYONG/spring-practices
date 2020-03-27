package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@RequestMapping({"","/main"})
	public String update() {
		System.out.println("okok");
		return "return";
	}

}
