package com.prj.hikari.mybatis.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.prj.hikari.mybatis.spring.mapper")
public class HikariMybatisSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikariMybatisSpringApplication.class, args);
	}
}
