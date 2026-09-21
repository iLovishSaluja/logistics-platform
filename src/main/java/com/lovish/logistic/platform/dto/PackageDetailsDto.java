package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

public class PackageDetailsDto {

	@DecimalMin(value = "0.01", message = "Weight must be greater than 0")
	private Double weight;

	@DecimalMin(value = "0.01", message = "Length must be greater than 0")
	private Double length;

	@DecimalMin(value = "0.01", message = "Width must be greater than 0")
	private Double width;

	@DecimalMin(value = "0.01", message = "Height must be greater than 0")
	private Double height;

	@Size(max = 500, message = "Description must not exceed 500 characters")
	private String description;

	public PackageDetailsDto() {
		super();
	}

	public PackageDetailsDto(Double weight, Double length, Double width, Double height, String description) {
		super();

		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
		this.description = description;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
