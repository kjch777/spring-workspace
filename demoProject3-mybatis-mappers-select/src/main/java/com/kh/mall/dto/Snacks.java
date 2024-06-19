package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Snacks {
	private int snack_id;
	private String snack_name;
	private int snack_price;
	private String company_name;
	private String company_phone;
}
