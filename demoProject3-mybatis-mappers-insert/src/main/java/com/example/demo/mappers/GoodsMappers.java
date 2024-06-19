package com.example.demo.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Goods;

/* mapper.xml 에 작성한 id 리스트 모두 작성만 해주는 공간이기 때문에,
 * interface 로 작성해준다.
 * mapper.xml 에 어떤 파일이 존재하는지 리스트만 작성하는 곳이다.
 * @Mapper 라는 어노테이션을 활용하여, Spring Boot 가 mapper 를 찾을 수 있도록 설정해주는 곳이다.
 * (완벽한 기능을 작성해주는 공간이 아니다.)*/
@Mapper
public interface GoodsMappers {
	void insertGoods(Goods goods);
}
