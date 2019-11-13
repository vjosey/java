package com.skillstorm.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;

import com.skillstorm.jdbc.example.Artist;

import org.junit.*;

public class ArtistDAOTest {
	
	private static ArtistDAO dao = new ArtistDAO();
	
	@Test
	@Ignore
	public void testFindAll() {
		try {
			assertEquals(279, dao.findAll().size());
			System.out.println("Found all :)");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testfindById() {
		Artist expected = new Artist(1, "AC/DC");
		try {
			Artist actual = dao.findByArtistId(1);
			System.out.println(actual);
			
			assertTrue(expected.equals(actual));
			
			assertEquals(expected, actual);
		} catch (SQLException e) {
			System.out.println(e);
			Assert.fail();
		}
	}
	
	@Test
	public void testDelete() {
		try {
			dao.delete(277);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Transient tests... 
	 */
	@Test
	@Ignore // 
	public void testSave() {
		// 0 is overwritten by the generated key
		Artist artist = new Artist(0, "The Temptations");
		Artist obj = null;
		try {
			obj = dao.save(artist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj);
	}

}
