package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Snacks;
/*
 * Spring 에서 이 Mapper 인터페이스는,
 * SQL DB 에 작성한 코드를 가리키는 위치이다.
 * 라는 @Mapper 어노테이션을 작성해준다.
 * 이 Mapper 는 SQL 구문을 가리킨다는 의미가 있는 것이다.
 * */
@Mapper
public interface SnacksMapper {
	// DB 에서 모든 과자들을 가져올 수 있도록, 진열 목록을 작성해준다.
	List<Snacks> getAllSnacks();
}
