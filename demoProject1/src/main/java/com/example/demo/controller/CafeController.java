package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {

	@PostMapping("cafe_index")
	public String cafeMainComment(@RequestParam("cafeCommentName") String cafeCommentName,
			                      @RequestParam("cafeCommentOpinion") String cafeCommentOpinion) {
		
		log.info("접속 확인");
		log.debug("cafeCommentName: " + cafeCommentName);
		log.debug("cafeCommentOpinion: " + cafeCommentOpinion);
		log.info("댓글 작성 완료 확인");
		
		return "redirect:/cafe/cafe_index";
		
	}
	
}
