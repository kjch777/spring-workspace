package com.kh.service;

import com.kh.dto.TodoMember;

public interface TodoService {

	int idCheck(String id);
	int signUp(TodoMember member);
}
