package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mall.dto.Snacks;
import com.kh.mall.service.SnacksService;

// Service 에 작성해둔 기능을 종합하여, DB 와 html 파일을 연결해주는 연결고리
@Controller
public class SnacksController {
	
	@Autowired // SnacksService 에 작성된 모든 기능을 활용하겠다 라는 표시이다.(의존성 주입)
	private SnacksService snacksService;
	
	@GetMapping("allSnacks") // Mapping: 감싼다
	public String getAllSnacks(Model model) {
		List<Snacks> snackList = snacksService.getAllSnacks();
		
		// <tr th:each="s : ${snackList}">
		// html 파일에 전달할 목록들을, "snackList" 라는 변수명을 사용하여 전달하겠다 라는 표시이다.
		// Model 은 DB 에서 가져온 값을 전달해주는, 전달을 위한 연결고리이다.
		model.addAttribute("snackList", snackList);
		// SnackService 에서 추가적인 서비스 기능으로 만들어진 메서드 가져오기
		
		return "snackList";
		// return "과자 목록이 작성된 html 파일명 작성하기";
	}
}
