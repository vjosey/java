package com.skillstorm.hello;

public class MyString {

	private String value;

	public MyString(String str) {
		this.value = str;
	}

	public String reverse() {
		//return new StringBuilder(value).reverse().toString(); // not interview-friendly
		StringBuilder reversed = new StringBuilder();
		for (int pos = value.length() - 1; pos >= 0; pos--) {
			reversed.append(value.charAt(pos));
		}
		return reversed.toString();
	}
	
	@Override
	public String toString() {
		return value;
	}

}
