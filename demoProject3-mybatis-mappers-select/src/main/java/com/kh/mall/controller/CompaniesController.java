package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mall.dto.Companies;
import com.kh.mall.service.CompaniesService;

@Controller
public class CompaniesController {

	@Autowired
	private CompaniesService companiesService;
	
	@GetMapping("/allCompanies")
	public String getAllCompanies(Model model) {
		
		// 회사 목록 List 를 companyList.html 로 전달하기
		List<Companies> panyList = companiesService.getAllCompanies();
		
		// companyList.html 에 
		// 황금색 companyList 로 가져온 목록을 
		// 파란색 companyList 라는 이름으로
		// 황금색 companyList 에 적힌 목록을 전달
		model.addAttribute("comList", panyList);
		return "companyList"; // html 파일명 그대로 가져와서 작성해주기
	}
}
