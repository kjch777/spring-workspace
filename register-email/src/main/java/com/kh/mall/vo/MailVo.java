package com.kh.mall.vo;

import lombok.Data;

/*
 * 이메일 인증 번호를 임시 저장하는 공간
 * 임의의 유효한 시간까지 이메일을 보관하고,
 * 시간이 지나면 자동으로 데이터가 사라지는 공간이다.
 * */

@Data
public class MailVo {

	private String receiver;
	private String title;
	private String content;
}
