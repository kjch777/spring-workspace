package com.example.demo.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// blog 관련 controller 작성
@Controller
@RequestMapping("blog")
public class BlogController {
	@GetMapping("index") // blog/index 와 같다.
	public String blogMainMethod() {
		return "blog/blog-index";
	}
	
	@GetMapping("board") // blog/board 와 같다.
	public String blogBoardMethod() {
		return "blog/blog-board";
	}
}
