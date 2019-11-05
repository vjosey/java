package com.skillstorm.exceptions;

import java.sql.SQLException;

public class TryFinally {

	public static void main(String[] args) {
		// java 7 : try-with-resources / try-with
		try(Book book = new Book()) {
			book.read();
		}catch(Exception e){
			System.out.println(e);
		} 	/*
			 * finally { book.close(); }
			 */
	}
	
	public void ew() {
		Book book = new Book();
		try {
			book.read();
		} catch (Exception e) {
			
		}finally {
			try {
				book.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void go() throws SQLException {
		try {
			throw new SQLException("bad stuff");
		}finally {
			System.out.println("Disconnect from DB");
		}
	}	
}

// Resources: databases, files, etc.
class Book implements AutoCloseable{
	public void read() throws Exception{
		System.out.println("Reading book..");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Closing book..");
	}
}




