package com.skillstorm.files;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropsExample {

	private Properties props = new Properties();
	
	public PropsExample() {
		try {
			props.load(new FileInputStream("application.properties"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		PropsExample ex = new PropsExample();
		System.out.println(ex.props.get("hello"));
	}
	
}
