package com.skillstorm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	
	/*
	 * when Lazy fetching. eager automatically joins
	 * @Query(value = "from com.skillstorm.beans.Artist a inner join a.manager m") 
	 * public void findWithManager();
	 */
	
}






