package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AddressDto {

	@NotBlank(message = "Full name is required")
	@Size(max = 100, message = "Full name must not exceed 100 characters")
	private String fullName;

	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number must be a valid 10-digit Indian mobile number")
	private String phoneNumber;

	@NotBlank(message = "Address line is required")
	@Size(max = 250, message = "Address line must not exceed 250 characters")
	private String addressLine;

	@NotBlank(message = "City is required")
	@Size(max = 100, message = "City must not exceed 100 characters")
	private String city;

	@NotBlank(message = "State is required")
	@Size(max = 100, message = "State must not exceed 100 characters")
	private String state;

	@NotBlank(message = "Postal code is required")
	@Pattern(regexp = "^[1-9][0-9]{5}$", message = "Postal code must be a valid 6-digit Indian PIN code")
	private String postalCode;

	@NotBlank(message = "Country is required")
	@Size(max = 100, message = "Country must not exceed 100 characters")
	private String country;

	public AddressDto(String fullName, String phoneNumber, String addressLine, String city, String state,
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

	public AddressDto() {
		super();
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
