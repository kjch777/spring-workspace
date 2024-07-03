package com.kh.mall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

// 파일 업로드를 하기 위해 설정해주는 공간
public class FileUploadUtil {
	public static void saveFile(String uploadDir, String fileName, MultipartFile mpFile) throws IOException {
		
		// 폴더에 파일을 업로드 하기 위해, 경로 설정하기
		// C:/Users/user1/servlet_jsp_workspace/image-multi-upload/src/main/resources/static/imgFolder/
		
		// 내가 지금 실행하고 있는 java 파일의 위치 주소 값 가져오기
		// 바탕화면에 imgFolder 폴더 생성하고, 이미지 3개 선택해서 폴더에 저장하기(PostMan 사용)
		Path uploadPath = Paths.get("C:\\Users\\user1\\Desktop\\" + uploadDir);
		
		// 만약 이미지를 저장할 폴더가 존재하지 않는다면, 폴더 생성해주기
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		/* 1. java 7버전 이전 / 일반적인 try 구문
		 * try {
		 * 	InputStream inputStream = mpFile.getInputStream();
		 *  메모리 사용량이 아래 코드보다 많다.
		 * }
		 * 
		 * 2. java 7버전 이후 / 효율적인 try 구문
		 * try(InputStream inputStream = mpFile.getInputStream()) {
		 * 	메모리 사용량이 위 코드보다 적다.
		 * }
		 * 
		 * 1번 방식과 2번 방식의 차이점
		 * 코드 1줄을 실행하고, 전달만 하는지?
		 * 
		 * stream 은 buffer 라는, 이미지들을 사용자 눈에 즉시 보여줄 수 있게 모아놓는 공간을 사용하기 때문에,
		 * 메모리 사용량이 상대적으로 높다.
		 * 
		 * 따라서, 다른 코드 줄 보다 메모리 사용량이 많은 Stream 의 경우, (이 안에서 처리하고, 전달해주는 것이 가장 좋다.)
		 * */ 
		
		// 1. InputStream 을 사용하여, 파일을 실제로 저장할 때 사용하기 위해 작성한 객체이다.
			// 파일 데이터(mpFile) 를 가지고(.getInputStream()) 온다.
		try(InputStream inputStream = mpFile.getInputStream()) {
			
			// 2. uploadPath: 파일을 저장할 폴더의 위치를 나타내는 것이다.
				// resolve(해결하다/결합하다): Path 계열에서 + 나 마찬가지로 작동한다.
			 	// 경로와 파일명을 붙여, 한번에 작성할 수 있게 도와주는 것이다.
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath); // 파일 경로 + 파일 이름 이 출력될 것이다.
			
			// 3. Files.copy: 파일들 복사
				// inputStream 의 내용을 filePath 에 복사해주는 것이다.
			
			// 3-1. StandardCopyOption.REPLACE_EXISTING
				// 만약, 동일한 이름의 파일이 이미 존재할 경우 덮어쓰기하는 코드로, 필수로 작성해야 할 필요는 없다.
				// 다만, 추후 파일 업로드 시 동일한 파일 이름 때문에 오류가 발생할 경우를 대비하여 작성한 것이다.
					// 선택 1) 덮어쓰기를 하여 오류가 발생하지 않게 설정
					// 선택 2) 기존에 이미 동일한 이름의 파일이 존재하면, 업로드 하지 못하게 설정 
					// 선택 3) 만약, 동일한 파일 이름이 이미 존재하면 업로드한 날짜 등을 이름 뒤에 추가로 붙게 설정
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch(Exception e) {
			e.printStackTrace(); // 에러 출력
		}
		
	}
}
