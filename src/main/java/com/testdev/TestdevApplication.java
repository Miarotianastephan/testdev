package com.testdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestdevApplication {

	public String PORT = System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(TestdevApplication.class, args);
	}

}
