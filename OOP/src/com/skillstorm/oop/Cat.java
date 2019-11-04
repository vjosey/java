package com.skillstorm.oop;

import java.io.Serializable;

public class Cat extends Animal
	implements Domesticated, Cloneable, Serializable{

	// default constructor
	public Cat() {
		// all this cool stuff
		System.out.println("Cat()");
	}
	
	public Cat(boolean nice) {
		this();
	}
	
	@Override
	public void speak() {
		System.out.println("Meow");
	}

	@Override
	public void play() {
		
	}

}
