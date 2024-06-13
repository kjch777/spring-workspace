package com.example.demo.dto;

import lombok.*;
/*
 Spring 의 경우, Getter 가 필수로 존재해야 한다.
 	▶ ${StudentDTO.getName()} == ${StudentDTO.name}
 		- Getter 대신 필드명을 호출하는 형식을 작성한 것이다.
 		- Getter 를 자동으로 호출한다고 여겨지기 때문이다.
 * */
@Getter
@Setter
@ToString           // toString() 메서드가 오버라이딩 되어 추가
@NoArgsConstructor  // 매개 변수가 없는 기본 생성자 추가
@AllArgsConstructor // 필드에 있는 모든 매개 변수가 들어있는 필수 생성자 추가
public class StudentDTO {

// 필드
	private String studentNo;
	private String studentName;
	private int studentAge;
	
}
