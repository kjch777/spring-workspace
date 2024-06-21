package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.mall.dto.Clothes;
import com.kh.mall.service.ClothesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ClothesController {

	@Autowired
	private ClothesService clothesService;
	
	@GetMapping("/")
	public String getAllClothes(Model model) {
		List<Clothes> clothes = clothesService.getAllClothes();
		log.info("clothes: " + clothes);
		model.addAttribute("clothes", clothes);
		return "index";
	}
}
