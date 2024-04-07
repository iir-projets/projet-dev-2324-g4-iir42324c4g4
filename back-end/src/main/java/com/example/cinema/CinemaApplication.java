package com.example.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.example.cinema")

@SpringBootApplication
public class CinemaApplication {
	public static void main(String[] args) {

		SpringApplication.run(CinemaApplication.class, args);
	}

}
