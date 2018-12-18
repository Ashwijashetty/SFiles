import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JobSeeker {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	
	System.out.println("Enter name: ");
	String name=scan.next();
	
    Pattern pattern=Pattern.compile("[A-Z]{8}[a-Z]+^_+[a-z]");
    Matcher mt=pattern.matcher(name);
    if(mt.find()){
    	System.out.println("The name is "+name);
    }
    else{
    	System.out.println("Invalid");
    }
}
}
