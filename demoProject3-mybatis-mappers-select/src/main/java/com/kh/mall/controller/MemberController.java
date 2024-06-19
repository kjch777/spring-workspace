package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mall.dto.Member;
import com.kh.mall.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	// Controller 클래스 안에 Service 불러오기(공간 생성은 아닌 것 같다.)
	
	@GetMapping("/allMembers") // index.html 화면에서 미리 지정해둔, 클릭 시 이동할 url 주소와 동일하게 작성해준다. 
	public String getAllMember(Model model) {
		
		List<Member> memInfoList = memberService.getAllMember();
		
		model.addAttribute("meminfo", memInfoList);
		// memberList.html 파일에서,
		// <tr th:each="m : ${memInfo}"> 
		// 안에 있는 이름과 같아야 한다.
		
		return "memberList"; // html 파일명
	}
}
