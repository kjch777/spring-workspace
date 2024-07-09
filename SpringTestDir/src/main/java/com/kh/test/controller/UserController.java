package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.dao.UserDAO;
import com.kh.test.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController // 만약, template [check] 오류가 발생한다면, @Controller ▶ @RestController 로 변경한다.

public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String insertUser(@RequestParam("userEmail") String usEmail) {
		UserDAO user = new UserDAO();
		user.setUsEmail(usEmail);
		userService.insertUser(user);
		return "redirect:/";
	}
	
	@GetMapping("/goodsitem/check") // Ajax 에서 url 에 작성한 값
	public Map<String, Object> existsByName(@RequestParam String itemName) {
		// 만약, DB 에 이미 동일한 상품명이 존재한다면
		boolean isCheck = userService.existsByName(itemName);
		log.info("isCheck: " + isCheck);
		log.info("itemName: " + itemName);
			Map<String, Object> res = new HashMap();
 // String == itemName, Object == isCheck
		
		// Ajax 는, return 에 html 을 작성하지 않는다.
		// html 파일 자체를 불러오는 것이 아니라, html 파일의 일부분만 설정하는 것이기 때문이다.
		res.put("isCheck", isCheck);
		log.info("isCheck: " + isCheck);
		
		return res; // Map 으로 전달된 key value 를, 다시 html 파일에서 중복확인에 전달하기
	}
}
