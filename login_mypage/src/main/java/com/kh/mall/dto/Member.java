package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString // 값이 제대로 넘어오지 않을 때, 이유가 무엇인지 확인하는 String
public class Member {
	private int member_id;
	private String member_name;
	private int member_age;
	private String member_phone;
}
