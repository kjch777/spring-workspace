package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Goods;

@Mapper
public interface ProductMapper {
	void insertProduct(Goods goods);
	
	// 상품을 전부 가져올 때는 List 또는 Array 배열을 사용한다.
	// 주로 사용되는 것은 List 이다.
	List<Goods> getAllProduct();
}
