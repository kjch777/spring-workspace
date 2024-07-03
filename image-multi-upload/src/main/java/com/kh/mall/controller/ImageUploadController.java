package com.kh.mall.controller;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.util.FileUploadUtil;
/*
 * 보통 기획 ▶ 백엔드 ▶ 프론트엔드 순서로 협업을 한다.
 * 이 때, @RestController 를 사용한다.
 * 
 * @GetMapping 작성하고 @GetMapping("/주소 ◀ 이게 api 이다.")
 * 
 * @Controller: 주로 view(화면/html) 을 반환하기 위해 사용한다.
 * 
 * @RestController: @Controller 와 @ResponseBody 가 합쳐진 형태로, json 형태의 객체 데이터를 반환하기 위해 사용한다.
 * 					백엔드 개발자가 아직 view(화면/html) 가 없을 때, 데이터가 무사히 들어오고, 나오는지 확인하기 위해 사용하는 컨트롤러이다.
 * 					React 로 프론트엔드를 만들 때 사용하기도 한다.
 * 
 * api == /로 된 Mapping
 * */

@RequestMapping("api/v2/img") // ImageUploadController 하위에 작성하는 모든 주소 앞에 api/vi/img 가 붙는다.
@RestController // 백엔드 용으로 작성하는 Controller
public class ImageUploadController {
	
	// Request method 'GET'
	@GetMapping("/upload") // get api 1개 생성 == api/v2/img/upload
	public String get() {
		return "html 파일의 위치나 주소를 가리켜야 한다.";
	}
	
	@PostMapping("/upload") // @RequestMapping 때문에, api/v1/img/upload 가 된다.
	// post api 1개 생성 == api/v2/img/upload
	
	public void saveImage(@RequestParam("files")MultipartFile[] files) {
		String uploadFolderPath = "imgFolder"; // static 하위에 imgFolder 를 만들어, 업로드할 것이다.
		
		// 배열에 이미지를 담아, 한번에 여러개 전송하기
		Arrays.asList(files).stream().forEach(file -> {
			
			// import org.springframework.util.StringUtils;
			// 파일 이름에서 경로를 깔끔하게 정리해준 것
			// StringUtils 에 있는 cleanPath 기능: 파일 이름에 포함될 수 있는, 혹시 모를 악의적일 수 있는 값을 제거한 것이다.
			// file 에서 가져오기(= get) 원본(= Original) 파일 이름(= Filename())
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			System.out.println(fileName);
			
			try {
				// 파일 올리기 ◀ 업로드 할 폴더(파일) 위치에, 내가 원하는 파일 이름으로 파일을 업로드 하겠다.
				FileUploadUtil.saveFile(uploadFolderPath, fileName, file);
			
			} catch(Exception e) {
				
			}
		});
	}
}
