package com.example.Gauss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main application class for the Gauss simulation.
 * Enables scheduling for periodic tasks.
 */
@SpringBootApplication
@EnableScheduling
public class GaussApplication {

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GaussApplication.class, args);
	}
}
