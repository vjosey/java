package com.skillstorm.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UnitOfWork {

	public static void main(String[] args) {
		Connection conn = null;		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chinook", "root", "root");
			// UNIT OF WORK
			conn.setAutoCommit(false); //enable transactions
			
			Statement st = conn.createStatement();
			st.executeUpdate("insert into artist values (500, 'Green Whale Crying')");
			
			st.executeUpdate("insert into album(title, artistId) values "
					+ "('E3EE$WAX', 499)");
			
			conn.commit(); // COMMIT
		} 
		// BOILERPLATE CODE
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback(); // ROLLBACK
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
