package com.kh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mall.dto.Member;
import com.kh.mall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("m", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model, @RequestParam("member_name") String member_name,
			                            @RequestParam("member_phone") String member_phone,
			                            HttpSession session) {
		Member member = memberService.getLogin(member_name, member_phone);
		if(member != null) { // member 객체에 일치하는 값이 있다면
			session.setAttribute("loginSession", member);
			return "redirect:/"; // 로그인 성공 시, 메인 페이지로 돌려 보내기
		} else { // 일치하는 값이 없다면
			model.addAttribute("error", "일치하는 정보가 없습니다.");
			model.addAttribute("m", new Member());
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // invalidate: 무효화 한다. 없던 일로 만든다.
		return "redirect:/";
	}
	/*
	 * HttpSession
	 * 사용자와 서버 간의 상태를 유지하는 데에 사용되는 객체이다.
	 * 상태를 유지/식별하고, 데이터 저장/수명 관리를 할 수 있다.
	 * 로그인 한 상태를 유지하게 해준다.
	 * 사용자로부터 입력받은 값과 일치하는지 식별하고,
	 * 일정 기간동안 데이터 저장,
	 * 일정 시간이 지나면 수명이 다하도록 수명을 관리할 수 있다.(일정 시간 동안 로그인 유지)
	 * */
	
}
