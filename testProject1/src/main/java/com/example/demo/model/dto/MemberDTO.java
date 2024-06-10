package com.example.demo.model.dto;

import lombok.*;

/*
 앞으로는 Getter 와 Setter 는 Lombok 라이브러리를 활용하여 길게 작성하지 않는다.
 기본 생성자
 필수 생성자
 toString 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
	// 나중에 데이터 베이스와 연결 할 모델들 작성하기
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberAge;
	
// 메서드
	// Getter -> lombok @Getter 자동완성 사용하기
	// Setter -> lombok @Setter 자동완성 사용하기
	// 기본생성자 -> lombok @NoArgsConstructor 자동완성 사용하기
	// 필수생성자 -> lombok @AllArgsConstructor 자동완성 사용하기
	// toString -> lombok @ToString 자동완성 사용하기
}