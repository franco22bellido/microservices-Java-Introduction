package com.pedals.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class PedalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PedalsServiceApplication.class, args);
	}

}
