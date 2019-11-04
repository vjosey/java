package com.skillstorm.oop;

/**
 * Inheritance: reuse the state and behavior of a parent class
 * 
 * @author PWalsh
 *
 */
public final class Dog extends Animal {

	public void playFetch() {
		System.out.println("FETCH");
	}
	
	public static void talk() {
		System.out.println("DOGTALK");
	}

	public void birthday() {
		this.setAge(this.getAge() + 1);
	}
	
	public void changeLegs(int legs) {
		this.legs = legs;
	}

	/**
	 * Override: Same method signature as a method in a parent class
	 */
	@Override
	public void speak() {
		System.out.println("Bark");
	}
	
	// Overloaded: same method name, different params, different order of params
	public void speak(String word) {
		System.out.println(word);
	}
	
	public void speak(int x, String word) {
		System.out.println(word);
	} // obj.speak(5, "word");
	
	public void speak(String word, int... x) {
		System.out.println(word);
		for (int i = 0; i < x.length; i++) {
			System.out.println(x[i]);
		}
	} // obj.speak("word", 5,6,7,8,9);
	
}






