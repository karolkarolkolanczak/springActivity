package com.springactivity;

import com.springactivity.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.transaction.Transactional;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.springactivity.config","com.springactivity.controllers","com.springactivity.model","com.springactivity.services"})
//@EnableJpaRepositories("com.springactivity.repositories")
public class SpringactivityApplication implements CommandLineRunner {

	private ProductService productService;

	@Autowired
	public SpringactivityApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringactivityApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... strings) throws Exception {
		productService.databaseInitialLoad();
	}
}