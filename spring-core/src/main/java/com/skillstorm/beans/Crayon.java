package com.skillstorm.beans;

public class Crayon implements WritingUtensil {

	@Override
	public void write(String str) {
		System.err.println(str);
	}

}
