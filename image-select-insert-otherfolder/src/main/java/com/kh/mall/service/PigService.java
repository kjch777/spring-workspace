package com.kh.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.dto.Pig;
import com.kh.mall.mapper.PigMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PigService {
	
	@Autowired
	private PigMapper pigMapper;
	
	/*
	 만약, @Autowired 를 사용하지 않는다면,
	 	public PigService(PigMapper pigmapper) {
		 	this.pigMapper = pigMapper;
	 	}
	 이렇게 전부 작성해주어야 한다.
	 
	 서비스에서 추가적으로 수정된 데이터가 매퍼를 통해 DB 에 들어가고,
	 DB 에서 가져온 SQL 에 추가로 수정을 진행한 다음, 컨트롤러에 전달하거나, 전달받기 
	*/
	
	// 1. DB 에 저장된 돼지 정보 행 여러개를 한꺼번에 가져오기 ▶ List(DTO Pig)
	public List<Pig>getAllPigs() {
		return pigMapper.getAllPigs();
	};
			
	// 2. DB 에 저장된 돼지 정보 하나의 행만 가져오기 ▶ DTO Pig
	public Pig getPigById(int pig_id) {
		return pigMapper.getPigById(pig_id);
	};
			
	// 3. 돼지 정보 DB 에 업로드 하기 ▶ 업로드니까 void(Pig)
	// public void upLoadPig(Pig pig) ◀ 돼지 정보를 DB 에 저장할 때, 경로나 이름 중 아무것도 변경할게 없을 때 사용한다.
	public void upLoadPig(String pig_name, int pig_age, MultipartFile file) {
		// 만약, 파일 이름을 DB 에 저장하고 싶다면, 이미지를 업로드 할 때 임시 저장되어 있는 이미지 파일 이름을 가져온다.
		String fileName = file.getOriginalFilename();
		
		// 바탕화면에 pigImg 라는 폴더가 없다면, 생성하는 코드 작성
		String imgSaveFolder = "C:/Users/user1/Desktop/pigImg/";
		
		File folderPathCheck = new File(imgSaveFolder);
		
		// 만약, 위에서 지정해준 폴더가 존재하지 않을 경우, 경로 전부 생성
		// .exist 는, File 자료형에서만 생성된다.
		// 폴더도 파일 자료형으로 취급된다.
		if (!folderPathCheck.exists()) {
			folderPathCheck.mkdirs(); // mkdir: 폴더 한개 / mkdirs: 폴더 여러개
			// mkdir 을 사용해도 상관은 없지만, 혹시 모를 문제를 최소화 하기 위하여 mkdirs 를 사용하는 것이다.
		}
		
		// 폴더가 정상적으로 생성됐는지 확인 과정이 끝났다면, 지정된 폴더에 이미지 올리기
		File imgFileUpLoad = new File(imgSaveFolder + fileName);
		String pathAndNameToDb = imgSaveFolder + fileName;
		try {
			file.transferTo(imgFileUpLoad);
			
			// 모든 준비가 완료됐다면, 이미지 정보를 DB 에 전달해주기
			Pig pig = new Pig();
			pig.setPig_name(pig_name);
			pig.setPig_age(pig_age);
			pig.setPig_image_path(pathAndNameToDb); // Pig_image_path 는 String 값이기 때문에, File 자료형을 가진 값 imgSaveFolder 은 ( ) 안에 위치할 수 없다.
			pigMapper.upLoadPig(pig);
			log.info("Mapper 에 Service 로 pig insert 전달 성공");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	};
}
