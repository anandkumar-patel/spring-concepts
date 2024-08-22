package anand.a2z;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class DemoAddress {
	private String street;
	private String city;

	@JsonBackReference
	private DemoPerson person;

	public DemoAddress() {
	}
	
	public DemoAddress(String street, String city, DemoPerson person) {
		this.street = street;
		this.city = city;
		this.person = person;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DemoPerson getDemoPerson() {
		return person;
	}

	public void setDemoPerson(DemoPerson person) {
		this.person = person;
	}
}