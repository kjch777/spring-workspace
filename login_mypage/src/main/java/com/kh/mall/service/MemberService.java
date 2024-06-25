package com.kh.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Member;
import com.kh.mall.mapper.LoginMapper;

@Service
public class MemberService {
	
	@Autowired
	private LoginMapper memberMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		
		// 추후 Service 클래스에 비밀번호를 암호화하여 DB 에 저장하고,
		// 암호화 되어있는 비밀번호를 가져와서 로그인 하는 코드를 추가로 작성할 것이다.
		return memberMapper.getLogin(member_name, member_phone);
	}
	
	// void 는 return 값이 없다.
	// void 는 통보의 개념이기 때문에, return 으로 전달할 값이 없다.
	public void updateMember(Member member) { 
		memberMapper.updateMember(member);
	}
	
	// delete == void == return 값이 없다.
	public void deleteMember(int member_id) {
		memberMapper.deleteMember(member_id);
	}
	
	public List<Member> searchMembers(String keyword){
		return memberMapper.searchMembers(keyword);
	}
}
