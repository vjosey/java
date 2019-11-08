package com.skillstorm.enthuware;

import java.util.ArrayList;

public class Exceptions3 {

	public static void main(String[] args) {
		int x = go();
		System.out.println(x);
	}
	public static Integer go(){
		try {
			V r = new V(); 
			return 1;
		} 
		catch (W eeee) {return 5;}
		finally {}
	}	
}
class V {
	V() throws W {
		throw new W();
	}
}
class W extends Exception {}
