
public class Sup_cons {
   private int width;
   private int length;
	
   public int getWidth() {
	return width;
}
public void setWidth(int width) {
	this.width = width;
}
public int getLength() {
	return length;
}
public void setLength(int length) {
	this.length = length;
}
public Sup_cons(){
		
	    System.out.println("Default");
	}
	public Sup_cons(int width, int length) {
		super();
		this.width = width;
		this.length = length;
	}

	public void mtd(){
		System.out.println("user defined"+"          "+ width+"    "+ length);
	}

}
