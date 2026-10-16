package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.Size;

public class CodSettlementRequestDto {

	@Size(max = 500, message = "Notes cannot exceed 500 characters")
	private String notes;

	public CodSettlementRequestDto() {
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}