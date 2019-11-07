package com.skillstorm.threads;

/**
 * 1. Extend Thread
 * 2. Implement Runnable
 * @author PWalsh
 *
 */
public class ConcurrentProcessing {
	
	/**
	 * main-thread
	 * @param args
	 */
	public static void main(String[] args) {
							// Thread(Runnable obj)
		Thread thread = new Thread(new B());
		thread.start(); // start calls run()
		
		// IS-A thread, call start
		A a = new A();
		a.start();
		
		while(true) System.out.println("Main");
	}

}

// much more flexible approach
class B implements Runnable {
	public void run() {
		for(int x=0;;x++) {
			System.out.println("B");
			if(x % 56 == 0) {
				throw new RuntimeException();
			}
		}
	}
}

/**
 * Super-thread framework
 */
class A extends Thread{
	/**
	 * What to do when this thread starts
	 * payload
	 * thread's job
	 */
	public void run() {
		while(true) {
			System.out.println("A");
		}
	}
}



