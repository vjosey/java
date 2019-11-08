package com.skillstorm.enthuware;

import java.io.IOException;

public class Exceptions {

	public static void main(String[] args) {
		try {
			Exceptions e = go();
		}catch (IOException e) {
			System.out.println("IO");
		} 
		catch (RuntimeException e) {
			System.out.println("Runtime");
		} 
		System.out.println("Hello");
	}

	public static Exceptions go() throws RuntimeException, IOException {
		return new Exceptions();
	}

	public Exceptions() throws IOException {
		throw new IOException();
	}
}
