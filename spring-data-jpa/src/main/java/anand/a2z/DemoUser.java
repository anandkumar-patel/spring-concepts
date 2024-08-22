package anand.a2z;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "password", "aadhaar" })
public class DemoUser {
	private String name;
	private String email;
	private String password;
	private String aadhaar;
	@JsonIgnore
	private String pan;
	
	public DemoUser() {
	}

	public DemoUser(String name, String email, String password, String aadhaar,String pan) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.aadhaar = aadhaar;
		this.pan = pan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	@Override
	public String toString() {
		return "DemoUser [name=" + name + ", email=" + email + ", password=" + password + ", aadhaar=" + aadhaar
				+ ", pan=" + pan + "]";
	}
	
}
