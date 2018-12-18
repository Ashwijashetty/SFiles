package new_pack;


	import java.util.regex.*; 
	import java.util.Scanner; 
	  
	public class NumberValidation {
	    public static boolean isValid(String s) 
	    { 
	       
	        Pattern p = Pattern.compile("[0-9]{10}"); 
	        Matcher m = p.matcher(s); 
	        return (m.find() && m.group().equals(s)); 
	    } 
	  
	    public static void main(String[] args) 
	    { 
	        String s = "8739213408";
	        if (isValid(s))  
	            System.out.println("Valid Number");         
	        else 
	            System.out.println("Invalid Number");         
	    } 
	}

