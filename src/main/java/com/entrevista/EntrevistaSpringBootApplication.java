package com.entrevista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
public class EntrevistaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrevistaSpringBootApplication.class, args);
	}

}
