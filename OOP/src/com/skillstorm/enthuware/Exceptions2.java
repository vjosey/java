package com.skillstorm.enthuware;

public class Exceptions2 {

	public static void main(String[] args) throws F {
		go();
		System.out.println(" World");
	}
	
	public static void go(){
		try {R r = new R();} 
		catch (Q e) {System.out.print("Hello");}
	}	
}
class R {
	R() throws Q {
		throw new Q(); // creates and exception.. stops execution. JVM looks for handler
	}
}
class F extends Exception {}
class P extends RuntimeException {} 
class Q extends F {}
