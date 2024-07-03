package com.kh.mall.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.mapper.ImageUploadMapper;
import com.kh.mall.util.ImageUploadUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/img")
// templates 하위에 html 파일(upload.html) 을 만들고, 업로드 진행
@Controller // html 파일
public class ImageController {
	
	@Autowired
	private ImageUploadMapper imageUploadMapper;
	/* @RequestMapping("/api/v1/img/upload")
	 * public class ImageController {
	 * 		@PostMapping("/upload")
	 * 		메서드
	 * }
	 * 형식과 같다.
	 * */
	@PostMapping("/upload") // post api 1개: insert 로 DB 에 값 넣는 주소 1개
	public String insertImageUpload(@RequestParam("files") MultipartFile[] files, Model model) {
		String uploadDir = "imgDir"; // 이미지를 저장할 폴더명 지정
		Arrays.asList(files).forEach(file -> {
			String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
			
			// 파일 이름이 정상적으로 나오는지 확인하고 싶다면, log 또는 sysout 을 사용해서 출력하면 된다.
			
			
			// 이미지 업로드 서비스에 이미지 업로드 할 수 있도록 전달
			try {
				ImageUploadUtil.insertImageUpload(uploadDir, fileName, file);
				
				// DB 에 저장할 정보 설정
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("file_name", fileName);
				paramMap.put("upload_dir", uploadDir);
				
				// Mybatis 를 사용한 Mapper 를 이용하여 DB 에 삽입하기
				
				// The method insertImageUpload(ImageUpload) in the type ImageUploadMapper is not applicable for the arguments (Map<String,Object>)
				// paramMap 의 경우, Map<String, Object> 로 값을 전달해주지만,
				// Mapper 는, Map<String, Object> 로 값을 가져오지 않기 때문에 발생하는 오류이다.
				
				log.info(uploadDir);
				log.info(fileName);
				log.info("file check: " + file);
				log.info("paramMap: " + paramMap);
				imageUploadMapper.insertImageUpload(paramMap);
				log.info(uploadDir);
				log.info(fileName);
				log.info("file check: " + file);
				log.info("paramMap: " + paramMap);
			
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		return "index";
	}
	
	@GetMapping("/upload") // get api 1개: select 또는 보여주기 위한 주소 1개
	public String showUploadForm(Model model) { // Model model
		return "upload";
	}
}
