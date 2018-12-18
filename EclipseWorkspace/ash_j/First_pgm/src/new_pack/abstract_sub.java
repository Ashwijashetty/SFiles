package new_pack;

public class abstract_sub extends abstract_examp implements interf_examp{
	public void color(){
		 String c="Red";
		 System.out.println("The color is : "+c);
	 }
	/*public void shape(){
		String s ="Square";
		System.out.println("defined shape :"+s);
	}*/
	public void size(){
		int z =25;
		System.out.println("defined size :"+z);
	}
	public void weigh(){
		int w =525;
		System.out.println("defined weigh :"+w);
	}
	
public static void main(String[] args) {
    interf_examp a=new abstract_sub(); /*a is object for abstract_sub and reference for interf_exam
                                         so called as polymorphic object and it is dynamic binding,
                                       it can be used to restrict or .*/
    //a.shape();
    
	a.color();
	a.size();
	a.weigh();
	System.out.println("variable from interf_examp : "+interf_examp.a);
	
}
}
