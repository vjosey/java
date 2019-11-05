package com.skillstorm.exceptions;

public class OCA {

	public static void main(String[] args) {
		try {
			if (true) {
				throw new B();
			} else {
				throw new C();
			}
		} catch (C b) {
			System.out.println("B");
		} catch (A a) {
			System.out.println("A");
		}

	}

}

class A extends Exception {
}

class B extends A {
}

class C extends A {
}