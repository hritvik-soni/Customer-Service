package com.hritvik.SunbaseDataAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SunbaseDataAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunbaseDataAssignmentApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
