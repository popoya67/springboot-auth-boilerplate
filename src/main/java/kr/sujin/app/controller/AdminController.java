package kr.sujin.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.sujin.app.annotaion.AdminOnly;

@Controller
public class AdminController {
	@GetMapping("/admin/home")
	@AdminOnly
	public String adminHome() {
		return "admin/home";
	}
}
