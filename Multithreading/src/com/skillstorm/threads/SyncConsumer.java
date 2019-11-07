package com.skillstorm.threads;

import java.util.LinkedList;
import java.util.Queue;

public class SyncConsumer {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		// producer
		queue.add(1); queue.add(41); queue.add(19);
		
		// consumer
		queue.poll().compareTo(0);
		queue.poll().compareTo(0);
		queue.poll().compareTo(0);
		queue.poll().compareTo(0);
	}
	
}
