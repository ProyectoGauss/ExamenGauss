package com.example.Gauss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GaussApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaussApplication.class, args);
	}
}
