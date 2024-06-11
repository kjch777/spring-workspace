package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// index 라는 이름은 기본으로 가리키는 페이지 이름으로, 보통 처음 맨 앞에 있는 페이지 이름은 inex 로 설정한다.
@Controller
@Slf4j
public class IndexController {
	
	// test method 를 이용하여, test.html 파일로 무사히 이동하는지 확인하는 method 작성하기
	@RequestMapping("test")
	public String testMethod() {
		// log.info 를 사용하여, test 출력하기
		log.info("테스트 페이지로 이동하기");
		return "test";
	}
	
	// 홈페이지로 이동하는 코드 작성하기
	@RequestMapping("home")
	public String homeMethod() {
		log.info("홈페이지로 이동하는지 확인해보기");
		return "index";
	}
	
	// RequestMapping 에 작성한 명칭과 return 에 작성한 명칭은 서로 달라도 된다.
	
}
