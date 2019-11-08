package com.skillstorm.example;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit testing: testing the smallest "unit" in an app
 * 	Testing every single method in our app - 100% code coverage 
 * 
 * @author PWalsh
 *
 */

//@RunWith(SomeKindOfRunner.class)
// Must end in "Test" for a Maven install to run the test*
/**
 * Setup : load sample data (database, XML, etc)
 * Test : the code works
 * Teardown : wipe test data
 * 
 * Transient tests: every @Test gets a fresh data set
 * 
 */
public class HelloJUnitTest {
	
	LinkedList testData;
	
	// once for ALL tests
	@BeforeClass
	public static void beforeCla() {
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void afterCla() {
		System.out.println("AfterClass");
	}
	
	@After
	public void after() {
		System.out.println("After");
		//teardownTestDataToPrepareACleanSlateForTheNextTest();
		testData = null;
	}
	
	@Test
	public void testingMyMethod() {
		// run your test
		System.out.println("Test 1");
	}
	
	@Before
	public void before() {
		System.out.println("Before");
		//initializeTestDataForEachTest();
		testData = new LinkedList();
		testData.add(new Object());
	}
	
	@Test
	public void testinMyMethod() {
		// run your test
		System.out.println("Test 2");
	}
	
	
	
}





