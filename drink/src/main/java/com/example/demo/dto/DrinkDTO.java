package com.example.demo.dto;

import lombok.*;

// DTO 클래스에 lombok 을 사용하여 Getter 생성자 toString 등 만들어주기
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DrinkDTO {
	private int drinkId;
	private String drinkName;
	private int drinkPrice;
	private int drinkQuantity;
	// 여기서 필드 변수명은 SQL 칼럼명과 달라도 된다.
}
