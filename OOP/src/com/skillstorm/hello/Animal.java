package com.skillstorm.hello;

/**
 * Definition of an object. 
 * 
 * State: attributes, fields, variables
 * Behavior: methods, functions
 * 
 * @author PWalsh
 *
 */
public class Animal {

	/*
	 * Primitive Data Types
	 */
	// -2b -> +2b
	int legs;
	
	double weight; 
	float height; 
	
	long cells;
	// 32,000
	short age; 
	
	boolean alive; 
	char gender = 'A';
	byte bit;
	
	// String class
	//String fname = new String("Dan");
	final String fname = "Daniel";
	String lname = "Dan";
	
	public static void main(String[] args) {
		Animal dan = new Animal();
		System.out.println(dan.fname == dan.lname); // false
		System.out.println(dan.fname.equals(dan.lname)); // true
		String a = "a" + "b" + "c"; // no
		
		// mutable String
		StringBuilder str = new StringBuilder();
		str.append("a").append("b").append("c");
		// abc
		System.out.println(a);
	}
	
}







