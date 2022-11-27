package com.example.ISAproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ISAprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ISAprojectApplication.class, args);
	}

}
