package com.skillstorm.threads;

public class Concurrentness {

	public static void main(String[] args) {
		// anonymous inner class (reuselessness)
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while(true) {
					System.out.println("Hello");
				}
			}
		});
		thread.start();
		
		// Java 8 (lambda expression). 
		// Functional Interface (interface with 1 AND ONLY 1 method)
		// Marker Interface (interfaces with 0 methods) -- unrelated
		Thread func = new Thread(() -> {
			// the run method
			while(true) System.out.println("Lambda");
		});
		func.start();
		
		for(;;) {
			System.out.println("Main");
		}
	}
	
}



