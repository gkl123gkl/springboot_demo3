package com.aistar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.aistar.mapper")

public class SpringbootZhaopinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootZhaopinApplication.class, args);
	}

}
