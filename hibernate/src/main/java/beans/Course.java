package beans;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Course {

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "START_DATE")
	@Temporal(TemporalType.DATE)  // 2019-DEC-04
	private Date start;
	
	@Column(name = "END_DATE")
	@Temporal(TemporalType.DATE)
	private Date end;
	
	@OneToMany(mappedBy = "course") // NO FK here, look at the other side
	private Set<Textbook> books;
	
	@ManyToMany(mappedBy = "courses") // look for the mapping on the other side
	private Set<Student> students;
	
	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Set<Textbook> getBooks() {
		return books;
	}

	public void setBooks(Set<Textbook> books) {
		this.books = books;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", start=" + start + ", end=" + end + "]";
	}

	
	
}
