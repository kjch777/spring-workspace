package com.kh.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Login;
import com.kh.mall.mapper.LoginMapper;

@Service
public class LoginService {

	@Autowired
	private LoginMapper loginMapper;
	
	public Login getLogin(String username, String password) {
		return loginMapper.getLogin(username, password);
	}
}
