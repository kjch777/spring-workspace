package com.kh.mall.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.ImageUpload;

@Mapper
public interface ImageUploadMapper {
	// void insertImageUpload(ImageUpload imageUpload);
	/*
	 * Controller 에서 paramMap 을 Mapper 로 전달할 때,
	 * imageUploadMapper.insertImageUpload(paramMap);
	 * 
	 * paramMap 앞에
	 * Map<String, Object> paramMap
	 * 
	 * Map 과 String, Object 를 작성해 주었기 때문에,
	 * Mapper 에서도 paramMap 앞에 Map<String, Object> 를 붙여준다.
	 * */
	void insertImageUpload(Map<String, Object> paramMap);
}
