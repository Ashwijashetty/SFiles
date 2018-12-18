package com.cg.collection.list;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

public class ArrayHashMap {
	public Hashtable<Integer,Integer> getSquares(int a[]){
		Hashtable<Integer,Integer> hashtable=new Hashtable(a.length);
		for(int i=0;i<a.length;i++){
			hashtable.put(a[i],(a[i]*a[i]));
		}
		return hashtable;
		
	}
public static void main(String[] args) {
	
	System.out.println("Enter the size of array ");
	Scanner scanner=new Scanner(System.in);
	int n=scanner.nextInt();
    int[] a=new int[n];
	System.out.println("Enter array elements ");

	for(int i=0;i<n;i++){
		 a[i]=scanner.nextInt();
	}
	
	ArrayHashMap arrayHashMap=new ArrayHashMap();
	Hashtable<Integer,Integer> hashtable=new Hashtable(a.length);
	hashtable=arrayHashMap.getSquares(a);
	System.out.println(hashtable);
}
}
