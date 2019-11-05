package com.skillstorm.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Examples {

	public static void main(String[] args) throws FileNotFoundException {
		// unchecked exception
		int[] arr = new int[2];
		arr[3] = 5;
		String n = null;
		//System.err.println(n.toUpperCase());
		// checked exception
		//FileInputStream file = new FileInputStream("somefile");
		try {
			new FileManager();
			System.out.println("Will not print");
		} catch (SQLException e) {
			System.out.println("Catch");
			// log it, retry, rethrow
		}
	}

}

class FileManager {
	// throws declaration
	public FileManager() throws SQLException {
		if (true) {
			throw new SQLException();
		}
	}
}
