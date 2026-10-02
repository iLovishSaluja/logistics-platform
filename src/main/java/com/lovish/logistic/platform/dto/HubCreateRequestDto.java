package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.dto.AddressDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class HubCreateRequestDto {

	@NotBlank(message = "Hub name is required")
	@Size(max = 100, message = "Hub name cannot exceed 100 characters")
	private String name;

	@NotBlank(message = "Hub code is required")
	@Size(max = 30, message = "Hub code cannot exceed 30 characters")
	private String code;

	@NotNull(message = "Hub address is required")
	@Valid
	private AddressDto address;

	public HubCreateRequestDto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}
}