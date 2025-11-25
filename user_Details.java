package com.user.DTO;

public class user_Details {
	private String name;
	private String email;
	private long mobile;
	private String password;
	private String address;
	private String gender;
	public user_Details() {
		
	}
	public user_Details(String name, String email, long mobile, String password, String address, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.address = address;
		this.gender = gender;
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "user_Details [name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", address=" + address + ", gender=" + gender + "]";
	}
	
}
