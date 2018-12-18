
public class Add_pgm {
	
private int num1;
private int num2;
public Add_pgm(int num1,int num2) 
{
	try{
    int tot=num1/num2;
    System.out.println("Sum= "+tot);
	}
	/*catch(Exception e){
		System.out.println("exception occured: "+e.fillInStackTrace());
	}*/
	catch(ArithmeticException d){
		System.out.println("exception occured: "+d.fillInStackTrace());
	}
}
public static void main(String args[]){
	Add_pgm a1=new Add_pgm(1,0);
	Add_pgm a2= new Add_pgm(3,5);
}
public void add_num() {
	// TODO Auto-generated method stub
	
}
}

