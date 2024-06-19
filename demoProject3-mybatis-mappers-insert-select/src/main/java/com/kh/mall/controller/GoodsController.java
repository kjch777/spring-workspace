package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mall.dto.Goods;
import com.kh.mall.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // log 를 이용하여, DB 에서 전달해준 값이 제대로 출력되는지 확인하기
public class GoodsController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/productRegister")
	public String insertProduct(Goods goods, Model model) {
		productService.insertProduct(goods);
		model.addAttribute("msg", "상품이 성공적으로 등록되었습니다.");
		return "productList"; // 결과를 볼 수 있는 html 주소 작성
	}
	
	@GetMapping("/product-list")
	public String getAllProduct(Model model) {
		List<Goods> productList = productService.getAllProduct();
		log.info("상품 전체 목록: " + productList);
		model.addAttribute("productList", productList);
		return "productList";
	}
}
