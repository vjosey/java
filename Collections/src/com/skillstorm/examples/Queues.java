package com.skillstorm.examples;

import java.util.Deque;
import java.util.LinkedList;

public class Queues {

	public static void main(String[] args) {
		Deque<Trainee> q = new LinkedList<>();
		q.add(new Trainee("Shaun"));
		q.add(new Trainee("Cedric"));
		q.add(new Trainee("Leevanni"));
		
		for (Trainee trainee : q) {
			System.out.println(trainee);
		}
		System.out.println("--------------");
		
		Trainee polled = q.pollLast();
		
		System.out.println("Got: " + polled);
		System.out.println("--------------");
		
		for (Trainee trainee : q) {
			System.out.println(trainee);
		}
		
		Trainee polled = q.pollLast();
		
	}
	
}


class Task implements Comparable<Task>{
	int importance;

	@Override
	public int compareTo(Task o) {
		return 0;
	}
	
}




