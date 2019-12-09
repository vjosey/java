package com.skillstorm.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "ARTIST")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTISTID")
	private int id;
	
	/**
	 * JSR-303 (java specification for bean validation)
	 * javax.validation.constraints (Oracle)
	 * org.hibernate.validator.contraints (Hibernate)
	 * 
	 * Spring: @Valid
	 */
	@NotBlank
	//@Email // regex  string@string.domain
	@Column(name = "NAME")
	private String name;
	//private Manager manager;

	public Artist() {
		super();
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
		// if(name == null) throw new IllegalArgumentException();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}

}
