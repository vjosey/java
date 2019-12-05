package com.skillstorm.beans;

public class Pencil implements WritingUtensil {

	@Override
	public void write(String str) {
		System.out.println(str);
	}

}
