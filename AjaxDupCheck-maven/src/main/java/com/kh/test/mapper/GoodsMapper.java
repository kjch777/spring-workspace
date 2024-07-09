package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.dto.Goods;

@Mapper
public interface GoodsMapper {

	Integer existsByName(Goods goods);
}
