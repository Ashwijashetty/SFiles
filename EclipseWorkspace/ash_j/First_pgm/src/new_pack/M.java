package new_pack;

  public class M {

	public static void main(String[] args) {
		
		Derived1 derived=new Derived1();

		derived.mtd1();
		derived.mtd();
		System.out.println("Value of C:"+derived.c);
		//
		//System.out.println(derived.a+derived.b);
	}
}
  
