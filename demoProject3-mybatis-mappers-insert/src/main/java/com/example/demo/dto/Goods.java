package com.example.demo.dto;

import lombok.*;

/*lombok 을 사용하여 Getter Setter 기초생성자 필수생성자 toString 만들기*/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Goods {
	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsQuantity;
}
