package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.Companies;

@Mapper
public interface CompaniesMapper {

	// select 로 모든 목록을 가져올 때는, void 가 아니라 List 로 작성해주어야 한다.
	List<Companies> getAllCompanies();
}
