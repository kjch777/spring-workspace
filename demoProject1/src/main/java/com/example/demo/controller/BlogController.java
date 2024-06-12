package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BlogDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("blog")
@Slf4j
public class BlogController {
	
	@PostMapping("comment")
	public String blogComment(BlogDTO inputComment) {
		log.info("블로그 댓글 작성 공간");
		BlogDTO bl = new BlogDTO();
		
		bl.getCommentName();
		bl.getCommentOpinion();
		
		bl.setCommentName("신짱구");
		bl.setCommentOpinion("못말려");
		log.info("작성 댓글 정보 보기: " + bl.toString());
		return "redirect:/blog/blog-index";
	}
	
	
}
