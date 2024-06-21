package com.kh.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mall.dto.SAC;

@Mapper
public interface SACMapper {
	// getAllSAC 로 가져온 Select Join 문 보여주기
	List<SAC> getAllSAC();
	
	// 위에서는 모든 과자의 정보를 전부 가져오기 때문에 List 를 사용했지만,
	// 여기서는 하나의 값만 가져올 것이기 때문에 List 를 사용하지 않는다.
	// snack_id 에 해당하는 값만 가져오겠다는 의미의 코드이다.
	SAC getSnackById(int snack_id);
	
	SAC getCompanyById(int company_id);
}
