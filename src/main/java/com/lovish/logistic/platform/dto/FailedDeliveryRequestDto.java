package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.FailedDeliveryReason;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FailedDeliveryRequestDto {

	@NotNull(message = "Failure reason is required")
	private FailedDeliveryReason reason;

	@Size(max = 500, message = "Notes cannot exceed 500 characters")
	private String notes;

	public FailedDeliveryReason getReason() {
		return reason;
	}

	public void setReason(FailedDeliveryReason reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}