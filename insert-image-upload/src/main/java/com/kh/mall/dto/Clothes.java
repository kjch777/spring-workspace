package com.kh.mall.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clothes {

	private int clothesId;
	private String clothesName;
	private int clothesPrice;
	private String clothesCategory;
	private String clothesImagePath;
}
