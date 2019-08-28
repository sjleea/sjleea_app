package com.example.lsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class LsisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LsisApplication.class, args);
	}

}
