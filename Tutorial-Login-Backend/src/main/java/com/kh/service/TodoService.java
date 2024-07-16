package com.kh.service;

import java.util.Map;

import com.kh.dto.TodoMember;

public interface TodoService {

	int idCheck(String id);
	int signUp(TodoMember member);
	
	// login 은 key, value 값을 이용하여 정보를 전송할 것
	Map<String, Object> login(TodoMember member);
}
