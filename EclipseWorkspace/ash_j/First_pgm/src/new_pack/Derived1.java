package new_pack;
import pack.Base;

	public class Derived1 extends Base{
		protected int c=15;

		public Derived1() {
			super.mtd1();
		    System.out.println("Derived default constructors");
		}
		 protected void mtd(){
			Base base=new Base();
			System.out.println("Derived_method ");
			
		    System.out.println("base_class  "+a+b);
}
}