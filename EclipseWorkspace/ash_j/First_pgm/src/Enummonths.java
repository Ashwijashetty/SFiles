enum Months
  {
	  Jan(31),Feb(28),Mar(31),Dec(25);
	 private int days;
	  private Months(int days) {
		this.days = days;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	  }
  
public class Enummonths {
	public static void main(String args[]){
		System.out.println("Dys in Feb is "+Months.Feb.getDays());
		System.out.println("Dys in Jan is "+Months.Jan.getDays());
		
	}
}
