package com.example.Gauss;

import com.example.Gauss.Factory.FactorySimulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Gauss.Csv")
public class GaussApplication implements CommandLineRunner {

	@Autowired
	private FactorySimulation factorySimulation;

	public static void main(String[] args) {
		SpringApplication.run(GaussApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		factorySimulation.startSimulation();
	}
}
