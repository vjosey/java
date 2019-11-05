package com.skillstorm.examples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class SortingCollections {
	public static int num;
	
	// static block
	static {
		// initialize static variables
		num = 15;
		System.out.println("Static block");
	}
	
	// instance blocks
	{
		System.out.println("Instance block");
		
		{
			// readability
			int x =10;
		}
		x++; // block scope
	}
	

	public static void main(String[] args) {
		// sorting must be in a List
		List<Trainee> list = new LinkedList<>();
		list.add(new Trainee("Loi", 42));
		list.add(new Trainee("Suraj", 21));
		list.add(new Trainee("Jeff", 2_000));
		
		// inner class
		Trainee.TraineeNameComparator comparator =
				new Trainee("").new TraineeNameComparator();
		
		// static inner class
		// outer class.inner class
		Trainee.TraineeNameAscComparator comp = new Trainee.TraineeNameAscComparator();
		
		Collections.sort(list, comparator);
		
		for (Trainee trainee : list) {
			System.out.println(trainee);
		}
		// override the natural order with a Comparator
		new TreeSet<>(comparator);
	}
	
}
