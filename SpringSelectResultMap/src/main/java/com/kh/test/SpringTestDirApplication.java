package com.kh.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @MapperScan("com.kh.test.mapper") ◀ 매퍼 패키지명
@SpringBootApplication
public class SpringTestDirApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestDirApplication.class, args);
	}

}
