package com.kh.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.mall.dto.Companies;
import com.kh.mall.mapper.CompaniesMapper;

@Service
public class CompaniesService {
	
	@Autowired
	private CompaniesMapper companiesMapper;
	
	// 회사 정보가 저장되어 있는 DB 값을, 회사 목록(List) 으로 Controller 에 전달해주기
	public List<Companies> getAllCompanies() {
		return companiesMapper.getAllCompanies();
	}

}
