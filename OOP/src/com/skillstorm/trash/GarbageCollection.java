package com.skillstorm.trash;

import java.util.List;

public class GarbageCollection {
	// hard-coding the value
	static int var = 0;
	static int v;
	static {
		// run some logic to determine value
		v= 10;
	}
	// instance block
	{
		String instance; // block scope
	}

	public static void main(String[] args) {
		Classroom.dean = "Dan";
		run();
		System.gc(); // suggests garbage collection
		Runtime.getRuntime().gc(); // suggests
		System.out.println("Done");
	}
	
	public static void run() {
		// method scope
		Classroom c = new Classroom();
		c = null;
		//Classroom c = new Classroom();
	}
	
	// room : method scope
	public static void go(Classroom room) {
		for(int x=0;x<10;x++) {
			// x : block scope
		}
		Object y = new Object();
		{
			// block scope
			y = new Object(); 
		} 
	}
	
}

class Classroom {
	// static : class scope
	// shared value across all my instances
	static String dean;
	// instance
	List<String> student;	
}

