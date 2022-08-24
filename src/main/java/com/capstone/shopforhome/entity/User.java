package com.capstone.shopforhome.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//private long id;
	private String email;
	private String name;
	private String address;
	private long contactNumber;
	private String password;
	private String role;
	
	public User() {
		super();
	}
	
	
	public User(String email, String name, String address, long contactNumber, String password, String role) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", password=" + password + ", role=" + role + "]";
	}
	
	
}
