package com.cg.cms.presentation;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.cms.exceptions.CMSException;
import com.cg.cms.model.College;
import com.cg.cms.service.Service;
import com.cg.cms.service.ServiceImpl;

public class UIClass {

	static Logger logger = Logger.getLogger(UIClass.class);
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		// College college=new College(name,phoneNum,email,date);
		System.out.println("Enter 1. for insert\n2.for selecting\n3.exit");
		int option = 0;
		try {
			option = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Give valid input");
			System.exit(0);
		}
		Service service=new ServiceImpl();
		switch (option) {
		case 1:
        College college=insert();
			break;
		case 2:

			break;
		case 3:

			break;

		default:
			break;
		}

	}

	public static College insert() {
		
		System.out.println("Enter details\n");
		System.out.println("Enter name : ");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.println("Enter name : ");
		double phoneNum=scanner.nextDouble();
		System.out.println("Enter name : ");
		String email=scanner.nextLine();
		Date date=new Date();
		College college1=new College(name,phoneNum,email,date);
		
		
		return service.validate(college1);
	    
	}
}
