package com.kh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mall.dto.Login;
import com.kh.mall.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("l", new Login());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model, @RequestParam("username") String username,
			                            @RequestParam("password") String password,
			                            HttpSession session) {
		Login login = loginService.getLogin(username, password);
		if(login != null) {
			session.setAttribute("loginSession", login);
			return "redirect:/";
		} else {
			model.addAttribute("error", "일치하는 정보가 없습니다.");
			model.addAttribute("l", new Login());
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
