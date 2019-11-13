package com.skillstorm.jdbc.example;

import java.io.Closeable;

public interface Pickleable {
	public void pickle(int x);
}

interface Wonderful {
	public void pickle();
}

interface Eatable extends Pickleable, Wonderful {
	public void eat();
}

class Cucumber implements Eatable {

	@Override
	public void pickle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pickle(int x) {
		// TODO Auto-generated method stub
		
	}
	
}