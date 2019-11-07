package com.skillstorm.threads;

import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

	// private static Object lock1 = new Object();
	// private static Object lock2 = new Object();
	private static ReentrantLock lock1 = new ReentrantLock();
	private static ReentrantLock lock2 = new ReentrantLock();

	public static void main(String[] args) {
		new Thread(() -> {
			while (!lock1.tryLock() || !lock2.tryLock()) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// do what I need
			System.out.println("Thread 1 Done!");
			lock1.unlock();
			lock2.unlock();

			/*
			 * synchronized (lock1) { try { Thread.sleep(1000); } catch
			 * (InterruptedException e) {} System.out.println("Thread A getting lock2...");
			 * synchronized (lock2) { System.out.println("Thread 1 Done!"); } }
			 */
		}).start();

		new Thread(() -> {
			while (true) {
				if (lock2.tryLock() && lock1.tryLock()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// do what I need
			System.out.println("Thread 2 Done!");
			lock2.unlock();
			lock1.unlock();

			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) {}
			 * System.out.println("Thread B getting lock1..."); synchronized (lock1) {
			 * System.out.println("Thread 2 Done!"); }
			 */
		}).start();
		System.out.println("Main done");
	}

}
