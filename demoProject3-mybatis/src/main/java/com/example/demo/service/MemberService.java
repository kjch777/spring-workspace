package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.mapper.MemberMapper;

/*
 상세한 기능을 작성하는 공간이다.
 정규식, 비밀번호 암호처리 등의 기능을, 상세하게 작성하는 공간이다. 
 */
@Service // 어떤 서비스를 제공할 것인지 작성하는 공간이다.
public class MemberService {
	@Autowired // 해당하는 값에 작성된 내용을 자동으로 전달하겠다는 표시이다.
	private MemberMapper memberMapper;
	
	// 메서드 이름은 mapper.xml 에서 작성한 id 이름과 동일하게 작성해주는 것이 좋다.
	public void insertMember(Member member) {
		// 추후 정규식, 비밀번호 설정, 비밀번호 일치여부와 같은 모든 기능을 작성하는 공간이다.
		memberMapper.insertMember(member);
	}
}
