package hibernate;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import beans.Artist;
import data.ArtistDAO;

public class ArtistDAOTest {

	ArtistDAO dao = new ArtistDAO();
	
	@Test
	@Ignore
	public void testInsert() {
		Artist obj = new Artist("Yellow Pickle Running");
		dao.insert(obj);
		System.out.println("Yay");
	}
	
	@Test
	@Ignore
	public void testFindName() {
		System.out.println(dao.findByName("AC/DC"));
	}
	
	@Test
	@Ignore
	public void testSearchName() {
		System.out.println(dao.searchByName("z"));
	}
	
	@Test
	@Ignore
	public void testFindById() {
		System.out.println(dao.findById(9_001));
	}
	
	@Test
	public void testFindAll() {
		Date start = new Date();
		System.out.println(dao.findAll().size());
		Date end = new Date();
		System.out.println(end.getTime() - start.getTime());
		
		// 2nd pass
		start = new Date();
		System.out.println(dao.findAll().size());
		end = new Date();
		System.out.println(end.getTime() - start.getTime());
	}
	
}
