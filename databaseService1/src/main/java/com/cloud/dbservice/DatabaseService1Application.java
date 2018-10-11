package com.cloud.dbservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableMongoRepositories(basePackages="com.cloud.dbservice.resource")
@SpringBootApplication
public class DatabaseService1Application {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseService1Application.class, args);
	}
}
