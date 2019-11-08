package com.skillstorm.enthuware;

public class Constructors {
	public static void main(String[] args) {
		B b = new B(5);
		System.out.println(b.x);
	}
}

class A {
	public int x;
	public A(int x) {
		this.x = x;
	}
}

class B extends A {
	public B() {
		this.x = 10;
	}
	public B(int x) {
		super();
		this.x = x;
	}
}
