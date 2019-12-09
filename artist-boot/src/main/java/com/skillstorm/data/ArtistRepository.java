package com.skillstorm.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.beans.Artist;

/**
 * Spring Data JPA: 
 * 	create a session for every thread
 * 	uses a transaction manager to propogate transactions from method to method
 * 	uses Hibernate (sessionFactory, session, transaction, query, crtieria, etc.)
 * 
 * YOU don't write Hibernate, Spring does.
 * query methods and @Query (jpql)
 * 
 * @author PWalsh
 *
 */											// Type, Id type
@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{
	
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	// query methods (findBy)
	public List<Artist> findByName(String name); // WHERE NAME = ?
	public List<Artist> findByNameLike(String name); // WHERE NAME LIKE %?%
	
	// public Artist findByPickleFlavor(String var); // artist.pickle.flavor
	// Person MUST have "firstName" and "lastName" fields
	//public List<Person> findByFirstNameAndLastName(String first, String last);
	
	/*
	 * when Lazy fetching. eager automatically joins
	 * @Query(value = "from com.skillstorm.beans.Artist a inner join a.manager m") 
	 * public void findWithManager();
	 */
	
}






