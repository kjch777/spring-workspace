package com.kh.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mall.dto.Goods;

@Controller
public class IndexController {

	// index.html 파일로 주소를 이동할 때 사용할 GetMapping 작성하기
	@GetMapping("/productRegister")
	public String productRegister(Model model) {
		model.addAttribute("goods", new Goods());
		return "productRegister";
	}
}
