package com.skillstorm.review;

public class Encapsulation {
	// JavaBeans
	// 1. Always encapsulate your model classes
	// 2. getZzzZzz setZzzZzz isBooleanVariable
	// 3. No-arg constructors
}

// related state and behavior together in a protected way
class Medicine {
	private String activeIngredient;

	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void take() {
		System.out.println("Yum");
	}
	
}
