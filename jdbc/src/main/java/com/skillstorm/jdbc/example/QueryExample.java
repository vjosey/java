package com.skillstorm.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class QueryExample {

	public static void main(String[] args) throws SQLException {
		// 1. Get a connection
		Connection conn = 
				DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/chinook", "root", "root");
		// 2. Statement
		Statement stmt = conn.createStatement(); 
		String sql = "select * from artist";
		
		// 3. Iterate thru ResultSet
		ResultSet rs = stmt.executeQuery(sql);
		List<Artist> results = new LinkedList<>();
		while(rs.next()) {
			Artist a = new Artist(rs.getInt("artistId"), rs.getString("name"));
			results.add(a);
		}
		conn.close();
		System.out.println(results);
	}
	
}
