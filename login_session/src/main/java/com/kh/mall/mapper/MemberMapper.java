package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.mall.dto.Member;

@Mapper
public interface MemberMapper {

	/*
	 * Member getLogin(@Param("member_name") String member_name, 
			           @Param("member_phone") String member_phone);
	   @Param 어노테이션은, 앞에서 매개변수인 parameter 를 이용하여, 
	                    일치하는 값을 가져오겠다 라고
	                    한번 더 확실하게 작성해주는 것이다.
	 * */
	Member getLogin(@Param("member_name") String member_name, 
			        @Param("member_phone") String member_phone);
}
