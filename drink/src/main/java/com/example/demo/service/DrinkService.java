package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DrinkDTO;
import com.example.demo.mapper.DrinkMapper;

@Service // Service 어노테이션은 Service 클래스에 작성해준다.
public class DrinkService {
	
	@Autowired
	private DrinkMapper drinkMapper; // Mapper.java 파일을 가져온 것이다.

	public void insertDrink(DrinkDTO drinkDTO) {
		drinkMapper.insertDrink(drinkDTO);
	}

}
