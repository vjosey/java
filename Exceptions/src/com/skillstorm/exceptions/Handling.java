package com.skillstorm.exceptions;

public class Handling {

	public static void main(String[] args) {
		try { 
			// risky
			//throw new Exception();
			go();
			System.out.println("Yo");
		}catch(Exception e) {
			// recovery procedure
		}
		
	}
	
	public static void go() throws Exception{}
	
}
