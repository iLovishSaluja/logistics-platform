package com.lovish.logistic.platform.entity;

public class Address {

	private String fullName;
	private String phoneNumber;
	private String addressLine;
	private String city;
	private String state;
	private String postalCode;
	private String country;

	public Address() {
		super();
	}

	public Address(String fullName, String phoneNumber, String addressLine, String city, String state,
			String postalCode, String country) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
