package com.skillstorm.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJdbc {

	// java.sql package has the interfaces. Driver jar has concrete classes
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. Load (register) the driver (JDBC 4.0+ optional)
		//Class.forName("com.mysql.jdbc.Driver");
		
		// 2. Get a connection 
		String url = "jdbc:mysql://localhost:3306/chinook";
		String user = "root";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		// 3. Run SQL commands
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO GENRE(NAME) VALUES('Metalcore')";
		int affected = stmt.executeUpdate(sql);
		System.out.println(affected);
		
		conn.close();
	}
	
}
