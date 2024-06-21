package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.dto.Pig;
import com.kh.mall.service.PigService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class PigController {
	
	@Autowired
	private PigService pigService;
	
	@GetMapping("/")
	public String getAllPigs(Model model) {
		List<Pig> pigs = pigService.getAllPigs();
		log.info("pigs: " + pigs);
		model.addAttribute("pigs", pigs);
		return "index";
	}
	
	@GetMapping("/pigDetail/{pig_id}")
	public String getPigById(Model model, @PathVariable int pig_id) {
		Pig pig = pigService.getPigById(pig_id);
		model.addAttribute("pig", pig);
		return "pigDetail";
	}
/*
	// application.properties 에 error 경로를 지정하고,
	// 설정에서 지정된 경로를 찾아 발생한다.
	@RequestMapping("/error")
	public String getError() {
		return "error";
	}
*/
	/***** 돼지 정보를 업로드 할 수 있는 주소로 이동할 수 있게, @GetMapping 작성하기 *****/
	@GetMapping("/imgUpload") // 여기에는 사용자 화면에 실제로 출력될 URL 주소값을 작성한다.
	// html 파일과 java 파일이 서로 만날 수 있게 설정해 주는 것이다.
	// 해킹 방지를 위해 실제 html 파일 이름과는 다르게 작성해 주는 것이 좋다.
	// 똑같은 값이 index.html 에 있다.
	
	public String uploadForm(Model model) {
		model.addAttribute("p", new Pig()); // DB 에 올릴 수 있게, 공간 만들어주기
		return "imgUpload"; // html 파일 이름
	}
	
	/***** 돼지 정보를 DB 에 업로드 할 수 있게, @PostMapping 작성하기 *****/
	@PostMapping("/upload") // form action 값과 같다.
	public String inputPig(/* @RequestParam 으로 파일을 하나씩 가져오기*/
			@RequestParam("pig_name") String pig_name,
			@RequestParam("pig_age") int pig_age,
			@RequestParam("pig_image_path") MultipartFile file, Model model) { // @RequestParam 을 사용하는 방법도 있다.
		pigService.inputPig(pig_name, pig_age, file);
		log.info("업로드 확인");
		return "redirect:/"; // 업로드가 완료되면, 메인 페이지로 돌아가서 제대로 등록됐는지 확인하기
		// "redirect:/" 와 "index" 만 넣었을 때의 차이
		/*
		 * redirect:/ 는, 사용자가 새로운 URL 로 다시 요청하도록 지시하는 것이다.
		 * ▶ react 로 작성하고, 값을 전달할 때 주로 사용할 예정이다.
		 * index 는, html 파일 이름을 의미한다.
		 * */
	}
}
