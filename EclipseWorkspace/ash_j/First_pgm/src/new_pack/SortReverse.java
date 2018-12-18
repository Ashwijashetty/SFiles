package new_pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class SortReverse {
 public static List<Integer> sortMethod(List<Integer> list){
	List num=new ArrayList<>();
	 Iterator<Integer> iterator=list.iterator();
	
	 while(iterator.hasNext()){
		int i= iterator.next();
		int reverse=0;
		 int digit=0;
		 while(i!=0){
		 digit=i%10;
		 reverse=(reverse*10)+digit;
		 i=i/10;
		 } num.add(reverse);
		 }
		Collections.sort(num);
		return(num);
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         List<Integer> list=new ArrayList<>();
         /*list.add(12);
         list.add(23);
         list.add(96);
         list.add(45);
         System.out.println(list)*/;
         //To dynamically read array
         Scanner scan=new Scanner(System.in);
         System.out.println("Enter the size");
         int n=scan.nextInt();
         System.out.println("_______________");
         while(n!=0){
        	 list.add(scan.nextInt());
        	 n--;
         }
         
         sortMethod(list);
         List<Integer> list1 =   sortMethod(list);
 		System.out.println("Reversed and reordered : "+list1);
}
}
