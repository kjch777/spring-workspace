package com.kh.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.mall.dto.Member;
import com.kh.mall.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
// @RestController ◀ 추후, 리액트에서 사용할 예정 
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("m", new Member());
		return "login";
	}
	
	@PostMapping("/login")
	public String getLogin(Model model,
			               @RequestParam("member_name") String Member_name,
			               @RequestParam("member_phone") String Member_phone,
			               HttpSession session) {
		
		Member member = memberService.getLogin(Member_name, Member_phone);
		
		// 만약, 사용자의 입력 값과 DB 에 저장된 정보가 일치한다면, null 이 아님
		if(member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		} else { // 하지만, 일치하지 않는다면, null 임
			model.addAttribute("e", "일치하는 회원 정보가 없습니다.");
			model.addAttribute("m", new Member());
			return "login";
		}
		
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session /* SessionStatus status ◀ 지정한 시간이 경과하면, 자동으로 로그아웃되게 설정할 때 사용한다.*/) {
		session.invalidate(); // 로그인 풀리게 만들기
		return "redirect:/";
	}
	
	@GetMapping("/myPage")
	public String showMyPage(HttpSession session, Model model) {
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
		
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		
		// 만약, 모델에 정보가 담겨있다면, 보여줄 멤버 객체
		model.addAttribute("member", member);
		return "myPage";
	}
	
	/***** 마이페이지 불러오고 수정하는 @GetMapping @PostMapping *****/
	
	@GetMapping("/modifyProfile")
	public String modifyMypage(HttpSession session, Model model) {
		
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession");
				
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
				
		// 만약, 모델에 정보가 담겨있다면, 보여줄 멤버 객체
		model.addAttribute("member", member);
		return "modifyProfile";
	}
	/*
	 * Member member: 사용자(클라이언트) 가 기존에 이미 DB 에 저장해두었던 값이 들어있는 공간
	 * 
	 * Member updateMember: 사용자(클라이언트) 가 새로 작성하여, DB 에 덮어쓸 내용이 임시저장되어 있는 공간
	 * 
	 * Member member = (Member) session.getAttribute("loginSession"); // DB 에 이미 저장되어 있던 정보 가져오기
	 *       └ session 에서 loginSession 이라는 변수명에 저장된 로그인 정보 가져오기
	 *         그 다음, member 정보로 기존에 DB 에 이미 저장되어 있던 값을 불러오기
	 * 
	 * 덮어쓰기를 위한 코드 ▼
	 * updateMember.setMember_id(member.getMember_id()); // member.getMember_id(): input 에 사용자가 작성한 값 전부 가져오기
	 *            └ DB 에 저장되어 있던 값 중, id 는 개발자가 사용자에게 부여한 순서 값(회원가입한 순번) 이다.
	 *              따라서, 사용자가 가입한 순서는 변경할 수 없기 때문에(사용자에 의해 변경될 수 없기 때문에),
	 *              사용자가 id 값을 기준으로 새로 input 에 작성한 값을 가져와서 임시저장하는 것이다.
	 *              
	 *               member.getMember_id(): 기존에 이미 DB 에 저장되어 있던 정보
	 *               
	 *               setMember_id: 새로 DB 에 저장(덮어쓰기) 정보
	 *               id(회원가입 한 순서) 는 똑같지만, 이외의 내용은 수정하고 저장(덮어쓰기) 할 수 있다.
		
	   memberService.updateMember(updateMember); // DB 에 이미 저장되어 있던 정보를 input 에 사용자가 작성한 값으로 덮어쓰기
	                └ 덮어쓰기 한 내용을 실제로 DB 에 저장하기 위한 코드
	   
	   session.setAttribute("loginSession", updateMember);
	          └ 새로 DB 에 저장된 내용(덮어쓰기 된 내용) 을 loginSession 이라는 변수명에 다시 저장하기
	 * */
	@PostMapping("/modifyProfile") // form action 에 작성한 주소값 넣기
	public String updateMember(HttpSession session, Member updateMember) { // Member updateMember: 새로 저장할 내용을 담을 공간 이름
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession"); // DB 에 이미 저장되어 있던 정보 가져오기
						
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
						
		updateMember.setMember_id(member.getMember_id()); // member.getMember_id(): input 에 사용자가 작성한 값 전부 가져오기
		
		memberService.updateMember(updateMember); // DB 에 이미 저장되어 있던 정보를 input 에 사용자가 작성한 값으로 덮어쓰기
		
		session.setAttribute("loginSession", updateMember);
		
		return "redirect:/myPage";
	}
	
	@GetMapping("/deleteMember")
	public String deleteMember(HttpSession session) {
		
		// 현재 로그인 상태인 세션의 정보를 가져와, 멤버 정보를 조회하는 코드
		Member member = (Member) session.getAttribute("loginSession"); 
								
		// 만약, 로그인 되어있지 않은 상태에서 접속하려 한다면, 바로 홈페이지로 돌려보내기
		if(member == null) {
			return "redirect:/login";
		}
		memberService.deleteMember(member.getMember_id()); // session 에 저장된 멤버 아이디를 가져오겠다.
		
		session.invalidate(); // 삭제 후, 로그인 자체를 없던 일로 처리
		return "redirect:/";
	}
	
	// 검색하는 화면 볼 수 있도록 @GetMapping
	@GetMapping("/search")
	public String showSearchForm(Model model) {
		return "search";
	}
	
	/*
	 * @RequestParam("keyword")
	 * <input type="text" name="keyword" placeholder="이름 또는 전화번호를 입력하세요." required>
	 * 
	 * @RequestParam("input 등의 tag 에 작성해둔 name 또는 th:field 로 작성된 변수명") String keyword ◀ String keyword 는 String k 등으로 바꿔도 상관없다.
	 * 																				                                  └ 사용자가 작성한 keyword 에 대한 값이 k 라는 공간에 담기는 것이다.
	 * 
	 * input 에서 name = "keyword" 이기 때문에, @RequestParam("keyword") 로 작성한 것이다.
	 * input 에서 name, th:field 로 작성된 변수명과, @RequestParam("이 공간 안에 작성할 변수명은") 반드시 서로 일치해야 한다.
	 * 
	 * String keyword 는 input 에서 가리키는 keyword 라는 값을 가져와서, java 에서 가져온 값을 담을 공간이다.
	 * */
	
	// 검색 결과 볼 수 있도록 @PostMapping
	@PostMapping("/search")
	public String searchMembers(Model model, @RequestParam("keyword") String keyword) {
		List<Member> member = memberService.searchMembers(keyword);
		
		model.addAttribute("result", member); 
		// 검색결과가 담겨있는 member 값을 result 라는 이름의 공간으로 옮겨담아, 
		// html 파일에 있는 th 태그 result 로 전달하는 것이다.
		
		return "search";
	}
}