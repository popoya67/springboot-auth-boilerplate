package kr.sujin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.sujin.app.annotaion.LoginRequired;

@Controller
public class HomeController {
	@GetMapping("/home")
	@LoginRequired
	public String homePage() {
		return "/home/home";
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "/home/main";
	}
}
