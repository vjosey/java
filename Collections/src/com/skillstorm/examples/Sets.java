package com.skillstorm.examples;

import java.util.Set;
import java.util.TreeSet;

public class Sets {

	// HashSet
	// Object.hashCode() memory location
	public static void main(String[] args) {
		// you need to define a "natural order" -- implement Comparable
		Set<Trainee> trainees = new TreeSet<>();
		trainees.add(new Trainee("Yuliya", 24));
		trainees.add(new Trainee("Andrew", 30));
		trainees.add(new Trainee("Yasuhiro", 18));
		
		for (Trainee trainee : trainees) {
			System.out.println(trainee);
		}
		System.out.println(new Trainee("Andrew").equals(new Trainee("Andrew")));
	}
	
}

