package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
	
	private int member_id;
	private String member_name;
	private int member_age;
	private String member_phone;
}
