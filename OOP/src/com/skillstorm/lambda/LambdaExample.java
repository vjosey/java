package com.skillstorm.lambda;

public class LambdaExample {

	public static void main(String[] args) {
		function(temp -> {
			System.out.println(temp + 10);
		});
	}
	
	public static void function(Goable go) {
		go.go(5);
	}
	
}

// Functional interface?
interface Goable {
	public void go(int x);
}
