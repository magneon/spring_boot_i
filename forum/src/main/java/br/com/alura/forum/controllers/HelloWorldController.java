package br.com.alura.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@ResponseBody
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}

}
