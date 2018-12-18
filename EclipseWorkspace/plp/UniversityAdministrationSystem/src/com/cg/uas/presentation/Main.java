package com.cg.uas.presentation;

import java.util.Scanner;

import com.cg.uas.exceptions.UASException;
import com.cg.uas.service.IUserService;
import com.cg.uas.service.UserServiceImpl;

public class Main {
public static void main(String[] args) throws UASException {
	IUserService service=new UserServiceImpl();
	Scanner scanner=new Scanner(System.in);
	System.out.println("Enter loginId:");
	String loginId=scanner.nextLine();
	System.out.println("Password:");
	String password=scanner.nextLine();
	String role=service.getRole(loginId,password);
	System.out.println("The role is :"+role);
if(role.equals("admin")){
	AdminConsole ac=new AdminConsole(loginId);
	ac.start();
}

}
}
