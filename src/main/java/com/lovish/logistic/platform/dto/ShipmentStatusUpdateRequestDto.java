package com.lovish.logistic.platform.dto;

import com.lovish.logistic.platform.enums.ShipmentStatus;

import jakarta.validation.constraints.NotNull;

public class ShipmentStatusUpdateRequestDto {

	@NotNull(message = "Status is required")
	private ShipmentStatus status;

	public ShipmentStatusUpdateRequestDto() {
		super();
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}
}