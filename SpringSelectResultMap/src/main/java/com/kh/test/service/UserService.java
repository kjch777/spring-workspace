package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dao.UserDAO;
import com.kh.test.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	// @Autowired 는
	// public UserService(UserMapper userMapper) {
	// 		this.userMapper = userMapper;
	// }
	// 를 전부 써준 것과 같다.
	private UserMapper userMapper;
	
	public void insertUser(UserDAO user) {
		userMapper.insertUser(user);
	}
	
	// Mapper 에서, resultType="java.lang.Integer" 라고 작성해두었기 때문에,
	// 여기서도 int 를 쓰거나, Mapper 와 Service method 모두 타입을 바꿔주면 된다.
	public boolean existsByName(String itemName) {
		// Integer 를 boolean 으로 변경해서 전달하기
		// Integer count = userMapper.existsByName(itemName); ◀ resultMap 을 사용하지 않을 때
		UserDAO count = userMapper.existsByName(itemName); // resultMap 을 사용할 때
	 // Integer totalCount = 참인지 거짓인지 ? true 이고 null 이 아닐 때 : false 일 때 null == 0;
		Integer totalCount = count != null ? count.getItemCount() : 0;
		
		log.info("count: " + count);
		log.info("itemName: " + itemName);
		
		return totalCount != null && totalCount == 0; // true 로 전달하기
		// return userMapper.existsByName(itemName);
	}
}
