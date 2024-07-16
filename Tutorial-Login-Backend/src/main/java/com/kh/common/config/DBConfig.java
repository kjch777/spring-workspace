package com.kh.common.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



// 설정
@Configuration // = 컴퓨터 설정(= 구성)

// @PropertySource: properties 파일의 내용을 이용하겠다는 어노테이션이다.
// 다른 properties 파일도 추가하고 싶다면, 어노테이션을 계속 추가해주면 된다.
@PropertySource("classpath:/config.properties") // ** 추후 변경할 것
public class DBConfig {

	@Autowired
	private ApplicationContext applicationContext; // 폴더 흐름
	// import org.springframework.context.ApplicationContext; 
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	// properties 파일의 내용을 이용하여 생성되는 bean 을 설정하는 어노테이션이다.
	// prefix = "시작 위치를 지정하여, (위에서는)spring.datasource.hikari 로 시작하는 설정을 모두 적용해준다."
	// spring.datasource.hikari == Oracle DataBase 와 연결할 때 사용하는 Pool 이다.
	// 빠르고 가벼워 자주 사용된다.
	public HikariConfig hikariConfig() { // ▶ 여기서는 주소 설정만 한 것이다.
		return new HikariConfig();
	}
	
	@Bean // SpringContext 스프링 안에서 관리되고 있는 기능임을 알려주는 설정이다.
	public DataSource dataSource(HikariConfig config) { // ▶ 연결된 DB 를 Spring 에서 관리하겠다. 관리하는 용도로 등록한 것이다.
		DataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
	// MyBatis 설정 추가
	// SqlSessionFactory: SqlSession 을 만드는 객체
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource); // 이 코드 한 줄이 누락됐다.
		
		// mapper 파일이 모여있는 경로 설정
		sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**.xml")); // ** 추후 변경할 것
		
		// 별칭을 지정해야 하는 DTO 가 모여있는 패키지 지정
		// ▶ 해당 패키지에 있는 모든 클래스가 클래스명으로 별칭이 지정된다.
		// Alias: 별칭, Aliases: 별칭들, Package: 폴더 밑에 있는 파일 모두
		sessionFactoryBean.setTypeAliasesPackage("com.kh.dto"); // ** 추후 변경할 것
		
		// MyBatis 설정 파일 경로 지정
		sessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml")); // ** 추후 변경할 것
		
		return sessionFactoryBean.getObject();
	}
	
	// 기본 SQL 실행 + commit 처리 = 트랜잭션 처리
	// commit: 파일 최종 저장
	// SqlSessionTemplate = 기본 SQL 실행 + 트랜잭션 처리
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}
	
	// 전반적인 commit 과 rollback 과 같은 관리를 해주는 트랜잭션 매니저
	// DataSourceTransactionManager: 트랜잭션 매니저
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}