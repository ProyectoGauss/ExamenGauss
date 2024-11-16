package com.example.Gauss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GaussApplication implements CommandLineRunner {

    @Autowired
    private SchedulingService schedulingService;

    public static void main(String[] args) {
        SpringApplication.run(GaussApplication.class, args);
    }

    @Override
    public void run(String... args) {
        schedulingService.scheduleProduction(Arrays.asList("Component1", "Component2", "Component3"));
    }
}
