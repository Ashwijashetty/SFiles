
public class Det {

	private  int tid;
	private String tname;
	private static String Tdesg="Analyst";
	private static String Tbatch="JEE";
	 
	public Det(int tid,String tname){
		
		System.out.println("Trainee ID: "+tid+" Trainee Name: "+tname+" Trainee Designation : "+Tdesg+" Trainee batch : "+Tbatch);
	}
    public static void main(String args[]){
	Det trainee1=new Det(1,"ABE");
	Det trainee2=new Det(2,"ABD");
	Det trainee3=new Det(3,"ABC");
}
}
