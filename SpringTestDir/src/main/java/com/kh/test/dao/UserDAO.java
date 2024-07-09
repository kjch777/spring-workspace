package com.kh.test.dao;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDAO {

	private int usId;
	private String usEmail;
	
	private int itemId;
	private String itemName;
	private String itemDesc;
	
	// count(*) 결과를 받아서 저장할 변수명 추가하기
	private int itemCount; // count(*)
}
