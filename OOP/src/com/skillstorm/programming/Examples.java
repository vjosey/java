package com.skillstorm.programming;

import java.util.Iterator;

public class Examples {

	public static void main(String[] args) {
		byte by = 127;
		by++;
		System.out.println(by);
		
		int mil = 1_000_000;
		byte b = (byte) mil;
		System.out.println(b);
		
		byte bb = 64;
		char c = 'a';
		System.out.println((char)bb);
		
	}

	public void dowhile() {
		int x = 5;
		while (x < 5) {
			System.out.print("While:" + x++);
		}
		
		do {
			System.out.print("Do: " + x);
			x++;
		}while(x < 5);

	}
	
	public boolean tern() {
		int x = 5;
		int y = x > 0 ? x > 5 ? b() : a() : b();
		System.out.println(y);
		// return y==0? true : false;
		if (y == 0) {
			return true;
		} else {
			return false;
		}
		System.out.println(y);
	}

	public static int a() {
		return 0;
	}

	public static int b() {
		return 1;
	}

	void switcharoo() {
		String choice = "B";
		switch (choice) {
		case "A": {
			System.out.println("A");
			break;
		}
		case "B": {
			System.out.println("B");
		}
		default: {
			System.out.println("C");
			break;
		}
		}

	}

	void loops() {
		boolean something = false;
		// sentinel-controlled loop
		while (something) {
			System.out.println("Yes");
		}

		// counter-controlled.. finite
		int[] array = new int[5];
		for (int c = 0; c < array.length; c++) {

		}
		/*
		 * while(true) { if(something) break; }
		 */

		/*
		 * for(;;) { System.out.println("; ;"); }
		 */
		// enhanced for-loop (for each loop)
		// Iterable
		for (int x : array) {
			System.out.println(x);
		}
	}

	void prepost() {
		int x = 0;
		System.out.println(x++ + ++x + --x - x--);
		// 0 + 2 + 1 - 1
	}

	void ifs() {
		boolean val = true;
		int x = 0;

		if (val || ++x > 5) {
			System.out.println(val);
		}

		System.out.println(x);
		x++;
	}

}
