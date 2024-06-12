package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("param2")
@Slf4j
public class ParamTwoController {

	@PostMapping("test2")
	public String paramTwoTest(@RequestParam("snackName") String name,
			                   @RequestParam("snackCompany") String company,
			                   @RequestParam("snackPrice") int price,
			                   @RequestParam(value="snackLike", defaultValue="snackLike", required=false) String like) {
		
		log.info("확인");
		
		log.debug("snackName: " + name);
		log.debug("snackCompany: " + company);
		log.debug("snackPrice: " + price);
		log.debug("snackLike: " + like);
		
		return "redirect:/param/main";
	}
	
	@PostMapping("test3")
	public String paramLikeSnackCompany(@RequestParam(value="likeSnack", required=false) String[] snackArr,
			                            @RequestParam(value="likeCompany", required=false) List<String> companyList) {
		
		log.info("좋아하는 과자들: " + Arrays.toString(snackArr));
		log.info("선호하는 회사들: " + companyList);
		
		return "redirect:/param/main";
	}
}
