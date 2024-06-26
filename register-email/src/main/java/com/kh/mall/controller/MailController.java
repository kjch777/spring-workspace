package com.kh.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.mall.service.EmailService;

import lombok.RequiredArgsConstructor;
/*
 * 자료형 앞에 final 을 붙일 때는, 다른 곳에서 해당 변수를 수정하여 문제가 생기는 것을 방지하고 싶을 때이다.
 * final: 상시적으로 수가 변하지 않는, 고정된 값이다.
 * 
 * @RequiredArgsConstructor: final 로 작성된 필드를 도와주는 생성자이다.
 * 
 * @ResponseBody: service.java 에 작성한 html 파일 코드에서 작성된 내용을,
 * json 형식으로 변환하여 사용자에게 전달할 때 사용한다.
 * 
 * {[
 * 	number: 값
 * ]} 형식이 json 형식이다.
 * */
@RequiredArgsConstructor
@Controller
public class MailController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String MailPage() {
		return "index";
	}
	
	// 이메일에서 인증 번호를 전송받은 값과 일치하는지 확인하기
	@ResponseBody
	@PostMapping("/mail")
	public String MailSend(String mail) {
		int number = emailService.sendEmail(mail);
		String num = "" + number;
		// 랜덤으로 생성된 숫자들 가져오기
		// 전달받은 숫자와 일치하는지, 확인용으로 가져오는 것이다.
		return num;
	}
}
