package com.skillstorm.threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {
		Thread producer = new Thread(() -> {
			while (true) {
				Random r = new Random();
				int x = r.nextInt();
				try {
					//Thread.sleep(1000);
					queue.put(x);
				} catch (InterruptedException e) {
				}
			}
		});

		Thread consumer = new Thread(() -> {
			while (true) {
				try {
					//Thread.sleep(1000);
					System.out.println(queue.take() + " queue size:" + queue.size());
				} catch (InterruptedException e) {}
			}
		});

		producer.start();
		consumer.start();
		
	}

}
