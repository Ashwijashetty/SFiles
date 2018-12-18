package com.cg.TDS.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class TDSApplication {

	public static void main(String[] args) {
		SpringApplication.run(TDSApplication.class, args);
	}
}
