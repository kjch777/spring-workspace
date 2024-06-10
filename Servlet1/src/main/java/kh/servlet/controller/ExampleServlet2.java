package kh.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ex1") // form action 에 작성해준 경로 연결방법
// 자바 파일이 여러개이고, form 연결이 여러개일 경우, ("/이 위치로 연결해 주는 것이다.")
public class ExampleServlet2 extends HttpServlet {

	// Get 방식 요청을 (method="get" 인 form 태그 제출) 처리하는 메서드
	@Override // HttpServlet 에서 가져와, 개발자에 맞게 다시 작성해 주는 것이기 때문에 재사용(Override) 표시 작성
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 매개변수 request(req), response(resp) 
		 
		 HttpServletRequest request
		 	- 클라이언트 요청 시 자동으로 생성되는 객체이다.
		 	- 요청 시 전달된 데이터, 요청한 클라이언트 정보, 요청을 유연하게 처리하기 위한 객체 등을 제공한다.
		 
		 HttpServletResponse response
		 	- 클라이언트 요청 시 자동으로 생성되는 객체이다.
		 	- 서버가 클라이언트에게 응답할 수 있는 방법을 제공한다.
		 	 (서버 ▶ 클라이언트 출력 스트림(PrintWriter))
		 	 
		 	-- index.html 파일을 만들어, 제출된 이름과 나이 가져오기
		 	--> 제출된 이름, 나이를 전달하는 매개변수(Parameter): 전달된 값을 보여줄 것
		 	
		 	--> 요청에 담긴 특정 파라미터를 가져올 때, name 을 사용한다.
		 	---> String HttpServletRequest.getParameter("name속성값");
		 */
		
		// <input type="text" name="inputName"> 에 입력되어 제출된 값 가져오기
		String inputName = request.getParameter("inputName");
		// 고객들이 입력한 값을, getParameter 에서 name 에 지정한 별칭으로 가져오기
		// <input type="number" name="inputAge"> 에 입력되어 제출된 값 가져오기
		String inputAge = request.getParameter("inputAge");
		
		System.out.println("[서버] /ex1 요청을 받음");
		System.out.println("전달받은 inputName: " + inputName);
		System.out.println("전달받은 inputAge: " + inputAge);
		
		/*
		 http
		 
		 404: 웹 페이지를 찾을 수 없을 때 발생하는 오류이다. 
		 	-> 주로 경로가 잘못됐을 때 발생한다.(프로젝트 위치나 이름이 다를 때도 발생한다.)
		 	-> 지금은 index.html 과 ExampleServlet2 가, 서로 파일 위치를 찾지 못해서 발생하는 오류이다.
		 	-> springboot 에서는 이런 오류가 발생하지 않는다.
		 */
		
		/*---------------------------------------------------------------------------*/
		
		// 응답 처리
		/*
		 서버(현재 프로젝트) -> 클라이언트(브라우저)
		 
		 HTML 코드(문서) 출력 -> 출력된 HTML 코드를 해석하여, 화면에 구성하기
		 	1) 응답하는 문서(데이터) 의 형식과 문자 인코딩 지정
		 	2) 출력용 스트림 가져오기
		 	3) 스트림을 이용하여 html 코드 출력하기 
		 */
		
		// 1) 응답하는 문서(데이터) 의 형식과 문자 인코딩 지정
		response.setContentType("text/html; charset=utf-8");
		
		// 2) 출력용 스트림 가져오기
		PrintWriter out = response.getWriter();
		
		// 3) 스트림을 이용하여 html 코드 출력하기
		StringBuilder sb = new StringBuilder();
		sb.append("<!Doctype html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> /ex1 응답페이지 </title>");
		sb.append("<body>");
		sb.append(String.format("<h1> %s 님의 나이는 %s 입니다. </h1>", inputName, inputAge));
		sb.append("</body>");
		sb.append("</html>");
		
		// sb 에 누적된 html 코드를, 스트림을 이용하여 출력하기
		out.print(sb.toString());
		
		// 현재는 사용하지 않는 방법이다.
	}

}