package com.kh.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.SAC;
import com.kh.mall.mapper.SACMapper;

@Service
public class SACService {

	@Autowired
	private SACMapper sacMapper;
	
	public List<SAC> getAllSAC(){
		return sacMapper.getAllSAC(); // Service Class 안에 Method return 에는 
		// 특정한 파일 이름이 아니라 기능을 넣는 것이기 때문에, " " 를 붙이지 않는다.
	}
	
	public SAC getSnackById(int snack_id){
		return sacMapper.getSnackById(snack_id); 
	}
	
	public SAC getCompanyById(int company_id){
		return sacMapper.getCompanyById(company_id); 
	}
}
