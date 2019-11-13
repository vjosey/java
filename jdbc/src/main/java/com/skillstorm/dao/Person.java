package com.skillstorm.dao;

public class Person {
	
	String eyes;
	int weight;

	public static PersonBuilder builder() {
		return new Person.PersonBuilder();
	}
	
	static class PersonBuilder {
		private Person person = new Person();
		public PersonBuilder eyes(String colour) {
			this.person.eyes = colour;
			return this;
		}
		public PersonBuilder weight(int i) {
			this.person.weight = i;
			return this;
		}
		public Person build() {
			return this.person;
		}
	}

}
