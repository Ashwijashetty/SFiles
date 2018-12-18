package com.cg.ecm.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class ECMApplication {
	public static void main(String[] args) {
		SpringApplication.run(ECMApplication.class, args);
	}
}
