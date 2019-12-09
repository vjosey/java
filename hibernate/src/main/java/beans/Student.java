package beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "FULL_NAME", nullable = false)
	private String fullName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "COURSE_ENROLLMENT", joinColumns = @JoinColumn(name = "STUDENT_ID"), 
				inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	// create a table, create 2 columns, makes a Junction table (associative entity)
	private Set<Course> courses;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "LAPTOP_ID")
	private Laptop laptop; // uni-directional

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + "]";
	}

}
