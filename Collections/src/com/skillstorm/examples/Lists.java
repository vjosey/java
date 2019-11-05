package com.skillstorm.examples;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * Generics provide compile-time safety
 * 
 * ArrayList
 * LinkedList
 * Vector
 * 
 * HashSet
 * TreeSet
 * 
 * HashMap
 * HashTable
 * 
 * 
 * 
 * 
 */
public class Lists {

	public static void main(String[] args) {
		// pre Java 7
		Jar<Pickle> pickleJar = new Jar<Pickle>();
		List<Stormer> trainees = new LinkedList<>();

		trainees.add(new Stormer("Karim"));
		pickleJar.add(new Stormer("Mike"));
		pickleJar.add(new Pickle());

		// wrapper classes
		List<Integer> integers = new LinkedList<>(); // int
		Boolean b;
		Byte bb;
		Character c;
		Boolean.getBoolean("true");
		Integer.parseInt("5");

		// box
		Integer i = new Integer(11);

		// unbox
		int value = i.intValue();

		// autoboxing
		i = value;
		value = i;
		i = 5;
		value = 5;
	}

	// Tiger
	public void preJava5() {
		LinkedList list = new LinkedList();
		list.add(new Stormer("Victor"));
		list.add(new Pickle());

		for (Object object : list) {
			if (object instanceof Stormer)
				System.out.println(((Stormer) object).name);
		}
	}

}

// Jar is a generic class, use E as a placeholder
class Jar<E> {
	private Object[] values = new Object[1];

	public void add(E element) {
		values[0] = element;
	}
}

/*
 * Comparable = Natural Ordering (SortedSet, TreeSet, TreeMap, Collections.sort, ..)
 * Comparator = other ways to sort (Collections.sort)
 */
class Trainee implements Comparable<Trainee> {

	// inner classes
	class TraineeNameComparator implements Comparator<Trainee> {

		@Override
		public int compare(Trainee o1, Trainee o2) {
			return o1.name.compareTo(o2.name);
		}

	}// end class

	// static inner class (nested classes)
	static class TraineeNameAscComparator implements Comparator<Trainee> {
		
		@Override
		public int compare(Trainee o1, Trainee o2) {
			return o2.name.compareTo(o1.name);
		}
	}// end class

	/**
	 * Natural order : default sort order
	 */
	@Override
	public int compareTo(Trainee other) {
		return this.age - other.age;
	}

	public String name;
	public int age;
	public int height;

	public Trainee(String name) {
		super();
		this.name = name;
	}

	public Trainee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trainee other = (Trainee) obj;
		if (age != other.age)
			return false;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trainee [name=" + name + "]";
	}

}

class Pickle {
}