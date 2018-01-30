package com.springactivity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.springactivity.config","com.springactivity.controllers","com.springactivity.model","com.springactivity.services"})
//@EnableJpaRepositories("com.springactivity.repositories")
public class SpringactivityApplication  {

	public static void main(String[] args) {

		SpringApplication.run(SpringactivityApplication.class, args);

	}
}
