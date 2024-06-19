package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Goods;
import com.example.demo.service.GoodsService;

@Controller
public class GoodsController {
	/*
	 * 만약 클래스 이름을 Controller 로 작성하면 
	 * Spring 에 기본으로 존재하는 Controller 와 충돌이 발생하여
	 * Spring 안에 있는 Controller 기능을 사용하지 못한다.
	 * */

	// DB 에 값을 넣을 수 있도록, new Goods() 를 사용하여 값이 들어갈 빈 공간 만들어주기
	@GetMapping("/") // 첫 화면에서 볼 페이지 띄우기
	public String registerForm(Model model) {
		model.addAttribute("goods", new Goods());
		return "index";
	}
	
	// GoodsService 에 숫자 값이 아니면 들어가지 못하게 방지하거나
	// 비밀번호 암호화 설정과 같은 상세 기능을 넣고,
	// Service 를 호출하여 mapper Java 파일에 값을 전달할 수 있도록 코드 작성하기
	@Autowired
	private GoodsService goodsService;
	
	@PostMapping("/register")
	public String insertGoods(Goods goods, Model model) {
		/* Goods goods: HTML form 에, name 으로 시작하는 변수명이 있다면
		 *              Goods.java 의 변수명과 form 에 작성해둔 name 값이 서로 일치할 경우,
		 *              자동으로 Goods.java 라는 곳에서 일치하는 변수명에
		 *              form 에 작성하는 값이 즉시 임시 저장(할당) 된다. 
		 * 
		 * Model model: 돌아가기, 새로고침 등의 기능을 사용할 경우, html 파일에 데이터를 다시 전달하는 역할을 한다.
		 *              위와는 다른 의미의 임시 저장이다.*/
		goodsService.insertGoods(goods);
		
		// log
		
		model.addAttribute("msg", "상품 정보가 성공적으로 등록되었습니다.");
		return "registerSuccess";
	}
}
