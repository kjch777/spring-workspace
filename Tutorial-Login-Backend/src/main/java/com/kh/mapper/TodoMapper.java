package com.kh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.dto.TodoMember;

@Mapper
public interface TodoMapper {
	int idCheck(String id);
	
	int signUp(TodoMember member);
	
	TodoMember login(TodoMember member); // id, pw 만 써도 되고, TodoMember 모두 써도 된다.
	// TodoMember login(String id, String pw); // id, pw 만 써도 되고, TodoMember 모두 써도 된다.
}
