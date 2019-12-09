package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Oracle Java Spec: 
 * Java Persistence API (JPA)
 * JPA - Oracle ORM Framework
 * JPA spec: Hibernate conforms to the way JPA does Entity mapping
 *  
 * @author PWalsh
 *
 */
@Entity // Hibernate will manage this object(s)
@Table(name = "ARTIST")
public class Artist {

	@Id // this is the primary key of the table
	@Column(name = "ARTISTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name = "ARTIST_ID")
	private int id;
	
	@Column(name = "NAME")
	private String name;

	public Artist() {
		super();
	}

	public Artist(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]";
	}

}
