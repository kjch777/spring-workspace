package com.kh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dto.TodoMember;
import com.kh.mapper.TodoMapper;

/*
 * Service: 코드를 작성할 때, 이러한 서비스를 사용하겠다는 계약 또는 정의이다.
 *          어떤 메서드(기능) 들이 있어야 하는지, 또한 각 메서드(기능) 가 어떤 역할을 하는지 정의하는 것이다.
 * 
 * ServiceImpl: 인터페이스로 작성한 Service 의 실제 기능을 작성한다.
 *              비슷한 기능을 각 서비스에 맞춰 사용하겠다는 것이다.
 * 
 * 예를 들어, createUser ◀ user 를 만들 것
 * user 를 만들 때, 관리자 - 사용자를 나눠서 만들 것
 * */
@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	private TodoMapper mapper;
	
	// 인터페이스에 기능 명시만 되어있고,
	// 여기서 명시된 기능을 완성한다는 @Override(재사용) 표시
	// 개발자 간의 약속(생략 가능하지만, 작성해주는 것이 좋다.)
	@Override
	public int idCheck(String id) {
		return mapper.idCheck(id);
	}
	
	@Override
	public int signUp(TodoMember member) {
		return mapper.signUp(member);
	}
	
	@Override
	public Map<String, Object> login(TodoMember member) {
		TodoMember loginMember = mapper.login(member);
		Map<String, Object> map = new HashMap();
		map.put("loginMember", loginMember);
		return map;
	}
}
