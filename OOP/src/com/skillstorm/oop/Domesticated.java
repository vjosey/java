package com.skillstorm.oop;

/**
 * 100% abstract
 * 
 * Interfaces define a role, an action
 * 
 * @author PWalsh
 *
 */
public interface Domesticated {
	public static final int legs = 1;
	public abstract void play();
	
	// Java 8 +
	default void run() {
		System.out.println("Implementation in an interface???");
	}
}
