package com.kh.mall.dto;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	private int member_id;
	private String member_name;
	private String member_pw;
	private String member_email;
	
	private Date created_at;
	// DB Date 타입은 Java 에서도 Date 타입으로 불러온다.
}
