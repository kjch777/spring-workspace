package com.kh.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Goods;
import com.kh.mall.mapper.ProductMapper;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	public void insertProduct(Goods goods) {
		productMapper.insertProduct(goods);
	}
	
	// DB 에서 가져온 상품 전체 목록을 Controller 에 전달해주기
	public List<Goods> getAllProduct(){
		return productMapper.getAllProduct();
	}
}
