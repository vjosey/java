package com.skillstorm.files;

import java.util.List;

public class Application {

	public static void main(String[] args) {
		ReadingAndWritingComponent comp = new ReadingAndWritingComponent();
		comp.write(new Trainee("Dan Pickles", "IT", 1_000));
		System.out.println("Done");
	}
	
	public static void bulkWrite() {
		ReadingAndWritingComponent comp = new ReadingAndWritingComponent();
		List<Trainee> trainees = comp.read();
		
		// do something
		for (Trainee trainee : trainees) {
			System.out.println(trainee);
		}
		
		comp.write(trainees);
	}
	
}
