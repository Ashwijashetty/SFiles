package com.cg.multithreading.demos;

class ThreadName extends Thread {
	@Override
	public void run() {
		System.out.println("Thread 1 : " + Thread.currentThread().getName());
	}
}

class ThreadName2 extends Thread {
	@Override
	public void run() {
		System.out.println("Thread 2 : " + Thread.currentThread().getName());
		Thread.currentThread().setName("USERdEFINED");
		System.out.println("Thread 2 : " + Thread.currentThread().getName());
	}
}

public class ThreadNames {
	public static void main(String[] args) {
		ThreadName name1 = new ThreadName();
		name1.start();
		ThreadName name2 = new ThreadName();
		name2.start();
		System.out.println("");

	}
}
