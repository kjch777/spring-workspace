package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kh.mall.dto.Member;

@Mapper
/*
 @MapperScan: mapper 의 위치가 아예 찾아지지 않을 때, 
              main 메서드(@SpringBootApplication 어노테이션이 있는 곳) 에 
              mapper 주소를 작성해주는 어노테이션이다.
 
 사용법
 	@MapperScan("com.kh.mall.mapper.LoginMapper") ◀ mapper 하나 가져오기
 	@MapperScans("com.kh.mall.mapper.*") ◀ mapper 여러개 가져오기
 */ 
public interface LoginMapper {
	Member getLogin(@Param("member_name") String member_name,
			        @Param("member_phone") String member_phone);

	// insert 와 update, delete 는 void 이다.
	void updateMember(Member member);
	
	// select 에서 DB 기준으로 2개 이상의 행을 볼 때는 List 를 쓰고, 
	// 1개의 행을 볼 때는 List 를 쓰지 않아도 된다.
	
	void deleteMember(@Param("member_id") int member_id);
	
	List<Member> searchMembers(@Param("keyword") String keyword);
}


