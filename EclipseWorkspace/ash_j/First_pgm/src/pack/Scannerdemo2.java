package pack;

import java.util.Scanner;

public class Scannerdemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*Scanner scanner=new Scanner("1,2,3,4").useDelimiter(",");
while(scanner.hasNextInt()){
	int num=scanner.nextInt();
	System.out.println(num);
}

long start=System.currentTimeMillis();
for(int j=0;j<1000000;j++);

long end=System.currentTimeMillis();
System.out.println("Duration for this for loop is:");
System.out.println(end-start);
System.out.println(start);
System.out.println(end);
*/	Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name : ");
		String input= scanner.nextLine();
		int upcount=0;
		int lowercount=0;
		if(!input.isEmpty()){
			for(char ch:input.toCharArray())
			{
				if(!Character.isDigit(ch)&& Character.isAlphabetic(ch)){
					if(Character.isUpperCase(ch)){
						upcount++;
					}
					else{
						lowercount++;
			}
			}
			}
	 System.out.println("Uppercase count : "+upcount);
	 System.out.println("Lowercase count : "+lowercount);
		}
}
}

