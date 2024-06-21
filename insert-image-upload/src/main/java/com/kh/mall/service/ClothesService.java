package com.kh.mall.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.mall.dto.Clothes;
import com.kh.mall.mapper.ClothesMapper;

@Service
public class ClothesService {

	@Autowired
	private ClothesMapper clothesMapper;
	
	public List<Clothes> getAllClothes(){
		return clothesMapper.getAllClothes();
	}
	
	public Clothes getClothesById(int clothesId) {
		return clothesMapper.getClothesById(clothesId);
	}
	
	public void uploadClothes(String clothesName, int clothesPrice, String clothesCategory, MultipartFile file) {
		// 파일 이름을 가져온 다음,
		String fileName = file.getOriginalFilename();
		System.out.println("fileName: " + fileName);
		
		// 저장하고자 하는 파일 경로 설정하기
		// 이후에 이미지 파일을 저장하는 폴더가 존재하지 않을 경우, 폴더를 생성할 코드를 작성할 것
		String uploadDir = "C:/Users/user1/Desktop/clothes_images/";
		// 경로 맨 마지막에 / 를 넣어주지 않으면, 원하는 위치보다 이전 폴더에 저장된다.
		File imgFile = new File(uploadDir + fileName);

		// 이후에 이미지 업로드에서 파일 저장 경로에 대한 함수만 따로 설정할 것 
		// public String folder & image 체크
		if(!imgFile.exists()/* 만약, 폴더가 존재하지 않을 때(! 는 없는게 true)*/) {
			imgFile.mkdirs(); // 폴더 생성하기 
		}
		
		try {
			file.transferTo(imgFile); // 이미지를 폴더에 저장하는 코드 /***** 추가 *****/
			// 업로드 한 다음, 저장된 이미지 경로와 함께 돼지 정보를 저장하는 서비스 작성하기
			Clothes clothes = new Clothes();
			clothes.setClothesName(clothesName);
			clothes.setClothesPrice(clothesPrice);
			clothes.setClothesCategory(clothesCategory);
			// pig.setPig_image_path(uploadDir); // 이렇게 하면 파일의 이름을 제외한 앞의 경로만 저장된다.
			
			// 만약, 파일 경로와 이름을 같이 저장하고 싶다면
			clothes.setClothesImagePath(uploadDir + fileName); // DB 에 원래는 "/images/" + 파일이름.jpg 이었었다.
			// ▲ 형식으로 코드를 작성하면, DB 에 /images/파일명.확장자 로 저장될 것이다.
			
			clothesMapper.uploadClothes(clothes);
			System.out.println("파일 업로드 서비스를 성공적으로 완료하였습니다.");
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
	}
}
