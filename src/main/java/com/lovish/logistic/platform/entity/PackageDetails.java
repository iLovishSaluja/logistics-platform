package com.lovish.logistic.platform.entity;

public class PackageDetails {

	private Double weight;
	private Double length;
	private Double width;
	private Double height;
	private String description;

	public PackageDetails() {
		super();
	}

	public PackageDetails(Double weight, Double length, Double width, Double height, String description) {
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
