package com.lovish.logistic.platform.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CodCollectionRequestDto {

	@NotNull(message = "Collected amount is required")
	@DecimalMin(value = "0.01", message = "Collected amount must be greater than zero")
	private BigDecimal collectedAmount;

	@Size(max = 500, message = "Collection notes cannot exceed 500 characters")
	private String notes;

	public CodCollectionRequestDto() {
	}

	public BigDecimal getCollectedAmount() {
		return collectedAmount;
	}

	public void setCollectedAmount(BigDecimal collectedAmount) {
		this.collectedAmount = collectedAmount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}