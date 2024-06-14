package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // spring
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.MemberDTO;
import com.example.demo.dto.StudentDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller // 요청 또는 응답 제어 역할을 명시한 것/Bean: Spring 에서 어떤 기능을 할지 설정해놓은 값
@RequestMapping("example") // /example 로 시작하는 주소를 해당 컨트롤러에 넣어준다.
@Slf4j // lombok 라이브러리가 제공하는 로그 객체 자동 생성 어노테이션
public class ExampleController {
	/*
	 * Model - Spring 에서, 데이터 전달 역할을 하는 객체이다. - org.springframework.ui 패키지이다.
	 * - @SessionAttributes 와 함께 사용할 경우, session scope 를 반환한다.
	 * 
	 * [기본 사용법] Model.addAttribute("key", value);
	 * Model.addAttribute("html 에 전달 가능한 이름", 전달 할 값);
	 */

	@GetMapping("ex1") // /example/ex1 주소로 보여지는 값
	public String ex1(HttpServletRequest req, Model model) {
		// 나중에 데이터 베이스에서 가져온 값을 보여줄 때 사용하는 메서드이다.
		req.setAttribute("test1", "HttpServletRequest 로 전달한 값");
		model.addAttribute("test2", "Model 로 전달한 값");

		// 단일 값(숫자, 문자열) Model 을 이용하여 html 전달
		model.addAttribute("productName", "종이컵");

		model.addAttribute("price", 2000);

		model.addAttribute("productCompany", "KhCompany");

		// 복수 값(List, 배열) Model 을 이용하여 html 로 전달하기
		List<String> fruitList = new ArrayList();

		fruitList.add("사과");
		fruitList.add("오렌지");
		fruitList.add("바나나");

		model.addAttribute("fruitList", fruitList);

		List<String> animalList = new ArrayList();
		animalList.add("호랑이");
		animalList.add("독수리");
		animalList.add("상어");
		model.addAttribute("animal", animalList);
		// ("html 파일에서 작성한 명칭", java 파일에서 작성한 명칭)

		// DTO 객체를 Model 을 이용하여, html 파일로 전달하기
		StudentDTO std = new StudentDTO();
		std.setStudentNo("A01");
		std.setStudentName("김철수");
		std.setStudentAge(10);
		model.addAttribute("std", std);

		// DTO 객체를 Model 을 이용하여, html 파일로 전달하기
		MemberDTO mem = new MemberDTO();
		mem.setMemberNo("01");
		mem.setMemberName("신짱구");
		mem.setMemberAge(5);
		model.addAttribute("mem", mem);
		// (괄호 안에 있는 별칭 2개는 서로 달라도 되지만,
		// 가능한 동일하게 사용하여 혼동을 방지하는 것이 좋다.)

		// List<StudentDTO> 객체에, Model 을 이용하여 html 전달하기
		List<StudentDTO> stdList = new ArrayList();
		stdList.add(new StudentDTO("A1", "신짱구", 10));
		stdList.add(new StudentDTO("A2", "김철수", 10));
		stdList.add(new StudentDTO("A3", "이유리", 10));
		model.addAttribute("stdList", stdList);

		List<MemberDTO> memList = new ArrayList();
		memList.add(new MemberDTO("01", "홍길동", 25));
		memList.add(new MemberDTO("02", "임꺽정", 40));
		memList.add(new MemberDTO("03", "강감찬", 33));
		model.addAttribute("memList", memList);

		return "example/ex1"; // templates/example/ex1.html 파일을 가리키는 것이다.
	}

	/*
	 * @PathVariable - 주소 중 일부분을 변수 값처럼 사용하는 것이다. - 해당 어노테이션으로 얻어온 값은 request scope
	 * 에 세팅된다.
	 */
	@GetMapping("/ex2/{number}")
	public String pathVariableTest(@PathVariable("number") int number
	// 주소 중 {number} 부분의 값을 가져와 매개변수에 저장
	// requestScope 세팅
	) {

		return "example/testResult";

	}

	@PostMapping("ex2")
	public String ex2(Model model) {
		model.addAttribute("str", "<h1> 테스트 중 &times; </h1>");
		return "example/ex2";
	}
	
	@GetMapping("ex3")
	public String ex3(Model model) {
		model.addAttribute("boardNo", 10);
		model.addAttribute("key", "제목");
		model.addAttribute("query", "검색어");
		return "example/ex3";
	}
	
	@GetMapping("ex4")
	public String ex4(Model model) {
		// 아직 std 로 전달해준 값이 없는 상태이기 때문에, th:unless 안에 작성해준 std 없음이 뜨는 것이 정상이다.
		// ▼ 하단 코드 2줄을 작성해주면 된다.
		StudentDTO std = new StudentDTO("1234", "신짱구", 10);
		model.addAttribute("std", std);
		
		MemberDTO mem = new MemberDTO("7890", "홍길동", 15);
		model.addAttribute("mem", mem);
		
		model.addAttribute("testIf", "Hello, World");
		
		model.addAttribute("num", 100);
		
		model.addAttribute("alp"); // ◀ 이렇게 비워놓게 되면, html 파일에서 th:case="*" 에 설정해 놓은 값이 화면에 출력되게 된다.
		// 또한, 입력 값으로 대/소문자도 구분한다.
		
		return "example/ex4";
	}
	
	@GetMapping("ex5")
	public String ex5(Model model) {
		model.addAttribute("message", "타임리프 + 자바스크립트 사용 예제");
		model.addAttribute("num1");
		
		// 아직 std 로 어떤 값을 저장하고, 전달해준 값이 없는 상태이다. 따라서 ▼
		StudentDTO std = new StudentDTO();
		MemberDTO mem = new MemberDTO(); // 이 상태로만 끝내면 0 이 출력된다. 따라서 ▼
		
		std.setStudentNo("A01");
		std.setStudentName("신짱구");
		
		mem.setMemberNo("B20");
		mem.setMemberName("홍길동");
		mem.setMemberAge(15);
		
		model.addAttribute("std", std);
		model.addAttribute("mem", mem);
		
		return "example/ex5";
	}

}
