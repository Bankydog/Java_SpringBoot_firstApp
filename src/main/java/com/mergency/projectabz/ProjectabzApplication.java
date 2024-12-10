package com.mergency.projectabz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectabzApplication {

	public static void main(String[] args) {
		ConfigLoader.loadEnv();
		SpringApplication.run(ProjectabzApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> System.out.println("Connection Complete");
	}
}
