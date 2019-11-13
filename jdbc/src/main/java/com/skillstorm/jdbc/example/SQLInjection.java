package com.skillstorm.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjection {
	
	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "root");
		// web ui ---  harolda' union@gmail.com
		String input = "a' union"; // input is precompiled. SELECT
		PreparedStatement stmt = conn.prepareStatement("select firstname, lastname, email" 
				+ " from customer where email LIKE ?"); // ? placeholder
		// parameterized query
		stmt.setString(1, "%"+input+"%"); // bind INPUT variable to the ? parameter
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) 
				+ " " + rs.getString(3));
		}
	}

	public static void foo(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "root");
		// web ui
		String input = "a' union select firstname, lastname, email from employee -- "; 
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select firstname, lastname, email" 
				+ " from customer where email LIKE '%" + input + "%'");
		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) 
				+ " " + rs.getString(3));
		}

	}

}
