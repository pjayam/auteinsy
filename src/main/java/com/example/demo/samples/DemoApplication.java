package com.example.demo.samples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.print("Hello");

		String host = "pop.gmail.com";// change accordingly
		String mailStoreType = "pop3";
		String username = "yourmail@gmail.com";// change accordingly
		String password = "*****";// change accordingly

	}

}
