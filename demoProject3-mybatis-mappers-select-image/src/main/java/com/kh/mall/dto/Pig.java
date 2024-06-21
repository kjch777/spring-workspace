package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pig {
	
	private int pig_id; // number int
	private String pig_name; // varchar2 String
	private int pig_age; // number int
	private String pig_image_path; // varchar2 String
}
