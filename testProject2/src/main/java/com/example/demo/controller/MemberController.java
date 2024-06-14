package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("member")
public class MemberController {
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model) {
		MemberDTO mem = new MemberDTO();
		
		mem.setMemberName("ABC");
		mem.setMemberPhone("010-0000-0000");
		mem.setMemberAge(0);
		model.addAttribute("mem", mem);
		
		List<MemberDTO> memList = new ArrayList();
		memList.add(new MemberDTO("신짱구", "010-1234-5678", 10));
		memList.add(new MemberDTO("김철수", "010-9876-5432", 10));
		memList.add(new MemberDTO("이유리", "010-0101-1010", 10));
		model.addAttribute("memList", memList);
		
		return "member/memberInfo";
	} 

}
