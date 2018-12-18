package com.cg.multithreading.demos;

class RunnableClass implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("ct: " + i);
		}

	}

}

public class RunnableMain {
	public static void main(String[] args) {
		RunnableClass class1 = new RunnableClass();
		Thread thread = new Thread(class1);
		thread.start();
		for (int i = 0; i<=5; i++) {
			
			System.out.println("mt: " + i);
		}
	}
}
