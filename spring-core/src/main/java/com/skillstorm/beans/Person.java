package com.skillstorm.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

	/**
	 * If more than one object in this Spring Container 
	 * implements this interface, we need qualifiers
	 * 
	 * @author PWalsh
	 *
	 */
	@Autowired
	@Qualifier("craycray")
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
