package com.skillstorm.patterns;

public class BigHeavyObjects {
	
	public static LazilyLoadedSingleton one;
	public static LazilyLoadedSingleton two;

	public static void main(String[] args) {
		//new EagerlyLoadedSingleton();
		EagerlyLoadedSingleton e = EagerlyLoadedSingleton.INSTANCE;
		
		for(int x=0; x<100_000; x++) {
			new Thread(() -> {
				BigHeavyObjects.one = LazilyLoadedSingleton.getInstance();
			}).start();
			
			new Thread(() -> {
				BigHeavyObjects.two = LazilyLoadedSingleton.getInstance();
			}).start();
			if(BigHeavyObjects.one != BigHeavyObjects.two) {
				throw new RuntimeException("Fail");
			}
		}
		System.out.println("Done");
	}
	public static void go() {
		EagerlyLoadedSingleton e = EagerlyLoadedSingleton.getInstance();
	}
	
}

/**
 * Why: We want only ONE instance of object in memory.. EVER
 * 
 * How: Lazy / Eager 
 * 1. private constructor
 * 2. store an instance of the object
 * 3. optional : use a static getter with private instance
 * @author PWalsh
 *
 */
final class EagerlyLoadedSingleton {
	// 1.
	private EagerlyLoadedSingleton() {
		// doing some really heavy stuff.. 5-10min to load
	}
	// 2.
	public static final EagerlyLoadedSingleton INSTANCE = new EagerlyLoadedSingleton();
	// 3.
	public static final EagerlyLoadedSingleton getInstance() {
		return INSTANCE;
	}
}

/**
 * 4. method to selectively instantiate
 */
final class LazilyLoadedSingleton {
	private LazilyLoadedSingleton() {}
	
	// not final
	private static LazilyLoadedSingleton instance;
	// dummy object to serve as the "intrinsic lock"
	private static Object lock = new Object();
	
	// 4.
	// synchronized: only one thread at a time
	public static LazilyLoadedSingleton getInstance() {
		// 2 minutes of thread-safe stuff
		// synchronized block
		synchronized(lock) {
			if(instance == null)
				instance = new LazilyLoadedSingleton();
		}	
		// 2minutes of thread-safe stuff
		return instance;
	}
	
	// BankAccount.java
	public void withdraw(double funds) {
		synchronized (this) {
			// use THIS object's monitor to lock
			// balance -= funds;
			// balance = balance - funds;
		}
	}
}








