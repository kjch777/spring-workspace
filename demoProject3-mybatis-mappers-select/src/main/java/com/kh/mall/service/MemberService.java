package com.kh.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Member;
import com.kh.mall.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	// Mapper.java 파일 불러오기
	
	public List<Member> getAllMember(){
		
		return memberMapper.getAllMember();
	}
}
