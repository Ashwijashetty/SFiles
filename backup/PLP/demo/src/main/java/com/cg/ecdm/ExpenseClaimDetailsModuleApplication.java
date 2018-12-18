package com.cg.ecdm;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ExpenseClaimDetailsModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseClaimDetailsModuleApplication.class, args);
	}
}
