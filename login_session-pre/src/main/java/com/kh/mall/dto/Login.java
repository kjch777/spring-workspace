package com.kh.mall.dto;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Login {

	private int member_id;
	private String username;
	private String password;
	private String email;
	private Date created_at;
}
