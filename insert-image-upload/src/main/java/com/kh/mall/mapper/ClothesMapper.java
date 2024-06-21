package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Clothes;

@Mapper // @Mapper 는
public interface ClothesMapper { // interface

	List<Clothes> getAllClothes();
	
	Clothes getClothesById(int clothesId);
	
	public void uploadClothes(Clothes clothes);
}
