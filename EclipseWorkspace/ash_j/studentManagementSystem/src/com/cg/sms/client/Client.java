package com.cg.sms.client;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sms.dao.StudentDAO;
import com.cg.sms.entity.Student;
import com.cg.sms.exception.StudentException;
import com.cg.sms.services.StudentService;
import com.cg.sms.services.StudentServiceIMPL;
import com.cg.sms.dao.StudentDaoIMPL;

public class Client {
	
		public static void main(String[] args) throws StudentException{
			
			Student student=new Student();
			StudentService student1=new StudentServiceIMPL();
			Scanner scan=new Scanner(System.in);
			boolean x=true;
			do{
				
			System.out.println("Press 1 to enter student details "
					+ "\nPress 2 to enter to display student details"
					+"\nPress 3 to exit");
			int choice=scan.nextInt();
			switch(choice){
			case 1:
				//studentname
			System.out.println("\nEnter Student name: ");
			String studentName=scan.next();
			Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]");
		    Matcher mt= pattern.matcher(studentName);
		    if(mt.find()){
		    	student.setStudentName(studentName);
		    }else{
		    	System.out.println("Invalid Student name");
		        break;
		    }
		    //studentId
			System.out.println("\nStudent ID: ");
			String studentId=scan.next();
			Pattern pattern1 = Pattern.compile("[0-9]{6}");
		    Matcher mt1 = pattern1.matcher(studentId);
		    if(mt1.matches()){
		    	long studentid=Long.parseLong(studentId);
		    	student.setStudentId(studentid);
		    }else{
		    	System.out.println("Invalid Student ID");
		        break;
		    }
		    //student phone number
			System.out.println("\nStudent Phone no.: ");
			String studentPhoneNum=scan.next();
			Pattern pattern2 = Pattern.compile("[0-9]{10}");
		    Matcher mt2 = pattern2.matcher(studentPhoneNum);
		    if(mt2.matches()){
		    	long studentpn=Long.parseLong(studentPhoneNum);
		    	student.setStudentId(studentpn);
		    }else{
		    	System.out.println("Invalid phone number");
		        break;
		    }
		    //student email id
			System.out.println("\nStudent Email Id: ");
           	String studentEmailId=scan.next();
           	Pattern pattern3 = Pattern.compile("^(.+)@(.+)$",Pattern.CASE_INSENSITIVE);
		    Matcher mt3 = pattern3.matcher(studentEmailId);
		    if(mt3.matches()){
		    	student.setStudentEmailId(studentEmailId);
		    }else{
		    	System.out.println("Invalid emailId");
		        break;
		    }
		    //student city
            System.out.println("\nStudent City: ");
            String studentCity=scan.next();
            Pattern pattern4 = Pattern.compile("[A-Z]{1}[a-z]");
		    Matcher mt4 = pattern4.matcher(studentCity); 
		    if(mt4.find()){
		    	student.setStudentEmailId(studentCity);
		    }else{
		    	System.out.println("Invalid city name");
		        break;
		    }
			
			case 2:
				StudentService.viewDetails(student);
				break;
			
			case 3:
				break;
		
			}
			}
						while (x=true);
		
}
}
