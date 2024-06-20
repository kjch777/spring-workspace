package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SAC {

	private int snack_id;
	private String snack_name; 
	private int snack_price;
	
	// mapper 폴더 안에 있는 xml 파일에 작성한 join 문에서
	// Snacks 테이블에 있는 comapny_id 와, Company 테이블에 있는 company_id 가
	// 서로 의미하는 바와 값이 일치할 경우, Company 테이블에 있는
	// company_name 과 company_phone 을 가져오겠다고 미리 작성해두었기 때문에
	// 가능한 작성법이다.
	private String company_name;
	private String company_phone;
	private String company_address;
}
