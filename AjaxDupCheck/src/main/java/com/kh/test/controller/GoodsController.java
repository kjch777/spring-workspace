package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsService;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@ResponseBody // JSON type 으로 값을 가져오겠다.
	@GetMapping("/itemCheck")
	public Map<String, Object> getGoods(@RequestParam("controllerItemName") String controllerItemName) {
		Map<String, Object> res = new HashMap();
		boolean isCheck = goodsService.getGoods(controllerItemName);
		res.put("isCheck", isCheck);
		return res;
	}
}
