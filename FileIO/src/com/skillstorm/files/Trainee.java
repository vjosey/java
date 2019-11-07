package com.skillstorm.files;

public class Trainee {

	private String name;
	private String major;
	private int experience;

	public Trainee() {
		super();
	}

	public Trainee(String name, String major, int experience) {
		super();
		this.name = name;
		this.major = major;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Trainee [name=" + name + ", major=" + major + ", experience=" + experience + "]";
	}

}
