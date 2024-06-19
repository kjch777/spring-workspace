package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Member;

@Mapper
public interface MemberMapper {
	// 인터페이스

	List<Member> getAllMember();
}
