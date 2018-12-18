package Lab4;

import java.util.Random;

public class Account {
long accNum;
double balance=500;
person accHolder; //Declaration

public long getAccNum() {
	return accNum;
}

public void setAccNum() {
	this.accNum = accNum;
	Random generator = new Random();
	accNum= generator.nextInt(89999);
	System.out.println(" Account Number : "+accNum);
}

public double getBalance() {
	return balance;
}

public void setBalance(double balAmount) {
	balance = balance+balAmount;
	System.out.println(" Initial Account balance : "+balance);
}

public person getAccHolder() {
	return accHolder;
}

public void setAccHolder(person accHolder) {
	this.accHolder = accHolder;
	System.out.println("The Account holder details are ");
}

void deposit(String name,double depositAmount){
	
	balance=balance+depositAmount;
	System.out.println("\nAfter deposit of "+depositAmount+" balance of "+name+" is "+balance);
}
void withdraw(String name,double withdrawAmount){
	
	balance=balance-withdrawAmount;
	System.out.println("\nAfter withdrawal of "+withdrawAmount+" balance of "+name+" is "+balance);
}
private void accHolder(String name, float age) {
System.out.printf("\nThe Account holder name is: "+name+"\n Age : "+age);	
}

@Override
public String toString() {
	return "Account [accNum=" + accNum + ", balance=" + balance
			+ ", accHolder=" + accHolder + "]";
}

public static void main(String args[]){
	Account smith=new Account();
	Account Kathy=new Account();
	smith.accHolder("Smith",26f);
	smith.setAccNum();
	smith.setBalance(2000);
	Kathy.accHolder("Kathy",25f);
	Kathy.setAccNum();
	Kathy.setBalance(3000);
	smith.deposit("Smith",2000);
	Kathy.withdraw("Kathy",2000);
	
}
}
