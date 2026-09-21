package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.Priority;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

public class PriceEstimateRequestDto {

	@NotNull(message = "Weight is required")
	@DecimalMin(value = "0.01", message = "Weight must be greater than 0")
	private Double weight;

	@NotNull(message = "Distance is required")
	@DecimalMin(value = "0.0", message = "Distance cannot be negative")
	private Double distanceKm;

	@NotNull(message = "Priority is required")
	private Priority priority;

	private boolean cod;

	public PriceEstimateRequestDto() {
		super();
	}

	public PriceEstimateRequestDto(Double weight, Double distanceKm, Priority priority, boolean cod) {

		super();

		this.weight = weight;
		this.distanceKm = distanceKm;
		this.priority = priority;
		this.cod = cod;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(Double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public boolean isCod() {
		return cod;
	}

	public void setCod(boolean cod) {
		this.cod = cod;
	}
}