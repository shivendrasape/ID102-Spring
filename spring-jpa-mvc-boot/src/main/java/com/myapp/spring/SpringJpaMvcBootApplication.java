package com.myapp.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // config/ componentscan/eanable autoconfig// container starteed beans initialized
public class SpringJpaMvcBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaMvcBootApplication.class, args);
	}
}
