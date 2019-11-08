package com.skillstorm.enthuware;

public class Example3 {
	public static void main(String[] args) {
		Pickle pickle = new Pickle();
		pickle.size = 5;
		Jar jar = new Jar();
		pickle = jar.go(pickle);
		System.out.println(pickle.size);
	}
}

class Jar {
	public Pickle go(Pickle pickle) {
		pickle = new Pickle();
		pickle.size = 100;
		return pickle;
	}
}

class Pickle {
	public int size;
	public Pickle() {
		this.size = 0;
	}
}
