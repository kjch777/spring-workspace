package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
	/*
	 요청 주소 매핑하는 방법
	 	1) @RequestMapping("주소")
	 	
	 	2)    @GetMapping("주소"): GET(조회) 방식 요청 매핑
	 	     @PostMapping("주소"): POST(삽입) 방식 요청 매핑
	 	      @PutMapping("주소"): PUT(수정) 방식 요청 매핑    - form, js, a 태그에는 요청 불가
	 	   @DeleteMapping("주소"): DELETE(삭제) 방식 요청 매핑 - form, js, a 태그에는 요청 불가
	 */
	
	/*
	 @GetMapping 을 사용하면, return 할 때 기본 경로로 html 파일을 가리키겠다. 라는 설정이 들어있다.
	 
	 classpath: src/main/resources
	 기본 경로에, 맨 앞에 붙여진 /templates/ 폴더가 html 파일을 담는 공간이다.
	 파일명 마지막에는 항상 .html 이 붙는다.
	 */
	// src/main/resources/templates/example.html 로 이동하겠다 라는 표시
	@GetMapping("example") // /example Get 방식 요청 매핑
	public String exampleMethod() {
		return "example";
	}
}
