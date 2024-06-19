package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Goods;
import com.example.demo.mappers.GoodsMappers;

@Service
public class GoodsService {
	
	@Autowired // 이걸 사용하지 않으면, Context xml 파일로 Mappers 위치와 Service 위치를 설정하는 xml 파일을 하나하나 만들어주어야 한다.
	private GoodsMappers goodsMappers;
	
	public void insertGoods(Goods goods) {
		goodsMappers.insertGoods(goods);
	}
	/*
	 * 만약, @Autowired 를 사용하지 않는다면,
	 * goodsMappers(GoodsMappers goodsMappers) {
	 * 	this.goodsMappers = goodsMappers;
	 * }
	 * 를 일일히 작성해주어야 한다.
	 * */
}
