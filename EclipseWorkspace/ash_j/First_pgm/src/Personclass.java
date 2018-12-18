
public class Personclass {
    private String Firstname;
    private String Secondname;
    private char Gender;
    private long phone;
	public Personclass(String firstname, String secondname, char gender, long phone) {
		
		Firstname = firstname;
		Secondname = secondname;
		Gender = gender;
		phone = phone;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getSecondname() {
		return Secondname;
	}
	public void setSecondname(String secondname) {
		Secondname = secondname;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void display(){
		System.out.println("\n First Name : "+Firstname+" \n"
				+ "Second Name: "+Secondname+"  \n "
				+ "Gender : "+Gender+"\nPhone Number : "+phone);
	}
	
	public static void main(String args[]){
    	Personclass P1=new Personclass("Radha","Sharma",'F',224821);
    	Personclass P2=new Personclass("Ram","Kumar",'M',292743);
    	Personclass P3=new Personclass("Sadhiya","Sultana",'F',259780);
    	
    	P1.display();
    	P2.display();
    	P3.display();
    	
    }
	
}
