package com.skillstorm.enthuware;

/**
 * Java === Pass by value
 * 
 * @author PWalsh
 *
 */
public class Example2 {

	public static void main(String[] args) {

		D d = new D();
		Integer y = 5;
		d.go(y);
		System.out.println(y);

	}
}

class D {

	Integer y = 0;

	public void go(Integer y) {
		y = 100;
	}

}
