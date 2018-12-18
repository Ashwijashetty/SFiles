package new_pack;

import java.util.Arrays;

public class array_examp {
int Id;
String name;

public array_examp(int Id, String name) {
	super();
	Id = Id;
	this.name = name;
	System.out.println("The Id is: "+Id+" of Student : "+name);
	
}



@Override
public String toString() {
	return "array_examp [Id=" + Id + ", name=" + name + "]";
}



public static void main(String[] args) {
	array_examp[] trainee=new array_examp[5];
	trainee[0]=new array_examp(01,"Abc");
	trainee[1]=new array_examp(02,"Xyz");
	trainee[3]=new array_examp(03,"Rst");
	System.out.println(trainee[1]);
	
}
}


