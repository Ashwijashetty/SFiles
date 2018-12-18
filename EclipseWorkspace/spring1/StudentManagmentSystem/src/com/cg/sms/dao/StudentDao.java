package com.cg.sms.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component("studentDao")
public class StudentDao implements IStudentDao{


	public List<String> getNames() {
		List<String> list = new ArrayList<>();
		list.add("Ram");
		list.add("Sita");
		/*for(String s:list){  
			 System.out.println(s); 
			 } */
		
	return list;
		}

}
