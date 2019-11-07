package com.skillstorm.threads;

import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollections {

	// java.util is NOT thread-safe
	//static LinkedList<Integer> shared = new LinkedList<>();
	
	// see java.util.concurrent
	static volatile CopyOnWriteArrayList<Integer> shared = new CopyOnWriteArrayList<>();
	
	static {
		for(int x=0; x<100; x++) {
			shared.add(x);
		}
	}
	
	public static void main(String[] args) {
		new Thread(()->{
			for (Integer i : shared) {
				System.out.println(i);
			}
			
		}).start();
		
		new Thread(()->{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			shared.remove(50);
			for (Integer i : shared) {
				System.err.println(i);
			}
		}).start();
	}
	
	
	
}


