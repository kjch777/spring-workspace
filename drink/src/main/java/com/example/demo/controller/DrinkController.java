package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.DrinkDTO;
import com.example.demo.service.DrinkService;

@Controller // 컨트롤러 클래스에 컨트롤러 어노테이션
public class DrinkController {

	@GetMapping("/") // url 을 건들지 않아도 화면에 띄우기 위하여 GetMapping 괄호 안에 / 만 작성한 것
	public String drinkForm(Model model) { 
		model.addAttribute("drinkDTO", new DrinkDTO()); // DB 에 값을 저장할 수 있도록, drink 라는 이름의 새로운 DrinkDTO 공간을 생성해준 것이다.
		return "index";
	}
	
	@Autowired // Autowired 어노테이션은
	private DrinkService drinkService; // Service 클래스와 같이 쓴다.
	
	@PostMapping("/register")
	public String insertDrink(DrinkDTO drinkDTO, Model model) { // 이 메서드 명은 
		drinkService.insertDrink(drinkDTO);
		model.addAttribute("msg", "음료 정보가 저장되었습니다.");
		return "drinkSuccess";
	}
	
}
