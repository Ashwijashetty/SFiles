package com.cg.loggers.demo;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Main {
	static Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		logger.info("file configured..");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number 1:");
		int num1 = scanner.nextInt();
		logger.info("number1 is : " + num1);
		System.out.println("Enter number 2:");
		int num2 = scanner.nextInt();
		logger.info("number2 is : " + num2);
		System.out.println("Enter number 3:");
		int num3 = scanner.nextInt();
		logger.info("number3 is : " + num3);

	}

}
