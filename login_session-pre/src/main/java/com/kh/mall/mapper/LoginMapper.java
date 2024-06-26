package com.kh.mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.mall.dto.Login;

@Mapper
public interface LoginMapper {
	
	Login getLogin(@Param("username") String username,
			       @Param("password") String password);
}
