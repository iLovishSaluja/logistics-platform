package com.lovish.logistic.platform.dto;

import jakarta.validation.constraints.NotBlank;

public class EmergencyAssignmentRequestDto {

	@NotBlank(message = "Delivery agent ID is required")
	private String deliveryAgentId;

	public String getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(String deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}
}