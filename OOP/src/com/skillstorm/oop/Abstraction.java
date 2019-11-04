package com.skillstorm.oop;

public class Abstraction {

	public static void main(String[] args) {
		//Animal a = new Animal();
		
		// Covariant
		Animal dan = new Dog();
		Dog c = (Dog)((Animal) new Cat());
		c.playFetch();
		//Cat cat = new Animal();
		
		// Virtual Method Invocation
		dan.speak();
		dan.talk();
		
		Math.pow(2, 5);
		System.out.println(dan.count);
		
		Animal d = (Animal) c; //casting changes the reference to an object
		d.speak();
		
	}
	
	public void pet(Animal a) {
		// pet
	}
	
}
