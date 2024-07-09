package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kh.test.dao.UserDAO;

// @MapperScan 은 여기서 사용하는 것이 아니라,
// @SpringBootApplication 이 있는 곳에서 
// @MapperScan(com.kh.test.mapper) 형식으로 사용한다.

@Mapper 
public interface UserMapper {

	public void insertUser(UserDAO user);
	
	// Integer existsByName(String itemName); ◀ resultMap 을 사용하지 않을 때
	UserDAO existsByName(@Param("itemName") String itemName); // resultMap 을 사용해서 count(*) 값을 넘길 때
}
