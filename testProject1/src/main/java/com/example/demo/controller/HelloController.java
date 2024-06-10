package com.example.demo.controller;

import org.springframework.stereotype.Controller;

/*
 Java 객체: new 연산자에 의해 Heap 영역에 Class 에서 작성된 내용대로 생성된 것
 
 instance: 개발자가 만들고 관리하는 객체
 
 bean: Spring Container(또는 Spring) 가 만들고 관리하는 객체
 */

@Controller // 요청이나 응답을 제어 할 컨트롤러 역할을 명시해준 것이다.
// bean 으로 등록된다. (= 객체로 생성하여 스프링이 관리해 준다.)
public class HelloController {

}
