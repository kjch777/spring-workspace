package com.example.demo.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.MemberService;

@Controller // DB 와 templates 를 연결해주는 연결고리이다.
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원가입을 위해 작성할 GetMapping 설정하기
	// url 에 /register 를 입력해야 회원가입을 할 수 있게 만드려면 /register
	// url 에 아무것도 입력하지 않은 상태에서도 화면이 정상적으로 출력되게 만드려면 / 만 작성해 주면 된다.
	@GetMapping("/")
	
	// 메서드 이름은 영어로 작성해주는 것이 좋다.
	public String joinForm(Model model) {
		model.addAttribute("mem", new Member());
		return "index";
	}
	
	// 추후 회원가입을 완료하면 보여질 PostMapping 설정하기
	@PostMapping("/register")
	public String insertMember(Member member, Model model) {
		// 회원가입 폼 작성이 완료되면 DB 에 저장하겠다.
		
		// 호출명 insertMember 로 통일하기
		memberService.insertMember(member);
		
		// model.addAttribute("select 로 DB 에 저장된 회원가입 정보 가져오기");
		model.addAttribute("msg", "회원가입이 정상적으로 완료되었습니다.");
		return "success";
	}
}
