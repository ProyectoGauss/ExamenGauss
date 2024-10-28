package com.example.Gauss;

import com.example.Gauss.Factory.Component.ComponentProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Main application class for the Gauss simulation.
 * Enables scheduling for periodic tasks.
 */
@SpringBootApplication
@EnableScheduling
@EnableWebFlux
public class GaussApplication implements CommandLineRunner {

	@Autowired
	private ComponentProducer componentProducer;

	@Autowired
	private CustomScheduler customScheduler;

	/**
	 * Main method to run the Spring Boot application.
	 *
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GaussApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customScheduler.scheduleTasks();
	}
}
