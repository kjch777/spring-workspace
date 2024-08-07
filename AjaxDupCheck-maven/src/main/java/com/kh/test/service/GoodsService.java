package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.Goods;
import com.kh.test.mapper.GoodsMapper;

@Service
public class GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public boolean existsByName(String itemName) {
		Goods goods = new Goods();
		goods.setItem_name(itemName);
		Integer count = goodsMapper.existsByName(goods);
		return count != null && count > 0;
	}
}
