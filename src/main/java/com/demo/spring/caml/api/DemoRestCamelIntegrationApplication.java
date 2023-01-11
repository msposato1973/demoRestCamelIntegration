package com.demo.spring.caml.api;

import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.demo.spring.caml.api.entity.Order;
import com.demo.spring.caml.api.repository.OrderRepository;


@SpringBootApplication
@EnableAutoConfiguration
public class DemoRestCamelIntegrationApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(DemoRestCamelIntegrationApplication.class);

	public static void main(String[] args) {
		
		
		logger.info("main - DemoRestCamelIntegrationApplication.run: begin");
		SpringApplication.run(DemoRestCamelIntegrationApplication.class, args);
		logger.info("run - DemoRestCamelIntegrationApplication ");
	}

	@Bean
	CommandLineRunner initializeData(@Autowired OrderRepository userRepository ) {
		 logger.info("main - DemoUserManagerApplication.initializeData: begin");
		 return args -> {
		 
			 Collection<Order> listOrder =  Arrays.asList(
				 new Order(67, "Mobile", 5000),
				 new Order(89, "Book", 400),
				 new Order(45, "AC", 15000)
			);
		 
			 
		 
			 userRepository.saveAll(listOrder);
	     };
	}
}
