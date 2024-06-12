package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.MemberDTO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

// Bean: 스프링이 알아서 만들고 관리한다는 것

@Controller // 응답이나 요청에 대한 제어 역할을 명시해준 것 + Bean 등록
@RequestMapping("param") // 여기부터 아래에 작성하는 모든 주소 앞에 param 이 기본으로 붙는다.

@Slf4j // Simple logging facade 4(for) java 의 약자이다. ▶ System.out.println 과 비슷한 종류이다.
// logging 을 사용하는 것이 System 출력에 비해 메모리 부담이 적다. ◀ log 를 이용한 메시지 출력 시에 자주 사용한다.

public class ParameterController {

	// GetMapping main
	@GetMapping("main") // param/main 주소로 GET 방식 요청을 만든 것
	public String paramMain() {
		return "param/param-main";
		// return 할 때, 폴더명/파일명을 작성해준 것이다.
		// param-main.html 파일은, 템플릿 폴더 내부에 있는 파람 폴더 안에 존재한다.
		// html 파일을 가리킬 때, 기본으로 templates 이라는 폴더를 가리키고
		// templates/param/param-main.html 파일을 바라본다는 표시를 작성해준 것이다.
	}
	
	@PostMapping("test1") // param/test1 POST 방식 요청
	public String paramTest1(HttpServletRequest req) {
		String inputName = req.getParameter("inputName"); 
		// form 내부 input 에서, name="inputName" 으로 존재하는 값 가져오기
		// <input type="text" name="inputName">
		
		String inputAddress = req.getParameter("inputAddress");
		// form 내부 input 에서, name="inputAddress" 로 존재하는 값 가져오기
		// <input type="text" name="inputAddress">
		
		// 가져오는 기본 값이 String 이기 때문에, 숫자 값인 int 로 변환해 주어야 한다.
		int inputAge = Integer.parseInt(req.getParameter("inputAge"));
		// form 내부 input 에서, name="inputAge" 로 존재하는 값 가져오기
		// <input type="number" name="inputAge">
		
		// inputName, inputAddress, inputAge 가 제대로 작성됐는지 확인해보기
		System.out.println("이름 확인: " + inputName);
		System.out.println("나이 확인: " + inputAge);
		System.out.println("주소 확인: " + inputAddress);
		
		// System 대신 log.debug 를 활용하여 출력하는 것이 메모리 부담이 적다.
		// ▲ 코드 오류를 해결하기 위한 것이다.
		// 코드 오류는 없는데 정상적으로 수행되지 않거나, 값이 잘못된 경우 ▶ 값 추적을 진행한다.
		log.info("정보 확인하기");
		log.debug("로그로 이름 확인: " + inputName);
		log.debug("로그로 나이 확인: " + inputAge);
		log.debug("로그로 주소 확인: " + inputAddress);
		
		/*
		 spring 에서 redirect(재요청) 하는 방법
		 Controller 메서드 반환 값에
		 redirect: 요청 주소 작성 형식으로 표기해주면
		 되돌아가진다. 
		 */
		
		return "redirect:/param/main";
	}
	/*
	 2. @RequestParam - 낱개(한개, 단수개) 파라미터 얻어오기
	 
	 	- request 객체를 이용한 파라미터 전달 어노테이션이다.
	 	- 매개 변수 앞에 해당 어노테이션을 작성하면 매개변수에 값이 작성된다.
	 	- 작성되는 데이터는 매개변수(Parameter) 타입에 맞게 형변환(Parse) 이 자동으로 수행된다.
	 	
	 [속성 추가 작성법]
	 	@RequestParam(value="name", required="false", defaultValue="1")
	 	
	 	value = 전달받은 input 태그의 name 속성값
	 	
	 	required = 입력된 name 속성값 매개변수(Parameter) 필수 여부 지정(기본값은 true 이다.)
	 		▶ required = true 인 매개변수가 존재하지 않는다면, 400 Bad Request 오류가 발생한다.
	 		▶ required = true 인 매개변수가 null 인 경우에도, 400 Bad Request 오류가 발생한다.
	 	
	 	defaultValue = 매개변수 중 일치하는 name 속성값이 없을 경우에 대입할 값을 지정한다.
	 		▶ required 가 false 일 때만 사용할 수 있다.
	 	
	 	400 Bad Request(잘못된 요청)
	 		- 매개변수 불충분
	 */
	
	/*
	 책 제 목: <input type="text" name="title"><br>
	 작 성 자: <input type="text" name="writer"><br>
	 책 가 격: <input type="number" name="price"><br>
	 출 판 사: <input type="text" name="publisher"><br> 
	 */
	@PostMapping("test2") // ▶ /param/test2
	public String paramTest2(@RequestParam(/*value=*/ "title" /*, required=true*/) String title,
			                 @RequestParam("writer") String writer,
			                 @RequestParam("price") int price,
			                 @RequestParam(value="publisher", defaultValue="교보문고", required=false) String publisher) {
		log.info("문제없이 insert 가능한지 확인하기");
		log.debug("title: " + title);
		log.debug("writer: " + writer);
		log.debug("price: " + price);
		log.debug("publisher: " + publisher);
		return "redirect:/param/main";
	}
	
	/*
	 3. @RequestParam 여러개(복수, 다수) 파라미터 가져오기
	  		String[]
	  		List<자료형>
	  		Map<String, Object>
	  
	  	defaultValue 속성은 사용할 수 없다.
	 */
	@PostMapping("test3")
	public String paramTest3(@RequestParam(value="color", required=false) String[] colorArr,
			                 @RequestParam(value="fruit", required=false) List<String> fruitList,
			                 @RequestParam Map<String, Object> productMap) {
		
		log.info("colorArr: " + Arrays.toString(colorArr));
		log.info("fruitList: " + fruitList);
		log.info("productMap: " + productMap);
		// key(name 속성값) 가 중복되면, 덮어쓰기가 된다.
		// 같은 name 속성 parameter 가 String[] 또는 List 로 저장이 되는 것은 힘들다.
		
		return "redirect:/param/main";
		
	}
	
	
	/*
	 DTO 와 VO
	 	DTO: Data Transfer Object 의 약자로, 데이터 캡슐화를 통해 데이터를 전달하고 관리한다.
	 	     어떠한 계층에서 다른 계층으로 데이터 전송을 하기 위해 사용한다.
	 	     
	 	     계층 간의 전송이란 예를 들어, html ▶ db 같은 것이다.
	 	     
	 	     
	 	VO: Value Object 의 약자로, 값 자체를 표현하는 객체이다.
	 	    한 번 값이 생성되면, 그 값을 변경할 수 없다.
	 	    
	 	    생성자를 통해 값을 설정하고, Setter 메서드를 제공하지는 않는다.
	 
	 
	 @ModelAttribute
	  - DTO(또는 VO) 와 같이 사용하는 어노테이션이다.
	  - 전달받은 매개변수(Parameter) 의 name 속성 값이
	    같이 사용되는 DTO 의 필드 이름과 같다면,
	    자동으로 Setter 를 호출하여 필드에 값을 저장한다.
	    
	 [주의 사항]
	 	- DTO 에 기본 생성자가 반드시 존재해야 한다.
	 	- DTO 에 Setter 가 반드시 존재해야 한다.
	 	
	   @ModelAttribute 는 기본값이기 때문에, 생략 가능하다.
	   @ModelAttribute 를 이용하여 값이 필드에 저장된 객체를 커맨드 객체라고 한다.
	 */
	
	@PostMapping("test4")
	public String paramTest4(/*@ModelAttribute*/MemberDTO inputMember) {
	
		// lombok 으로 만든 Getter Setter 로 값을 가져오거나 설정하기
		MemberDTO mb = new MemberDTO();
		
		mb.getMemberID();
		mb.getMemberPW();
		mb.getMemberName();		
		mb.getMemberAge(); // Getter 를 통해 나이 가져오기
		log.info("inputMember 에 대한 get 정보 가져오기: " + inputMember.toString());
		
		mb.setMemberID("id01");
		mb.setMemberPW("pw01");
		mb.setMemberName("가나다");
		mb.setMemberAge(0); // Setter 를 통해 나이 가져오기
		// 굳이 따로 만들어 놓지 않아도 lombok @Getter @Setter 를 만들어 가져오기 때문에 사용 가능한 것이다.
		
		log.info("inputMember 에 대한 set 정보 가져오기: " + inputMember.toString());
		
		/*
		 org.thymeleaf.exceptions.TemplateInputException: Error resolving template [], template might not exist or might not be accessible by any of the configured Template Resolvers
		 
		 ▲ return 에서 이동할 주소를 설정하지 않았을 때 발생하는 오류이다. 
		 */
		return "redirect:/param/main";
		
	}
	
}
