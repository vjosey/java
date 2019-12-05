package com.skillstorm.beans;

public class Person {

	private WritingUtensil utensil;
	
	public void write(String str) {
		utensil.write(str);
	}
	
	public Person() {
		super();
	}

	public Person(WritingUtensil utensil) {
		super();
		this.utensil = utensil;
	}

	public void setUtensil(WritingUtensil utensil) {
		this.utensil = utensil;
	}
	
}
