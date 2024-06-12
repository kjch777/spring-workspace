package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // spring
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 요청 또는 응답 제어 역할을 명시한 것/Bean: Spring 에서 어떤 기능을 할지 설정해놓은 값
@RequestMapping("example")// /example 로 시작하는 주소를 해당 컨트롤러에 넣어준다.
@Slf4j // lombok 라이브러리가 제공하는 로그 객체 자동 생성 어노테이션
public class ExampleController {
	/*
	 Model
	  - Spring 에서, 데이터 전달 역할을 하는 객체이다.
	  - org.springframework.ui 패키지이다.
	  - @SessionAttributes 와 함께 사용할 경우, session scope 를 반환한다.
	  
	 [기본 사용법]
	 	Model.addAttribute("key", value);
	 */
	
	@GetMapping("ex1") // /example/ex1 주소로 보여지는 값
	public String ex1(HttpServletRequest req, Model model) {
		// 나중에 데이터 베이스에서 가져온 값을 보여줄 때 사용하는 메서드이다.
		req.setAttribute("test1", "HttpServletRequest 로 전달한 값");
		model.addAttribute("test2", "Model 로 전달한 값");
		
		return "example/ex1"; // templates/example/ex1.html 파일을 가리키는 것이다.
	}
	
}
