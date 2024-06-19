package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.DrinkDTO;

@Mapper // Mapper 어노테이션은 Mapper 인터페이스에 작성한다.
public interface DrinkMapper {

	void insertDrink(DrinkDTO drinkDTO);

}
