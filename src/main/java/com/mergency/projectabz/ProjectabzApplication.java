package com.mergency.projectabz;

import java.sql.DriverManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;

@SpringBootApplication
public class ProjectabzApplication {

	public static void main(String[] args) {
		ConfigLoader.loadEnv();
		SpringApplication.run(ProjectabzApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			try {
				String url = System.getProperty("DB_URL");
				String username = System.getProperty("DB_USERNAME");
				String password = System.getProperty("DB_PASSWORD");

				try (Connection connection = DriverManager.getConnection(url, username, password)) {
					if (connection != null) {
						System.out.println("Connection Complete");
					} else {
						throw new Exception("Connection Failed");
					}
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}
		};
	}
}
