package com.kh.mall.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
// @Autowired 는 클래스 안에서만 사용 가능하고, 클래스 안에 있는 변수마다 하나씩 설정해 주어야 한다. 
// @RequiredArgsConstructor 는 클래스 밖에서 사용이 가능하다.
// (내부에서 하나씩 설정해 줄 필요가 없고, 외부에서 전체적으로 설정해 줄 수 있다.)
// spring 에서 만든 어노테이션은 명칭이 상대적으로 짧고, lombok 에서 만든 어노테이션은 명칭이 상대적으로 길다.

@Service
public class EmailService {

	// java 에서 기본적으로 제공하는 이메일 보내기 기능 틀이다.
	// 이메일을 전송할 때, 어느회사/어느규격 의 이메일인지 알 수 없기 때문에
	// 보내는 사람과 내용, 받는 사람 정도의 틀만 제공을 하는 것이다.
	private final JavaMailSender javaMailSender;
	
	// 이메일을 보낼 이메일의 주소값
	private static final String senderEmail = "kjch911229@gmail.com"; // 이메일을 보낼 담당자의 이메일을 작성하면 된다.
	// 지금은 application.properties 에 작성해둔 이메일을 그대로 사용하는 것이다.
	
	private static int number; // 인증번호를 보낼 숫자 공간
	
	// 랜덤으로 인증번호를 생성하는 메서드(기능/동작) 작성
	// 임의의 숫자(6자리) 를 생성하는 코드이다.
	// Math.random(): 0.0 ~ 1.0 미만인 임의의 소수(실수) 생성
	// 	예를 들어 0.0 ~ 0.9999 사이의 소수(실수) 값을 반환하는 식이다.
	// Math.random() 에 곱하기 (90000) 을 해주면, 0.0 ~ 899999.99999 사이의 실수 값을 반환하는 식이다.
	// 정수는 앞에서부터 0 이 아닌 수가 나오기 전까지 모두 0 이면
	// 	예를 들어 001 ▶ 1 로 변한다.
	// 100000 ~ 189999 사이의 임의의 숫자 6자리(정수) 생성
	public static void randNum() {
		number = (int) (Math.random() * (90000)) + 100000;
	}
	
	// 메일 양식 기능
	public MimeMessage createMail(String mail) {
		
		// 인증번호 생성 메서드 불러오기
		randNum();
		
		// 생성된 인증번호를 담을 변수 생성
		MimeMessage message = javaMailSender.createMimeMessage();
		// 메시지를 보낼 공간 생성
		
		// MimeMessage: 이메일의 본문을 담당한다. ex) 첨부파일, 헤더 등을 같이 보낼 수 있게 해준다.
		// java 에서 기본적으로 제공하는 기능이다.
		
		try {
			message.setFrom(senderEmail); // 인증 번호를 보낼 이메일(담당자) 의 이메일 주소
			
			message.setRecipients(MimeMessage.RecipientType.TO, mail); // ◀ String 타입
	     // message.setRecipient(MimeMessage.RecipientType.TO, mail);     ◀ address 타입
			
			// 태그로 img src 를 사용하여 이미지를 같이 보낼 수도 있고,
			// 첨부파일을 참조하는 태그를 사용하여 첨부파일도 같이 보낼 수 있다.
			
			message.setSubject("이메일 인증 번호입니다."); // 보낼 이메일의 제목
			String emailBody = "";
			emailBody += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
			emailBody += "<h1>" + number + "</h1>";
			message.setText(emailBody, "utf-8", "html");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return message; // message.set 으로 작성한 모든 내용을 message 에 담아서 전달하기
	}
	
	public int sendEmail(String mail) {
		MimeMessage message = createMail(mail);
		javaMailSender.send(message);
		return number;
	}
}
