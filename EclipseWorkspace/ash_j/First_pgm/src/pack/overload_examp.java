package pack;

public class overload_examp {
	int a = 12;
	int b = 9;
	
	void mtd(){
		int num=a+b;
		System.out.println("add: "+num);
	}
	void mtd(int a ){
		int num=a;
		System.out.println("buffer: "+num);
	}
	void mtd(int a , int b){
		int num= a-b;
		System.out.println("diff :"+num);
	}
public static void main(String[] args) {
	overload_examp p=new overload_examp();
	p.mtd();
	p.mtd(20);
	p.mtd(12,3);
}
}
