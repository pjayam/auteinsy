package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutoTelephonicInterviewSystem {

	public static void main(String[] args) {
		SpringApplication.run(AutoTelephonicInterviewSystem.class, args);
		System.out.println("Spring Boot Application!....");
	}

}
