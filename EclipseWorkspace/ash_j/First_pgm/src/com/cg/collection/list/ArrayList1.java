package com.cg.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<String> list = new ArrayList();
list.add("CG");
list.add("abc");
//System.out.println(list.get(1));
list.add("Aed");
list.add("ask");
list.add("wer");
Iterator<String> iterator=list.iterator();
while(iterator.hasNext()){
	String name=iterator.next();
	System.out.println(name);
}System.out.println("Using for loop ");
for(String i:list){
	System.out.println(i);
}

	}

}
