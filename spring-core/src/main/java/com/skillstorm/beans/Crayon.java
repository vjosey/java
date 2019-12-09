package com.skillstorm.beans;

import org.springframework.stereotype.Component;

@Component(value = "craycray")
public class Crayon implements WritingUtensil {

	@Override
	public void write(String str) {
		System.err.println(str);
	}

}
