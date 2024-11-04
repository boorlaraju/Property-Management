package com.raju.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = "com.raju.demo")
public class PropertyManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementSystemApplication.class, args);
	}

}
