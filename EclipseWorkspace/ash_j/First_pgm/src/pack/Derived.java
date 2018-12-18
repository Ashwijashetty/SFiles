package pack;

public class Derived extends Base{
protected int c=15;

public Derived() {
	super();
	// TODO Auto-generated constructor stub
System.out.println("Derived default constructors");
}
 public void mtd(){
	//Base base=new Base();
	System.out.println("Derived_method ");
}
}
