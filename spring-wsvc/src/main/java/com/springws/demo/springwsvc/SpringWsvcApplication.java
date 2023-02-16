package com.springws.demo.springwsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class SpringWsvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWsvcApplication.class, args);
	}

}
