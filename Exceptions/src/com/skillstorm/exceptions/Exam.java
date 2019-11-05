package com.skillstorm.exceptions;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Exam {

	public static void main(String[] args) {
		try {
			throw new AccountOverdraftException();
		}

		catch (AccountOverdraftException e) {
			System.out.println(1_000);
			//System.exit(0); // finally does not run
			
		} catch (BankException e) {
			System.out.println(500);
		} catch (Exception e) {
			System.out.println(300);
		}
		finally {
			System.out.println("Finally");
			
			// runs if there's an exception
			// also if there wasn't an exception
		}
	}

	public static void run() throws SQLException {
		try {
			go();
			// multi-catch
		} catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
			System.out.println("bounds");
		}
	}

	public static void go() throws SQLException {
		if (true) {
			// throw new SQLException();
		}
	}

}
