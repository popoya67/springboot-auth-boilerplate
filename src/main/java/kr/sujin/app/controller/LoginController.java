package kr.sujin.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.sujin.app.dto.User;
import kr.sujin.app.service.UserService;

@Controller
public class LoginController {
	public static final String LOGGED_USER = "LOGGED_USER";

	@Autowired
	private HttpSession session;

	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String loginPage() {
		return "home/home";
	}

	@PostMapping("login")
	public String login(User user, @RequestParam String orgRequestUrl) {
		User loginUser = userService.getUser(user);
		session.setAttribute(LOGGED_USER, loginUser);
		return "redirect:" + (orgRequestUrl == null ? "home" : orgRequestUrl);
	}

	@PostMapping("logout")
	public String logout() {
		session.invalidate();
		return "redirect:main";
	}
}
