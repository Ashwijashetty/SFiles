package com.cg.multithreading.demos;

class ChildThread extends Thread{
	
	@Override
	public void run() {
	for(int i=0;i<20;i++){
		System.out.println("chld thread: "+i);
	}
	}
}
class ChildThread2 extends Thread{
	
	@Override
	public void run() {
	for(int i=0;i<3;i++){
		System.out.println("chld thread2: "+i);
	}
	}
}
public class ThreadMain {

	public static void main(String[] args) {
		ChildThread thread = new ChildThread();
		thread.start();
		ChildThread2 thread1 = new ChildThread2();
		thread1.start();
		
		for(int i=0;i<5;i++){
			System.out.println("main thread : "+i);
		}

	}

}
