package com.cookie.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.cookie.sso.mapper")
@EnableCaching
public class SsoImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoImplApplication.class, args);
	}
}
