package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 Java 객체: new 연산자에 의해 Heap 영역에 Class 에서 작성된 내용대로 생성된 것
 
 instance: 개발자가 만들고 관리하는 객체
 
 bean: Spring Container(또는 Spring) 가 만들고 관리하는 객체
 */

@Controller // 요청이나 응답을 제어 할 컨트롤러 역할을 명시해준 것이다.
// bean 으로 등록된다. (= 객체로 생성하여 스프링이 관리해 준다.)
public class IndexController {
	
	// 기존 Servlet: Class 단위로 하나의 요청만 가능하다.
	// Spring: Method 단위로 요청 처리가 가능하다.
		
	// @RequestMapping("요청 주소")
	// 요청 주소를 처리 할 메서드를 매핑하는 어노테이션이다.
		
	// 1) 메서드에 작성:
	// - 요청 주소와 메서드를 매핑한다.
	// - GET / POST 가리지 않고 매핑(속성을 통해 지정 가능하다.)
		
	// 2) 클래스에 작성:
	// - 공통적으로 사용되는 주소는 한 번에 매핑한다.
	// ex) 네이버/쇼핑, 네이버/블로그, 네이버/카페 등
		
	// @RequestMapping("네이버")
	// public class 클래스명 {
		
			// @RequestMapping("블로그")
			// public String 메서드명( ) { } // 네이버/블로그 매핑
		
			// @RequestMapping("카페")
			// public String 메서드명( ) { } // 네이버/카페 매핑
		
	    // }
		
		@RequestMapping("test") // test 요청시 처리할 메서드 매핑
		public String testMethod() {
			System.out.println("test 페이지로 제대로 연결됐는지 확인용 출력 메서드");
			
			/*
			 @RequestMapping 을 사용하면, return 할 때 기본 경로로 html 파일을 가리키겠다. 라는 설정이 들어있다.
			 
			 classpath: src/main/resources
			 기본 경로에, 맨 앞에 붙여진 /templates/ 폴더가 html 파일을 담는 공간이다.
			 파일명 마지막에는 항상 .html 이 붙는다.
			 */
			// src/main/resources/templates/test.html 로 이동하겠다 라는 표시
			return "test";
			// return "html파일명";
			// 돌아가기 "html파일명";
		}
}
