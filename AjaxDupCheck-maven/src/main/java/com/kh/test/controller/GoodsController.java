package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsService;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/check")
	public Map<String, Object> existsByName(@RequestParam String itemName) {
		boolean isCheck = goodsService.existsByName(itemName);
		Map<String, Object> res = new HashMap<>();
		res.put("isCheck", isCheck);
		return res;
	}
}
