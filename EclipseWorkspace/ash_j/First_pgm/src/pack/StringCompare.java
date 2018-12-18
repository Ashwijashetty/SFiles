package pack;

public class StringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String s1="Hello";//s1 is reference variable
     String s2=new String(s1);//s2 is object
     String s3=s1;
     
     System.out.println("s1 : "+s1);
     System.out.println("s2 : "+s2);
	System.out.println(s1+" equals "+s2+"is "+s1.equals(s2));
	System.out.println(s1+" == "+s2+"is "+s1==s2);
	System.out.println(s1==s3);
	//equals and == aren't same
	}

}
