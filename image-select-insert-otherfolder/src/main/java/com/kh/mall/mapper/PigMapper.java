package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Pig;

@Mapper
public interface PigMapper {
	// 1. DB 에 저장된 돼지 정보 행 여러개를 한꺼번에 가져오기 ▶ List(DTO Pig)
	List<Pig>getAllPigs();
	
	// 2. DB 에 저장된 돼지 정보 하나의 행만 가져오기 ▶ DTO Pig
	Pig getPigById(int pig_id);
	
	// 3. 돼지 정보 DB 에 업로드 하기 ▶ 업로드니까 void(Pig)
	public void upLoadPig(Pig pig);
}
