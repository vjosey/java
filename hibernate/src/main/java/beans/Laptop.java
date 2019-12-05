package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAPTOP_ID")
	private int id;
	
	@Column(name = "BRAND")
	private String brand;
	
	@Column(name = "OPERATING_SYSTEM")
	@Enumerated(EnumType.STRING) // "LINUX" .. Ordinal 0,1,2
	private OperatingSystem os;
	
	public Laptop() {
		super();
		this.os = OperatingSystem.WINDOWS;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public OperatingSystem getOs() {
		return os;
	}
	public void setOs(OperatingSystem os) {
		this.os = os;
	}
	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", os=" + os + "]";
	}
	
	
}
