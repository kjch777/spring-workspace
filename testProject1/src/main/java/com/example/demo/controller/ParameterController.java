package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

// Bean: 스프링이 알아서 만들고 관리한다는 것

@Controller // 응답이나 요청에 대한 제어 역할을 명시해준 것 + Bean 등록
@RequestMapping("param") // ParameterController 부터는, 아래에 작성하는 모든 주소 앞에 param 이 자동으로 붙는다.
@Slf4j
public class ParameterController {

	// GetMapping main
	@GetMapping("main") // param/main 주소로 GET 방식 요청을 만든 것
	public String paramMain() {
		return "param/param-main"; // param 폴더 내부에 있는 param-main.html 파일 가리키기
		// return 할 때, 폴더명/파일명을 작성해준 것이다.
		// param-main.html 파일은, 템플릿 폴더 내부에 있는 파람 폴더 안에 존재한다.
		// html 파일을 가리킬 때, 기본으로 templates 이라는 폴더를 가리키고
		// templates/param/param-main.html 파일을 바라본다는 표시를 작성해준 것이다.
	}
	
	@PostMapping("test1") // param/test1 POST 방식 요청
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName");
		String inputAddress = req.getParameter("inputAddress");
		
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		// String ▶ int 로 형변환
		
		log.info("시작 확인");
		log.debug("이름 확인" + inputName);
		log.debug("나이 확인" + inputAge);
		log.debug("주소 확인" + inputAddress);
		
		return "redirect:/param/main"; // 작성이 끝나면 메인으로 돌아가기
	}
	
}
