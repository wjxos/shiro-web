package com.wjx.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@MapperScan("com.wjx.shiro.shiro.mapper")
public class ApplicationApp {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationApp.class, args);
		log.info("Hello World!");
	}

}
