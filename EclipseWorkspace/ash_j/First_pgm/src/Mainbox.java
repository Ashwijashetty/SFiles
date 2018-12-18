
public class Mainbox {

	public static void main(String[] args) {
		Sup_cons box=new Sup_cons();
		Sup_cons box1=new Sup_cons(52, 12);
		   box1.mtd();
		box.setWidth(85);
	    box.setLength(45);
		
	     box.mtd();
        
	    System.out.println(box.getWidth());
        System.out.println(box.getLength());
	}

}
