package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Pig;

@Mapper
public interface PigMapper {
	
	// 전체 목록 가져오기 ▶ List 이용
	List<Pig> getAllPigs();
	
	// 돼지 정보 하나씩만 가져오기
	Pig getPigById(int pig_id);
	
	// 돼지 정보 DB 에 insert 하기
	public void inputPig(Pig pig);
}
