package com.skillstorm.oop;

public class Polymorphism {

	// Polymorphic array
	public static void main(String[] args) {
		Animal[] zoo = new Animal[3];
		zoo[0] = new Cat();
		zoo[1] = new Dog();
		zoo[2] = new Cat();
		
		for (int i = 0; i < zoo.length; i++) {
			zoo[i].speak();
		}
		
	}
	
}
