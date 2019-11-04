package com.skillstorm.review;

/*
 * Blueprint
 * 
 * Generalization -> Specialization
 * 
 * Abstract class: BE something
 * Interface: DO something
 * 
 */
public class Abstraction {
	//Moveable obj = new Furniture();
}

abstract class Furniture implements Moveable{
	String style;
	String material;
	String legs;
	public void move() {
		// not fun
	}
	public abstract void place(Object obj);
}

interface Moveable {
	public void move();
}



