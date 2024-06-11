package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// Bean: 스프링이 만들고 관리하는 표시
@Controller // 요청이나 응답을 받는 표시 / 스프링에서 Controller 로 작성하라는 명시가 되어있다.
@Slf4j // 각 메서드로 이동할 때마다 log.info 를 사용하여 위치 이동 찍기
public class IndexController {
	
	@GetMapping("cafe/cafe_index") // 주소창에서, back 과 front 가 만나는 주소(위치)
	public String cafeMainMethod() {
		log.info("cafe 메인으로 이동하기");
		return "cafe/cafe_index"; // html 파일 위치
	}

	@GetMapping("cafe/cafe_board")
	public String cafeIndexMethod() {
		log.info("cafe 게시판으로 이동하기");
		return "cafe/cafe_board";
	}
	
	@GetMapping("blog/blog-index")
	public String blogIndexMethod() {
		log.info("blog 메인으로 이동하기");
		return "blog/blog-index";
	}
	
	@GetMapping("blog/blog-board")
	public String blogBoardMethod() {
		log.info("blog 게시판으로 이동하기");
		return "blog/blog-board";
	}
	
}
