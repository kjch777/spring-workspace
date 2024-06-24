package com.kh.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Member;
import com.kh.mall.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		return memberMapper.getLogin(member_name, member_phone);
	}
}
