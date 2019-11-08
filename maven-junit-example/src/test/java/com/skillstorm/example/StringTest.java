// comment
/**
 * 
 */
/*
 * 
 */
package com.skillstorm.example;

import org.junit.Assert;
import org.junit.Test;

// static import
// allow us to call static methods without referencing the class name
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.*;
import static java.lang.Math.*;

import com.skillstorm.hello.MyString;

public class StringTest {

	@Test
	public void reverse() {
		pow(1, 3);
		String normal = "Hello";
		String reversed = "olleH";
		
		// expected
		// reversed == reverse("Hello")
		MyString str = new MyString(normal);
		
		// expected, actual
		assertEquals(reversed, str.reverse());
		
		// palindrone is same when I reverse it
		MyString str2 = new MyString("racecar");
		assertEquals(str2.toString(), str2.reverse());
		
	}
	
}
