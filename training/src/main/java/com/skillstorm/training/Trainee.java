package com.skillstorm.training;

public class Trainee {

	private int id;
	private String name;
	private String major;

	public Trainee() {
		super();
	}

	public Trainee(int id, String name, String major) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", major=" + major + "]";
	}

}
