package pack;

import java.util.Scanner;

public class Scannerdemo {
public static void main(String args[]){
	
	Scanner scanner =new Scanner(System.in);
 
System.out.println("What is your name?");
while(true){
	

String input=scanner.nextLine();
 if(input.isEmpty())
 {
	 break; 
 }
 System.out.println("Your name is "+input);
}
  scanner.close();
}}
