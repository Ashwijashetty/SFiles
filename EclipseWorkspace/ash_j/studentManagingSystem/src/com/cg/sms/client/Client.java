package com.cg.sms.client;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sms.beans.Student;
import com.cg.sms.exception.StudentException;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceIMPL;



public class Client {
	
		public static void main(String[] args) throws StudentException{
			
			try{
			Student student=new Student();
			StudentService student1=new StudentServiceIMPL();
			Scanner scan=new Scanner(System.in);
			
			boolean x=true;
			
			while(x){
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
		    }else
		    	throw new StudentException(studentName);
		    	
		    
		    
		    //studentId
			System.out.println("\nStudent ID: ");
			String studentId=scan.next();
			Pattern pattern1 = Pattern.compile("[0-9]{6}");
		    Matcher mt1 = pattern1.matcher(studentId);
		    if(mt1.matches()){
		    	long studentid=Long.parseLong(studentId);
		    	student.setStudentId(studentid);
		    }else
		    	throw new StudentException(studentId);
		    
		    //student phone number
			System.out.println("\nStudent Phone no.: ");
			String studentPhoneNum=scan.next();
			Pattern pattern2 = Pattern.compile("[0-9]{10}");
		    Matcher mt2 = pattern2.matcher(studentPhoneNum);
		    if(mt2.matches()){
		    	long studentpn=Long.parseLong(studentPhoneNum);
		    	student.setStudentId(studentpn);
		    }else
		    	throw new StudentException(studentPhoneNum);
		    
		    //student email id
			System.out.println("\nStudent Email Id: ");
           	String studentEmailId=scan.next();
           	Pattern pattern3 = Pattern.compile("^(.+)@(.+)$",Pattern.CASE_INSENSITIVE);
		    Matcher mt3 = pattern3.matcher(studentEmailId);
		    if(mt3.matches()){
		    	student.setStudentEmailId(studentEmailId);
		    }else
		    	throw new StudentException(studentEmailId);
		    
		    //student city
            System.out.println("\nStudent City: ");
            String studentCity=scan.next();
            Pattern pattern4 = Pattern.compile("[A-Z]{1}[a-z]");
		    Matcher mt4 = pattern4.matcher(studentCity); 
		    if(mt4.find()){
		    	student.setStudentEmailId(studentCity);
		    }else
		    	throw new StudentException(studentCity);
		    
		    System.out.println("Details registered Successfully");
			break;
			
			case 2:
				student1.viewDetails(student);
				break;
			
			case 3:
				x=false;
				break;
		
			}
			}//while (x=true);
			System.out.println("Exited successfully");	
			
			}catch (StudentException s){
			}
				
			
}
}

