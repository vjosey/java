package com.skillstorm.review;

public class Polymorphism {
	public static void main(String[] args) {
		// 1. Covariant
		Animal a = new Dog();
		// 2. Virtual Method Invocation
		a.speak();
	}
}
// Method Overriding
class Animal {
	public void speak() {
		System.out.println("Yo");
	}
	// overloaded
	public void speak(String word) {
		System.out.println(word);
	}
	
}

class Dog extends Animal {
	public void speak() {
		System.out.println("Bark");
	}
}

class Cat extends Animal {
	public void speak() {
		System.out.println("Meow");
	}
}