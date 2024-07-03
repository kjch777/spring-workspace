package com.kh.mall.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/*
 * html 파일과 db 가 서로 주고 받을 때는 Service 라는 명칭으로 코드를 작성하지만,
 * 백엔드에서 단독으로 진행하는 값이나, 공통으로 설정할 때는
 * util 이라는 명칭을 사용하여 코드를 작성해준다.
 * util ▶ postMan 을 사용하여 파일 업로드가 잘 되고 있는지 테스트를 진행할 수 있다.
 * */
// ImageUploadService ▶ ImageUploadUtil 로 변경해주었다.
// DB 와 아무런 관련이 없고, 오로지 파일이 내 컴퓨터에 무사히 저장되는지만 확인하기 때문이다.
public class ImageUploadUtil {
	
	public static void insertImageUpload(String uploadDir, String fileName, MultipartFile multipartfile) throws IOException {
														 // Controller 에서는 MultipartFile[] ◀ 배열이다. ◀ Service 에서 하나씩 올린 파일을 모두 전송하는 작업을 한다.
															// Service 에서는 MultipartFile ◀ 배열이 아니다. ◀ 파일을 하나씩 올리는 작업을 한다.
		
		Path uploadPath = Paths.get("C:/" + uploadDir);
		
		// 만약, 폴더가 존재하지 않으면 폴더 생성하기
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try(InputStream inputStream = multipartfile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
