package com.kh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.dto.TodoMember;
import com.kh.service.TodoService;

import lombok.extern.slf4j.Slf4j;

//SpringBoot 어플리케이션(폴더) 안에서 html 코드를 작성해주는 것이 아니라,
// React 나 외부로 url 주소를 공유할 때 사용한다.
@RestController 
@Slf4j
public class TodoController {

	@Autowired
	private TodoService service;
	
	/**
	 * ID 중복 검사
	 * @param(파라미터 == 매개변수 == 중간에 개입하여 값을 변하게 하는 수)
	 * @param 으로 id 값을 가져와, id 중복 검사 결과를 보여줄 것이다.
	 * @return id 중복 검사 후, 결과를 되돌려 주는 것
	 * @return 중복: 1 // 사용 가능: 0
	 * **/
	@GetMapping("idCheck")
	public int idCheck(@RequestParam("id") String id) {
		return service.idCheck(id);
	}
	
	/**
	 * 회원가입
	 * @param member 회원가입 시, 입력한 정보를 모두 가져오기
	 * @return 회원가입을 성공하면: 1 // 실패하면: 0
	 * 
	 * @Request: DB 에 특정 값이 있는지 또는 값을 넣겠다 또는 값을 수정하겠다 는 요청이다.
	 * @RequestParam: 특정 값만 선택하여 요청하거나 또는 특정 값을 변환해서 요청하는 것이다.
	 * @RequestBody: 프론트에서 입력하고 Body 로 전달하는 모든 값을 넣어주겠다는 의미이다.
	 *               우리가 사용하는 React 를 기준으로,
	 *               body: JSON.stringify(inputValues)
	 *               inputValues 에 입력된 DB 로 넣어주겠다는 모든 값을 DB 에 넣겠다는 선언이다.
	 *               
	 * @Response: DB 에서 백으로 전달받은 값을 프론트로 전달할 때 사용한다.
	 * @ResponseParam: 특정 값만 프론트에 전달할 때 사용한다.
	 * @ResponseBody: html 에서 body 로 보여줄 모든 값을 전달할 때 사용한다.
	 * **/
	@PostMapping(value="/signup")
	public int signUp(@RequestBody TodoMember member) {
		return service.signUp(member);
	}
	
	/**
	 * login
	 * @param member
	 * @return 성공: 회원정보와 /todoList 를 볼 수 있는 정보 제공, 실패: null
	 * **/
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody TodoMember member) {
		return service.login(member);
	}
}
