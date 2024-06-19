package com.kh.mall.service;
/*
 * Controller 에서 가져오거나, DB 에서 가져온 값에 추가적인 기능을 작성해주는 서비스 공간이다.
 * @Service DB 에서 가져온 SQL 구문이나, html 에서 DB 에 넣어줄 값에 추가적인 서비스를 적용하겠다
 * 라는 표시이다.
 * */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Snacks;
import com.kh.mall.mapper.SnacksMapper;

@Service
public class SnacksService {
	// Mapper 에 작성한 목록을 모두 활용하겠다는
	// @Autowired 어노테이션 작성
	@Autowired // 객체 안에 한 줄씩 참조할 때 작성해준다.
	private SnacksMapper snacksMapper;
	
	// Snacks SQL 에서 가져온 과자들을, Controller 에 전달해주는 메서드(기능) 작성
	public List<Snacks> getAllSnacks(){
		// 과자 목록을 보여줄 때, 추가로 설정하고 싶은 기능을 추후 작성
		// 예를 들어, 과자 이미지가 존재하는지 확인하고, 이미지가 없다면 엑스박스로 표시하는 것과 같은
		// 여러가지 기능을 작성해준다.
		return snacksMapper.getAllSnacks();
	}
}
