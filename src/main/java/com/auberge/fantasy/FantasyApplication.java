package com.auberge.fantasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FantasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FantasyApplication.class, args);
	}

}
