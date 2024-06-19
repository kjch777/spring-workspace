package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Companies {

	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone; 
	// 맨 앞이 0 으로 시작하는 값을 int/number 를 사용하여 저장할 경우, 맨 앞에 있는 0 이 누락된다.
}
