package com.example.demo.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 이것과 기본 생성자 중에 하나만 작성해 주어야 한다. 2개가 다 있으면 안 된다.
@AllArgsConstructor // 이것과 필수 생성자 중에 하나만 작성해 주어야 한다. 2개가 다 있으면 안 된다.
@ToString
public class BlogDTO {
	
	private String commentName;
	private String commentOpinion;
	
}
